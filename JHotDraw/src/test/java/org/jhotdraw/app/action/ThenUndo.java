/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jhotdraw.app.action;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.BeforeStage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import java.awt.Point;
import java.util.Set;
import org.jhotdraw.draw.CompositeFigure;
import org.jhotdraw.draw.DrawingEditor;
import org.jhotdraw.draw.Figure;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 *
 * @author joakimbetzer
 */
public class ThenUndo extends Stage<ThenUndo>{
    
    @ExpectedScenarioState
    private DrawingEditor editor;
    
    private Point p = new Point(1,1);
    
    @BeforeStage
    public void before(){
        editor.getActiveView().findFigure(p);
    }
    
    ThenUndo rectangleUndone() {
        assertTrue(editor.getActiveView().findFigure(p)==null);
        return this;
    }
    
}
