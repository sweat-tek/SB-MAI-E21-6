package org.jhotdraw.samples.svg.figures;
import dk.sdu.mmmi.featuretracer.lib.FeatureEntryPoint;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import java.awt.image.*;
import java.io.*;
import java.util.*;
import javax.imageio.ImageIO;
import javax.swing.*;
import org.jhotdraw.app.JHotDrawFeatures;
import org.jhotdraw.draw.*;
import static org.jhotdraw.samples.svg.SVGAttributeKeys.*;
import org.jhotdraw.samples.svg.*;
import org.jhotdraw.util.*;
import org.jhotdraw.geom.*;

public class SVGImageFigure extends SVGAttributedFigure implements SVGFigure, ImageHolderFigure {
    private Rectangle2D.Double rectangle;
    private transient Shape cachedTransformedShape;
    private transient Shape cachedHitShape;
    private byte[] imageData;
    private BufferedImage bufferedImage;

    public SVGImageFigure() {
        this(0, 0, 0, 0);
    }

    @FeatureEntryPoint(JHotDrawFeatures.IMAGE_TOOL)
    public SVGImageFigure(double x, double y, double width, double height) {
        rectangle = new Rectangle2D.Double(x, y, width, height);
        SVGAttributeKeys.setDefaults(this);
    }

    @Override
    @FeatureEntryPoint(JHotDrawFeatures.IMAGE_TOOL)
    public void draw(Graphics2D g) {
        double opacity = OPACITY.get(this);
        opacity = Math.min(Math.max(0d, opacity), 1d);
        if (opacity != 0d) {
            Composite savedComposite = g.getComposite();
            if (opacity != 1d) {
                g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, (float) opacity));
            }

            BufferedImage image = getBufferedImage();
            if (image != null) {
                if (TRANSFORM.get(this) != null) {
                    Graphics2D gx = (Graphics2D) g.create();
                    gx.setRenderingHints(g.getRenderingHints());

                    gx.transform(TRANSFORM.get(this));
                    gx.drawImage(image, (int) rectangle.x, (int) rectangle.y, (int) rectangle.width, (int) rectangle.height, null);
                    gx.dispose();
                } else {
                    g.drawImage(image, (int) rectangle.x, (int) rectangle.y, (int) rectangle.width, (int) rectangle.height, null);
                }
            } else {
                Shape shape = getTransformedShape();
                g.setColor(Color.red);
                g.setStroke(new BasicStroke());
                g.draw(shape);
            }

