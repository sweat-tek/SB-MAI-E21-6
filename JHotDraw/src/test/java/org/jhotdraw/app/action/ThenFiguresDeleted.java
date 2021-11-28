/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jhotdraw.app.action;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import java.awt.geom.Rectangle2D;
import java.util.HashSet;
import java.util.Set;
import org.jhotdraw.app.EditableComponent;
import org.jhotdraw.draw.DrawingEditor;
import org.jhotdraw.draw.Figure;
import org.junit.Assert;
import static org.junit.Assert.assertEquals;

/**
 *
 * @author nicol
 */
public class ThenFiguresDeleted extends Stage<ThenFiguresDeleted> {
    @ExpectedScenarioState
    private DrawingEditor editor;

    @ExpectedScenarioState
    private Set<Figure> selectedFigures;
    
    @ExpectedScenarioState
    private Set<Figure> unselectedFigures;
    
    
    ThenFiguresDeleted oneOfTwoFiguresAreDeleted() {
        
        assertEquals(editor.getActiveView().getSelectionCount(), 2);
        EditableComponent selected = (EditableComponent) editor.getActiveView().getSelectedFigures().iterator().next();
        selected.delete();
        assertEquals(editor.getActiveView().getSelectionCount(), 1);

        return this;
    }
    
}
