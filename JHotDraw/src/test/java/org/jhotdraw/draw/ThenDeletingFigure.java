/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jhotdraw.draw;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import java.util.HashSet;
import java.util.Set;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 *
 * @author nikve
 */
public class ThenDeletingFigure extends Stage<ThenDeletingFigure> {
    @ExpectedScenarioState
    DefaultDrawingView view;
    @ExpectedScenarioState
    DrawingEditor edit;
    
     @ExpectedScenarioState
     Set<Figure> selectedFigures;
     @ExpectedScenarioState
     Set<Figure> unSelectedFigures;
     
     ThenDeletingFigure noFiguresInView(){
         assertEquals(0, view.getDrawing().getChildCount());
         
         return this;
     }
     ThenDeletingFigure selectedFiguresDeleted(){
            Set<Figure> expectedSelection = new HashSet<>(unSelectedFigures);
            
            Figure group = edit.getActiveView().getDrawing();
            
            assertTrue(group instanceof CompositeFigure);
            CompositeFigure comp = (CompositeFigure)group;
            assertEquals(expectedSelection.size(), comp.getChildCount());
            
            expectedSelection.forEach(selection -> {
                assertTrue(comp.contains(selection));
        });
         return this;
     }

    
     
     
}
