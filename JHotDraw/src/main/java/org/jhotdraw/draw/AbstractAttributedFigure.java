package org.jhotdraw.draw;
import java.awt.*;
import java.awt.geom.*;
import java.util.*;
import java.io.*;
import static org.jhotdraw.draw.AttributeKeys.*;
import org.jhotdraw.geom.*;
import org.jhotdraw.xml.DOMInput;
import org.jhotdraw.xml.DOMOutput;

public abstract class AbstractAttributedFigure extends AbstractFigure {

    private HashMap<AttributeKey, Object> attributes = new HashMap<AttributeKey,Object>();

    private HashSet<AttributeKey> forbiddenAttributes;

    public AbstractAttributedFigure() {}

    public void setAttributeEnabled(AttributeKey key, boolean b) {
        if (forbiddenAttributes == null) {
            forbiddenAttributes = new HashSet<AttributeKey>();
        }
        if (b) {
            forbiddenAttributes.remove(key);
        } else {
            forbiddenAttributes.add(key);
        }
    }

    public boolean isAttributeEnabled(AttributeKey key) {
        return forbiddenAttributes == null || ! forbiddenAttributes.contains(key);
    }

    @SuppressWarnings("unchecked")
    public void setAttributes(Map<AttributeKey, Object> map) {
        for (Map.Entry<AttributeKey, Object> entry : map.entrySet()) {
            setAttribute(entry.getKey(), entry.getValue());
        }
    }

    public Map<AttributeKey, Object> getAttributes() {
        return new HashMap<AttributeKey,Object>(attributes);
    }

    public Object getAttributesRestoreData() {
        return getAttributes();
    }

    @SuppressWarnings("unchecked")
    public void restoreAttributesTo(Object restoreData) {
        attributes.clear();
        setAttributes((HashMap<AttributeKey,Object>) restoreData);
    }

    public <T> void setAttribute(AttributeKey<T> key, T newValue) {
        if (forbiddenAttributes == null
                || ! forbiddenAttributes.contains(key)) {
            T oldValue = (T) key.put(attributes, newValue);
            fireAttributeChanged(key, oldValue, newValue);
        }
    }

    public <T> T getAttribute(AttributeKey<T> key) {
        return hasAttribute(key) ? key.get(attributes) : key.getDefaultValue();
    }


    public void draw(Graphics2D g) {
        if (AttributeKeys.FILL_COLOR.get(this) != null) {
            g.setColor(AttributeKeys.FILL_COLOR.get(this));
            drawFill(g);
        }
        if (STROKE_COLOR.get(this) != null && STROKE_WIDTH.get(this) > 0d) {
            g.setStroke(AttributeKeys.getStroke(this));
            g.setColor(STROKE_COLOR.get(this));

            drawStroke(g);
        }
        if (TEXT_COLOR.get(this) != null) {
            if (checkShadowColor()) {
                Dimension2DDouble d = TEXT_SHADOW_OFFSET.get(this);
                g.translate(d.width, d.height);
                g.setColor(TEXT_SHADOW_COLOR.get(this));
                drawText(g);
                g.translate(-d.width,-d.height);
            }
            g.setColor(TEXT_COLOR.get(this));
            drawText(g);
        }
    }

    public boolean checkShadowColor() {
        if (TEXT_SHADOW_COLOR.get(this) != null && TEXT_SHADOW_OFFSET.get(this) != null) {
            return true;
        } else {
            return false;
        }
    }

    public Stroke getStroke() {
        return AttributeKeys.getStroke(this);
    }

    public double getStrokeMiterLimitFactor() {
        Number value = (Number) getAttribute(AttributeKeys.STROKE_MITER_LIMIT);
        return (value != null) ? value.doubleValue() : 10f;
    }


