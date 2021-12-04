/**
 * @(#)SelectionComponentDisplayer.java  1.0  23.05.2008
 *
 * Copyright (c) 2006-2008 by the original authors of JHotDraw
 * and all its contributors.
 * All rights reserved.
 *
 * The copyright of this software is owned by the authors and  
 * contributors of the JHotDraw project ("the copyright holders").  
 * You may not use, copy or modify this software, except in  
 * accordance with the license agreement you entered into with  
 * the copyright holders. For details see accompanying license terms. 
 */
package org.jhotdraw.samples.svg.gui;

import java.awt.Dimension;
import java.beans.*;
import javax.swing.*;
import org.jhotdraw.draw.*;

/**
 * Calls setVisible(true/false) on components, which show attributes of the 
 * drawing editor and of its views based on the current selection.
 *
 * @author Werner Randelshofer
 * @version 1.0 23.05.2008 Created.
 */
public class SelectionComponentDisplayer
        implements PropertyChangeListener, FigureSelectionListener {

    protected DrawingEditor editor;
    protected JComponent component;
    protected int minSelectionCount = 1;
    protected boolean isVisibleIfCreationTool = true;

    public SelectionComponentDisplayer(DrawingEditor editor, JComponent component) {
        this.editor = editor;
        this.component = component;
        if (editor.getActiveView() != null) {
            DrawingView view = editor.getActiveView();
            this.addListener(view);
        }
        editor.addPropertyChangeListener(this);
        updateVisibility();
    }

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
            updateVisibility();
        } else if (name == DrawingEditor.TOOL_PROPERTY) {
            updateVisibility();
        }
    }

    @Override
    public void selectionChanged(FigureSelectionEvent evt) {
        updateVisibility();
    }

    public void updateVisibility() {
        boolean newValue = editor != null &&
                editor.getActiveView() != null &&
                (isVisibleIfCreationTool && editor.getTool() != null && !(editor.getTool() instanceof SelectionTool) ||
                editor.getActiveView().getSelectionCount() >= minSelectionCount);
        component.setVisible(newValue);

        // The following is needed to trick BoxLayout
        if (newValue) {
            component.setPreferredSize(null);
        } else {
            component.setPreferredSize(new Dimension(0, 0));
        }

        component.revalidate();
    }

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

    public void setMinSelectionCount(int newValue) {
        minSelectionCount = newValue;
        updateVisibility();
    }

    public void setVisibleIfCreationTool(boolean newValue) {
        isVisibleIfCreationTool = newValue;
    }
    
    //Create method for adding listeners to avoid code duplications, as same code was used multiple times
    private void addListener(DrawingView view) {
                view.addPropertyChangeListener(this);
                view.addFigureSelectionListener(this);
    }
    
    //Create method for removeing listeners to avoid code duplications, as same code was used multiple times
    private void removeListener(DrawingView view) {
                view.removePropertyChangeListener(this);
                view.removeFigureSelectionListener(this);
    }
}

