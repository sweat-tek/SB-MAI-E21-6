/**
 * @(#)SelectionComponentRepainter.java  1.0  23.05.2008
 *
 * Copyright (c) 2008 by the original authors of JHotDraw
 * and all its contributors.
 * All rights reserved.
 *
 * The copyright of this software is owned by the authors and  
 * contributors of the JHotDraw project ("the copyright holders").  
 * You may not use, copy or modify this software, except in  
 * accordance with the license agreement you entered into with  
 * the copyright holders. For details see accompanying license terms. 
 */
package org.jhotdraw.draw.action;

import java.beans.*;
import javax.swing.*;
import org.jhotdraw.draw.*;

/**
 * Calls repaint on components, which show attributes of the drawing editor
 * and of its views based on the current selection.
 *
 * @author Werner Randelshofer
 * @version 1.0 23.05.2008 Created.
 */
public class SelectionComponentRepainter extends FigureAdapter
        implements PropertyChangeListener, FigureSelectionListener {

    private DrawingEditor editor;
    private JComponent component;

    
    //Reduced code duplication: if code can be split into methods, it's generally a good idea, 
    // as it can reduce code duplications in further work
    public SelectionComponentRepainter(DrawingEditor editor, JComponent component) {
        this.editor = editor;
        this.component = component;
        if (editor != null) {
            if (editor.getActiveView() != null) {
                DrawingView view = editor.getActiveView();
    
                this.addListener(view);
            }
            editor.addPropertyChangeListener(this);
        }
    }

    @Override
    public void attributeChanged(FigureEvent evt) {
        component.repaint();
    }
    
    //Reduced code duplication by using new methods: addListener/removeListener
    public void propertyChange(PropertyChangeEvent evt) {
        String name = evt.getPropertyName();
        if (name == DrawingEditor.ACTIVE_VIEW_PROPERTY) {
            DrawingView view = (DrawingView) evt.getOldValue();
            if (view != null) {
                this.removeListener(view);
            }
            
            view = (DrawingView) evt.getNewValue();
            
            if (view != null) {
                this.addListener(view);
            }
            component.repaint();
            
        } else if (name == DrawingView.DRAWING_PROPERTY) {
            Drawing drawing = (Drawing) evt.getOldValue();
            if (drawing != null) {
                drawing.removeFigureListener(this);
            }
            drawing = (Drawing) evt.getNewValue();
            if (drawing != null) {
                drawing.addFigureListener(this);
            }
            component.repaint();
            
        } else {
            component.repaint();
        }
    }

    @Override
    public void selectionChanged(FigureSelectionEvent evt) {
        component.repaint();
    }

    //Reduced code duplication by using new method: removeListener
    public void dispose() {
        if (editor != null) {
            if (editor.getActiveView() != null) {
                DrawingView view = editor.getActiveView(); 
                this.removeListener(view);
            }
            editor.removePropertyChangeListener(this);
            editor = null;
        }
        component = null;
    }
    
    //Create method for adding listeners to avoid code duplications, as same code was used multiple times
    private void addListener(DrawingView view) {
                view.addPropertyChangeListener(this);
                view.addFigureSelectionListener(this);
                if (view.getDrawing() != null) {
                    view.getDrawing().addFigureListener(this);
                }
    }
    
    //Create method for removeing listeners to avoid code duplications, as same code was used multiple times
    private void removeListener(DrawingView view) {
                view.removePropertyChangeListener(this);
                view.removeFigureSelectionListener(this);
                if (view.getDrawing() != null) {
                    view.getDrawing().removeFigureListener(this);
                }
    }
}

