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
import org.jhotdraw.draw.DrawingEditor;
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
        
    }
    
    ThenUndo rectangleUndone() {
        assertTrue(editor.getActiveView().findFigure(p)==null);
        return this;
    }
    
}
