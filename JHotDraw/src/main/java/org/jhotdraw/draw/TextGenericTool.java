/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jhotdraw.draw;

import java.awt.event.MouseEvent;
import javax.swing.undo.AbstractUndoableEdit;
import javax.swing.undo.UndoableEdit;
import org.jhotdraw.util.ResourceBundleUtil;

/**
 *
 * @author Zed V2
 */
public class TextGenericTool extends AbstractTool {
   
    private FloatingTextField textField;
    private CreationTool creationTool;

    
    
    
    public void editingCode(TextHolderFigure typingTarget) {            
        if (creationTool.createdFigure != null) {
             getDrawing().remove((Figure)creationTool.getAddedFigure());
       } else {
           typingTarget.setText("");
           typingTarget.changed();
      }
                
    }
    
    
public void endText(TextHolderFigure typingTarget, FloatingTextField textField ) {
        if (typingTarget != null) {
            typingTarget.willChange();
            
            final TextHolderFigure editedFigure = typingTarget;
            final String oldText = typingTarget.getText();
            final String newText = textField.getText();

            if (newText.length() > 0) {
                typingTarget.setText(newText);
            } else { 
                editingCode(typingTarget);
            }
            UndoableEdit edit = new AbstractUndoableEdit() {

                @Override
                public String getPresentationName() {
                    ResourceBundleUtil labels = ResourceBundleUtil.getBundle("org.jhotdraw.draw.Labels");
                    return labels.getString("attribute.text.text");
                }

                @Override
                public void undo() {
                    super.undo();
                    editedFigure.willChange();
                    editedFigure.setText(oldText);
                    editedFigure.changed();
                }

                @Override
                public void redo() {
                    super.redo();
                    editedFigure.willChange();
                    editedFigure.setText(newText);
                    editedFigure.changed();
                }
            };
            getDrawing().fireUndoableEditHappened(edit);

            typingTarget.changed();
            typingTarget = null;
            
            textField.endOverlay();
        }
    }    
    @Override
    public void deactivate(DrawingEditor editor) {
        super.deactivate(editor); }
    
    
    @Override
    public void mouseDragged(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
