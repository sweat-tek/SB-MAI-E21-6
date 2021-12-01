/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jhotdraw.app.action;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import java.util.List;
import java.util.Set;
import org.jhotdraw.draw.DrawingEditor;
import org.jhotdraw.draw.Figure;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 *
 * @author nicol
 */
public class ThenFiguresSelected extends Stage<ThenFiguresSelected> {
    @ExpectedScenarioState
    private DrawingEditor editor;

    @ExpectedScenarioState
    private Set<Figure> unselectedFiguresOnView;
    
    @ExpectedScenarioState
    private Set<Figure> selectedFiguresOnView;
    
    
    ThenFiguresSelected figuresAreSelected() {
        // Check if unselected figures from list exists on drawing
        assertFigureContains(editor.getActiveView().getDrawing().getChildren(),unselectedFiguresOnView);
       // Check if selection is empty
        assertEquals(editor.getActiveView().getSelectionCount(),0);
        
        // Adding all figures to selection
        unselectedFiguresOnView.forEach(fig -> {
            editor.getActiveView().addToSelection(fig);
        });
        // Check if figures were all added to selection
        assertEquals(editor.getActiveView().getSelectionCount(), 5);
        assertEquals(editor.getActiveView().getSelectedFigures(),unselectedFiguresOnView);

        return this;
    }
    
    ThenFiguresSelected figuresAreUnselected() {
        // Check if selected figures from list exists in selection
        assertEquals(editor.getActiveView().getSelectedFigures(),selectedFiguresOnView);
        // Check if selection has 5 figures selected
        assertEquals(editor.getActiveView().getSelectionCount(),5);
        
        // Remove all figures from the selection
        selectedFiguresOnView.forEach(fig -> {
            editor.getActiveView().removeFromSelection(fig);
        });
        
        // Check if all figures were removed from the selection
        assertEquals(editor.getActiveView().getSelectionCount(), 0);

        return this;
    }
    
    private void assertFigureContains(List<Figure> list1, Set<Figure> list2) {
        assertEquals(list1.size(), list2.size());
        // Checking that all figures on the view exists in the expected list
        list1.forEach(fig -> {
            assertTrue(list2.contains(fig));
        });
    }
}
