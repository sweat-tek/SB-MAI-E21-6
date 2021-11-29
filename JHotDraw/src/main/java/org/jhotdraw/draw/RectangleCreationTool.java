package org.jhotdraw.draw;

import javax.swing.undo.*;
import java.awt.*;
import java.awt.geom.*;
import java.awt.event.*;
import java.util.*;
import org.jhotdraw.util.*;

/**
 * The CreationTool works well with most figures that fit into a rectangular
 * shape or that concist of a single straight line. For figures that need
 * additional editing after these mouse gestures, the use of a specialized
 * creation tool is recommended. For example the TextTool allows to enter the
 * text into a TextFigure after the user has performed the mouse gestures.
 * Design pattern:<br>
 * Name: Prototype.<br>
 * Role: Client.<br>
 * Partners: {@link Figure} as Prototype.
 */
public class RectangleCreationTool extends AbstractTool {
    protected Map<AttributeKey, Object> prototypeAttributes;
    protected String presentationName;
    protected Dimension minimalSizeTreshold = new Dimension(2, 2);
    protected Dimension minimalSize = new Dimension(40, 40);
    protected Figure prototype;
    protected Figure createdFigure;
    private boolean isToolDoneAfterCreation = true;

    public RectangleCreationTool(String prototypeClassName) {
        this(prototypeClassName, null, null);
    }

    public RectangleCreationTool(String prototypeClassName, Map<AttributeKey, Object> attributes) {
        this(prototypeClassName, attributes, null);
    }

    public RectangleCreationTool(String prototypeClassName, Map<AttributeKey, Object> attributes, String name) {
        try {
            this.prototype = (Figure) Class.forName(prototypeClassName).newInstance();
        } catch (Exception e) {
            InternalError error = new InternalError("Unable to create Figure from " + prototypeClassName);
            error.initCause(e);
            throw error;
        }
        this.prototypeAttributes = attributes;
        if (name == null) {
            ResourceBundleUtil labels = ResourceBundleUtil.getBundle("org.jhotdraw.draw.Labels");
            name = labels.getString("edit.createFigure.text");
        }
        this.presentationName = name;
    }

    public RectangleCreationTool(Figure prototype) {
        this(prototype, null, null);
    }

    public RectangleCreationTool(Figure prototype, Map<AttributeKey, Object> attributes) {
        this(prototype, attributes, null);
    }

    public RectangleCreationTool(Figure prototype, Map<AttributeKey, Object> attributes, String name) {
        this.prototype = prototype;
        this.prototypeAttributes = attributes;
        if (name == null) {
            ResourceBundleUtil labels = ResourceBundleUtil.getBundle("org.jhotdraw.draw.Labels");
            name = labels.getString("edit.createFigure.text");
        }
        this.presentationName = name;
    }

    public Figure getPrototype() {
        return prototype;
    }

    @Override
    public void activate(DrawingEditor editor) {
        super.activate(editor);
        getView().setCursor(Cursor.getPredefinedCursor(Cursor.CROSSHAIR_CURSOR));
    }

    @Override
    public void deactivate(DrawingEditor editor) {
        super.deactivate(editor);
        if (getView() != null) {
            getView().setCursor(Cursor.getDefaultCursor());
        }
        if (createdFigure != null) {
            if (createdFigure instanceof CompositeFigure) {
                ((CompositeFigure) createdFigure).layout();
            }
            createdFigure = null;
        }
    }

    public void mousePressed(MouseEvent evt) {
        super.mousePressed(evt);
        getView().clearSelection();
        createdFigure = createFigure();
        Point2D.Double p = constrainPoint(viewToDrawing(anchor));
        anchor.x = evt.getX();
        anchor.y = evt.getY();
        createdFigure.setBounds(p, p);
        getDrawing().add(createdFigure);
    }

    public void mouseDragged(MouseEvent evt) {
        if (createdFigure != null) {
            Point2D.Double p = constrainPoint(new Point(evt.getX(), evt.getY()));
            createdFigure.willChange();
            createdFigure.setBounds(
                    constrainPoint(new Point(anchor.x, anchor.y)),
                    p);
            createdFigure.changed();
        }
    }

    public void mouseReleased(MouseEvent evt) {
        if(createdFigure == null){
           if (isToolDoneAfterCreation()) {
            fireToolDone();
        }
            return;
        }
        Rectangle2D.Double bounds = createdFigure.getBounds();
        if (bounds.width == 0 && bounds.height == 0) {
            getDrawing().remove(createdFigure);
            if (isToolDoneAfterCreation()) {
                fireToolDone();
            }
            return;
        }
        if (Math.abs(anchor.x - evt.getX()) < minimalSizeTreshold.width &&
                Math.abs(anchor.y - evt.getY()) < minimalSizeTreshold.height) {
        createMinimalSizeRectangle(bounds);
        }
        if (createdFigure instanceof CompositeFigure) {
            ((CompositeFigure) createdFigure).layout();
        }
        setUndoableVariables(createdFigure,getDrawing());
        creationFinished(createdFigure);
        createdFigure = null;
    }

    private void setUndoableVariables(Figure _addedFigure, Drawing _addedDrawing){
        final Figure addedFigure = _addedFigure;
        final Drawing addedDrawing = _addedDrawing;
        getDrawing().fireUndoableEditHappened(new AbstractUndoableEdit() {
            public String getPresentationName() {
                return presentationName;
            }
            public void undo() throws CannotUndoException {
                super.undo();
                addedDrawing.remove(addedFigure);
            }
            public void redo() throws CannotRedoException {
                super.redo();
                addedDrawing.add(addedFigure);
            }
        });
    }
    
    private void createMinimalSizeRectangle(Rectangle2D.Double bounds){
        createdFigure.willChange();
        createdFigure.setBounds(
                constrainPoint(new Point(anchor.x, anchor.y)),
                constrainPoint(new Point(
                anchor.x + (int) Math.max(bounds.width, minimalSize.width),
                anchor.y + (int) Math.max(bounds.height, minimalSize.height))));
        createdFigure.changed(); 
    }
    
    @SuppressWarnings("unchecked")
    protected Figure createFigure() {
        Figure f = (Figure) prototype.clone();
        getEditor().applyDefaultAttributesTo(f);
        if (prototypeAttributes != null) {
            for (Map.Entry<AttributeKey, Object> entry : prototypeAttributes.entrySet()) {
                entry.getKey().basicSet(f, entry.getValue());
            }
        }
        return f;
    }

    protected Figure getCreatedFigure() {
        return createdFigure;
    }

    protected Figure getAddedFigure() {
        return createdFigure;
    }

    /**
     * This method allows subclasses to do perform additonal user interactions
     * after the new figure has been created.
     */
    protected void creationFinished(Figure createdFigure) {
        if (createdFigure.isSelectable()) {
            getView().addToSelection(createdFigure);
        }
        if (isToolDoneAfterCreation()) {
            fireToolDone();
        }
    }

    public void setToolDoneAfterCreation(boolean newValue) {
        boolean oldValue = isToolDoneAfterCreation;
        isToolDoneAfterCreation = newValue;
    }

    public boolean isToolDoneAfterCreation() {
        return isToolDoneAfterCreation;
    }

    @Override
    public void updateCursor(DrawingView view, Point p) {
        if (view.isEnabled()) {
            view.setCursor(Cursor.getPredefinedCursor(Cursor.CROSSHAIR_CURSOR));
        } else {
            view.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        }
    }
}