    public Rectangle2D.Double getDrawingArea() {
        double strokeTotalWidth = AttributeKeys.getStrokeTotalWidth(this);
        double width = strokeTotalWidth / 2d;
        if (STROKE_JOIN.get(this) == BasicStroke.JOIN_MITER) {
            width *= STROKE_MITER_LIMIT.get(this);
        } else if (STROKE_CAP.get(this) != BasicStroke.CAP_BUTT) {
            width += strokeTotalWidth * 2;
        }
        width++;
        Rectangle2D.Double r = getBounds();
        Geom.grow(r, width, width);
        return r;
    }

    protected abstract void drawFill(java.awt.Graphics2D g);
    protected abstract void drawStroke(java.awt.Graphics2D g);

    protected void drawText(java.awt.Graphics2D g) {
    }

    public AbstractAttributedFigure clone() {
        AbstractAttributedFigure that = (AbstractAttributedFigure) super.clone();
        that.attributes = new HashMap<AttributeKey,Object>(this.attributes);
        if (this.forbiddenAttributes != null) {
            that.forbiddenAttributes = new HashSet<AttributeKey>(this.forbiddenAttributes);
        }
        return that;
    }

    protected void writeAttributes(DOMOutput out) throws IOException {
        Figure prototype = (Figure) out.getPrototype();

        boolean isElementOpen = false;
        for (Map.Entry<AttributeKey, Object> entry : attributes.entrySet()) {
            AttributeKey key = entry.getKey();
            if (forbiddenAttributes == null
                    || ! forbiddenAttributes.contains(key)) {
                Object prototypeValue = key.get(prototype);
                Object attributeValue = key.get(this);
                if (prototypeValue != attributeValue ||
                        (prototypeValue != null && attributeValue != null &&
                        ! prototypeValue.equals(attributeValue))) {
                    if (! isElementOpen) {
                        out.openElement("a");
                        isElementOpen = true;
                    }
                    out.openElement(key.getKey());
                    out.writeObject(entry.getValue());
                    out.closeElement();
                }
            }
        }
        if (isElementOpen) {
            out.closeElement();
        }
    }

    @SuppressWarnings("unchecked")
    protected void readAttributes(DOMInput in) throws IOException {
        if (in.getElementCount("a") > 0) {
            in.openElement("a");
            for (int i=in.getElementCount() - 1; i >= 0; i-- ) {
                in.openElement(i);
                String name = in.getTagName();
                Object value = in.readObject();
                AttributeKey key = getAttributeKey(name);
                if (key != null && key.isAssignable(value)) {
                    if (forbiddenAttributes == null
                            || ! forbiddenAttributes.contains(key)) {
                        setAttribute(key, value);
                    }
                }
                in.closeElement();
            }
            in.closeElement();
        }
    }

    protected AttributeKey getAttributeKey(String name) {
        return AttributeKeys.supportedAttributeMap.get(name);
    }

    @SuppressWarnings("unchecked")
    protected void applyAttributesTo(Figure that) {
        for (Map.Entry<AttributeKey, Object> entry : attributes.entrySet()) {
            entry.getKey().basicSet(that, entry.getValue());
        }
    }

    public void write(DOMOutput out) throws IOException {
        Rectangle2D.Double r = getBounds();
        out.addAttribute("x", r.x);
        out.addAttribute("y", r.y);
        out.addAttribute("w", r.width);
        out.addAttribute("h", r.height);
        writeAttributes(out);
    }

    public void read(DOMInput in) throws IOException {
        double x = in.getAttribute("x", 0d);
        double y = in.getAttribute("y", 0d);
        double w = in.getAttribute("w", 0d);
        double h = in.getAttribute("h", 0d);
        setBounds(new Point2D.Double(x,y), new Point2D.Double(x+w,y+h));
        readAttributes(in);
    }

    public <T> void removeAttribute(AttributeKey<T> key) {
        if (hasAttribute(key)) {
            T oldValue = key.get(this);
            attributes.remove(key);
            fireAttributeChanged(key, oldValue, key.getDefaultValue());
        }
    }

    public boolean hasAttribute(AttributeKey key) {
        return attributes.containsKey(key);
    }
}
