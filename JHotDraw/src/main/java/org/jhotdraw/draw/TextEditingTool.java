/*
 * @(#)TextEditingTool.java  1.0  2009-04-16
 *
 * Copyright (c) 2009 by the original authors of JHotDraw
 * and all its contributors.
 * All rights reserved.
 *
 * The copyright of this software is owned by the authors and  
 * contributors of the JHotDraw project ("the copyright holders").  
 * You may not use, copy or modify this software, except in  
 * accordance with the license agreement you entered into with  
 * the copyright holders. For details see accompanying license terms. 
 */
package org.jhotdraw.draw;

import java.awt.*;
import java.awt.event.*;
import javax.swing.undo.AbstractUndoableEdit;
import javax.swing.undo.UndoableEdit;
import org.jhotdraw.util.ResourceBundleUtil;

/**
 * A tool to edit figures which implement the {@code TextHolderFigure} interface,
 * such as {@code TextFigure}.
 *
 * @see TextHolderFigure
 * @see FloatingTextField
 *
 * @author Werner Randelshofer
 * @version 1.0 2009-04-16 Derived from TextTool.
 */
public class TextEditingTool extends TextGenericTool implements ActionListener {

    private FloatingTextField textField;
    private TextHolderFigure typingTarget;

    /** Creates a new instance. */
    public TextEditingTool(TextHolderFigure typingTarget) {
        this.typingTarget = typingTarget;
    }

    @Override
    public void deactivate(DrawingEditor editor) {
        endText();
        super.deactivate(editor);
    }

    /**
     * If the pressed figure is a TextHolderFigure it can be edited.
     */
    @Override
    public void mousePressed(MouseEvent e) {
        if (typingTarget != null) {
            beginEdit(typingTarget);
            updateCursor(getView(), e.getPoint());
        }
    }

    protected void beginEdit(TextHolderFigure textHolder) {
        if (textField == null) {
            textField = new FloatingTextField();
            textField.addActionListener(this);
        }

        if (textHolder != typingTarget && typingTarget != null) {
            endText();
        }

        textField.createOverlay(getView(), textHolder);
        textField.requestFocus();
        typingTarget = textHolder;
    }

    @Override
    public void mouseReleased(MouseEvent evt) {
    }

    public void endText() {
        if (typingTarget != null) {
            typingTarget.willChange();
            
            final TextHolderFigure editedFigure = typingTarget;
            final String oldText = typingTarget.getText();
            final String newText = textField.getText();

            if (newText.length() > 0) {
                typingTarget.setText(newText);
            } else {
           typingTarget.setText("");
           typingTarget.changed();
      }
         
            UndoableEdit edit = undoRedoCheck(editedFigure, oldText,newText);
            getDrawing().fireUndoableEditHappened(edit);
             
            
            typingTarget.changed();
            typingTarget = null;
            
            textField.endOverlay();
        }
    } 
    
    @Override
    public void keyReleased(KeyEvent evt) {
        if (evt.getKeyCode() == KeyEvent.VK_ESCAPE) {
            fireToolDone();
        }
    }

    public void actionPerformed(ActionEvent event) {
        endText();
        fireToolDone();
    }

    public boolean isEditing() {
        return typingTarget != null;
    }

    @Override
    public void updateCursor(DrawingView view, Point p) {
        if (view.isEnabled()) {
            view.setCursor(Cursor.getPredefinedCursor(isEditing() ? Cursor.DEFAULT_CURSOR : Cursor.CROSSHAIR_CURSOR));
        } else {
            view.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        }
    }

    public void mouseDragged(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
