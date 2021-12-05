/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jhotdraw.draw;

import java.util.LinkedList;

import javax.swing.undo.AbstractUndoableEdit;
import javax.swing.undo.CannotRedoException;
import javax.swing.undo.CannotUndoException;
import org.jhotdraw.util.ResourceBundleUtil;
import dk.sdu.mmmi.featuretracer.lib.FeatureEntryPoint;
import org.jhotdraw.app.JHotDrawFeatures;

/**
 *
 * @author nikve
 */
public class DeleteEvent {
    @FeatureEntryPoint(JHotDrawFeatures.BASIC_EDITING)
    
    public void delete(DefaultDrawingView drawingview) {
        //final LinkedList<CompositeFigureEvent> deletionEvents = new LinkedList<CompositeFigureEvent>();
        final java.util.List<Figure> deletedFigures = drawingview.getDrawing().sort(drawingview.getSelectedFigures());

        // Abort, if not all of the selected figures may be removed from the
        // drawing
        for (Figure f : deletedFigures) {
            if (!f.isRemovable()) {
                drawingview.getToolkit().beep();
                return;

            }


        }

        // Get z-indices of deleted figures
        final int[] deletedFigureIndices = new int[deletedFigures.size()];
        for (int i = 0; i <
                deletedFigureIndices.length; i++) {
            deletedFigureIndices[i] = drawingview.getDrawing().indexOf(deletedFigures.get(i));
        }

        drawingview.clearSelection();
        drawingview.getDrawing().removeAll(deletedFigures);

        drawingview.getDrawing().fireUndoableEditHappened(new AbstractUndoableEdit() {

            @Override
            public String getPresentationName() {
                ResourceBundleUtil labels = ResourceBundleUtil.getBundle("org.jhotdraw.draw.Labels");
                return labels.getString("edit.delete.text");
            }

            @Override
            public void undo() throws CannotUndoException {
                super.undo();
                drawingview.clearSelection();

                Drawing d = drawingview.getDrawing();
                for (int i = 0; i <
                        deletedFigureIndices.length; i++) {
                    d.add(deletedFigureIndices[i], deletedFigures.get(i));
                }

                drawingview.addToSelection(deletedFigures);
            }

            @Override
            public void redo() throws CannotRedoException {
                super.redo();
                for (int i = 0; i <
                        deletedFigureIndices.length; i++) {
                    drawingview.getDrawing().remove(deletedFigures.get(i));
                }

            }
        });
    }
}
