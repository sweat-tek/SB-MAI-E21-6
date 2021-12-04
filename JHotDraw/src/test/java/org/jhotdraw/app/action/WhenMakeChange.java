/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jhotdraw.app.action;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.BeforeStage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import java.awt.Point;
import org.jhotdraw.draw.DrawingEditor;
import org.jhotdraw.draw.Figure;
/**
 *
 * @author joakimbetzer
 */
public class WhenMakeChange extends Stage<WhenMakeChange>{
    
    @ExpectedScenarioState
    @ProvidedScenarioState
    private DrawingEditor editor;
    
    private Figure f;
    Point p = new Point(1, 1);
    
    @BeforeStage
    public void before() {
        f = editor.getActiveView().findFigure(p);
    }
    
    WhenMakeChange undoRectangle() {
        editor.getActiveView().getDrawing().remove(f);
        return this;
    }
    
}
