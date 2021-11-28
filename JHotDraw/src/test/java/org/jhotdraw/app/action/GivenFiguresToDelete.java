/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jhotdraw.app.action;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.BeforeStage;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import org.jhotdraw.draw.*;

/**
 *
 * @author nicol
 */
public class GivenFiguresToDelete extends Stage<GivenFiguresToDelete> {

    @ProvidedScenarioState
    private DrawingEditor editor;

    @BeforeStage
    private void before() {
        editor = new DefaultDrawingEditor();
        DrawingView view = new DefaultDrawingView();
        view.setDrawing(new QuadTreeDrawing());
        editor.setActiveView(view);
    }
    
    GivenFiguresToDelete someSelectedFigures() {
        Figure f1 = new BezierFigure();
        Figure f2 = new BezierFigure();
       
        editor.getActiveView().getDrawing().add(f1);
         editor.getActiveView().getDrawing().add(f2);

        editor.getActiveView().addToSelection(f1);
        editor.getActiveView().addToSelection(f2);

        return this;
    }
    
    GivenFiguresToDelete someUnselectedFigures() {
        Figure f1 = new BezierFigure();
        Figure f2 = new BezierFigure();
       
        editor.getActiveView().getDrawing().add(f1);
        editor.getActiveView().getDrawing().add(f2);

        return this;
    }
    
}