            if (opacity != 1d) {
                g.setComposite(savedComposite);
            }
        }
    }

    protected void drawFill(Graphics2D g) {

    }

    protected void drawStroke(Graphics2D g) {

    }

    public double getX() {
        return rectangle.x;
    }

    public double getY() {
        return rectangle.y;
    }

    public double getWidth() {
        return rectangle.width;
    }

    public double getHeight() {
        return rectangle.height;
    }

    public Rectangle2D.Double getBounds() {
        return (Rectangle2D.Double) rectangle.clone();
    }

    @Override
    public Rectangle2D.Double getDrawingArea() {
        Rectangle2D rx = getTransformedShape().getBounds2D();
        Rectangle2D.Double r = (rx instanceof Rectangle2D.Double) ? (Rectangle2D.Double) rx : new Rectangle2D.Double(rx.getX(), rx.getY(), rx.getWidth(), rx.getHeight());
        return r;
    }

    public boolean contains(Point2D.Double p) {
        return getHitShape().contains(p);
    }

    public void setBounds(Point2D.Double anchor, Point2D.Double lead) {
        invalidateTransformedShape();
        rectangle.x = Math.min(anchor.x, lead.x);
        rectangle.y = Math.min(anchor.y, lead.y);
        rectangle.width = Math.max(0.1, Math.abs(lead.x - anchor.x));
        rectangle.height = Math.max(0.1, Math.abs(lead.y - anchor.y));
    }

    public void invalidateTransformedShape() {
        cachedTransformedShape = null;
        cachedHitShape = null;
    }

    public Shape getTransformedShape() {
        if (cachedTransformedShape == null) {
            cachedTransformedShape = (Shape) rectangle.clone();
            if (TRANSFORM.get(this) != null) {
                cachedTransformedShape = TRANSFORM.get(this).createTransformedShape(cachedTransformedShape);
            }
        }
        return cachedTransformedShape;
    }

    private Shape getHitShape() {
        if (cachedHitShape == null) {
            cachedHitShape = new GrowStroke(
                    (float) SVGAttributeKeys.getStrokeTotalWidth(this) / 2f,
                    (float) SVGAttributeKeys.getStrokeTotalMiterLimit(this)).createStrokedShape(getTransformedShape());
        }
        return cachedHitShape;
    }

    public void transform(AffineTransform tx) {
        invalidateTransformedShape();
        if (TRANSFORM.get(this) != null ||
                (tx.getType() & (AffineTransform.TYPE_TRANSLATION | AffineTransform.TYPE_MASK_SCALE)) != tx.getType()) {
            if (TRANSFORM.get(this) == null) {
                TRANSFORM.basicSet(this, (AffineTransform) tx.clone());
            } else {
                AffineTransform t = TRANSFORM.getClone(this);
                t.preConcatenate(tx);
                TRANSFORM.basicSet(this, t);
            }
        } else {
            Point2D.Double anchor = getStartPoint();
            Point2D.Double lead = getEndPoint();
            setBounds(
                    (Point2D.Double) tx.transform(anchor, anchor),
                    (Point2D.Double) tx.transform(lead, lead));
        }
    }

    public void restoreTransformTo(Object geometry) {
        invalidateTransformedShape();
        Object[] o = (Object[]) geometry;
        rectangle = (Rectangle2D.Double) ((Rectangle2D.Double) o[0]).clone();
        if (o[1] == null) {
            TRANSFORM.basicSet(this, null);
        } else {
            TRANSFORM.basicSet(this, (AffineTransform) ((AffineTransform) o[1]).clone());
        }
    }

    public Object getTransformRestoreData() {
        return new Object[]{
            rectangle.clone(),
            TRANSFORM.get(this)
        };
    }

    @Override
    public Collection<Handle> createHandles(int detailLevel) {
        LinkedList<Handle> handles = new LinkedList<Handle>();

        switch (detailLevel % 2) {
            case -1 :
                handles.add(new BoundsOutlineHandle(this,false,true));
                break;
            case 0:
                ResizeHandleKit.addResizeHandles(this, handles);
                handles.add(new LinkHandle(this));
                break;
            case 1:
                TransformHandleKit.addTransformHandles(this, handles);
                break;
            default:
                break;
        }
        return handles;
    }

    @Override
    public Collection<Action> getActions(Point2D.Double p) {
        final ResourceBundleUtil labels = ResourceBundleUtil.getBundle("org.jhotdraw.samples.svg.Labels");
        LinkedList<Action> actions = new LinkedList<Action>();
        if (TRANSFORM.get(this) != null) {
            actions.add(new AbstractAction(labels.getString("edit.removeTransform.text")) {

                public void actionPerformed(ActionEvent evt) {
                    willChange();
                    fireUndoableEditHappened(
                            TRANSFORM.setUndoable(SVGImageFigure.this, null)
                            );
                    changed();
                }
            });
        }
        return actions;
    }

    @Override
    public boolean canConnect() {
        return false;
    }

    @Override
    public Connector findConnector(Point2D.Double p, ConnectionFigure prototype) {
        return null;
    }

    @Override
    public Connector findCompatibleConnector(Connector c, boolean isStartConnector) {
        return null;
    }

    @Override
    public SVGImageFigure clone() {
        SVGImageFigure that = (SVGImageFigure) super.clone();
        that.rectangle = (Rectangle2D.Double) this.rectangle.clone();
        that.cachedTransformedShape = null;
        that.cachedHitShape = null;
        return that;
    }

    public boolean isEmpty() {
        Rectangle2D.Double b = getBounds();
        return b.width <= 0 || b.height <= 0 || imageData == null && bufferedImage == null;
    }

    @Override
    public void invalidate() {
        super.invalidate();
        invalidateTransformedShape();
    }

    public void setImage(byte[] imageData, BufferedImage bufferedImage) {
        willChange();
        this.imageData = imageData;
        this.bufferedImage = bufferedImage;
        changed();
    }

    public void setImageData(byte[] imageData) {
        willChange();
        this.imageData = imageData;
        this.bufferedImage = null;
        changed();
    }

    public void setBufferedImage(BufferedImage image) {
        willChange();
        this.imageData = null;
        this.bufferedImage = image;
        changed();
    }

    public BufferedImage getBufferedImage() {
        if (bufferedImage == null && imageData != null) {
            //System.out.println("recreateing bufferedImage");
            try {
                bufferedImage = ImageIO.read(new ByteArrayInputStream(imageData));
            } catch (Throwable e) {
                e.printStackTrace();
                imageData = null;
            }
        }
        return bufferedImage;
    }

    public byte[] getImageData() {
        if (bufferedImage != null && imageData == null) {
            try {
                ByteArrayOutputStream bout = new ByteArrayOutputStream();
                ImageIO.write(bufferedImage, "PNG", bout);
                bout.close();
                imageData = bout.toByteArray();
            } catch (IOException e) {
                e.printStackTrace();
                bufferedImage = null;
            }
        }
        return imageData;
    }

    public void loadImage(File file) throws IOException {
        InputStream in = null;
        try {
            in = new FileInputStream(file);
            loadImage(in);
        } catch (Throwable t) {
            ResourceBundleUtil labels = ResourceBundleUtil.getBundle("org.jhotdraw.draw.Labels");
            IOException e = new IOException(labels.getFormatted("file.failedToLoadImage.message", file.getName()));
            e.initCause(t);
            throw e;
        } finally {
            if (in != null) {
                in.close();
            }
        }
    }

    @FeatureEntryPoint(JHotDrawFeatures.IMAGE_TOOL)
    public void loadImage(InputStream in) throws IOException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        byte[] buf = new byte[512];
        int bytesRead;
        while ((bytesRead = in.read(buf)) > 0) {
            baos.write(buf, 0, bytesRead);
        }
        BufferedImage img;
        try {
            img = ImageIO.read(new ByteArrayInputStream(baos.toByteArray()));
        } catch (Throwable t) {
            img = null;
        }
        if (img == null) {
            ResourceBundleUtil labels = ResourceBundleUtil.getBundle("org.jhotdraw.draw.Labels");
            throw new IOException(labels.getFormatted("file.failedToLoadImage.message", in.toString()));
        }
        imageData = baos.toByteArray();
        bufferedImage = img;
    }
}
