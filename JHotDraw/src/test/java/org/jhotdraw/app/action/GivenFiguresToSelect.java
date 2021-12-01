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
public class GivenFiguresToSelect extends Stage<GivenFiguresToSelect> {

    @ProvidedScenarioState
    private DrawingEditor editor;

    @BeforeStage
    private void before() {
        editor = new DefaultDrawingEditor();
        DrawingView view = new DefaultDrawingView();
        view.setDrawing(new QuadTreeDrawing());
        editor.setActiveView(view);
    }
    
    GivenFiguresToSelect unselectedFiguresOnView() {
        Figure f1 = new BezierFigure();
        Figure f2 = new BezierFigure();
        Figure f3 = new BezierFigure();
        Figure f4 = new BezierFigure();
        Figure f5 = new BezierFigure();
        
        // Adding figures to drawing
        editor.getActiveView().getDrawing().add(f1);
        editor.getActiveView().getDrawing().add(f2);
        editor.getActiveView().getDrawing().add(f3);
        editor.getActiveView().getDrawing().add(f4);
        editor.getActiveView().getDrawing().add(f5);
      
        return this;
    }
    
    GivenFiguresToSelect selectedFiguresOnView() {
        Figure f1 = new BezierFigure();
        Figure f2 = new BezierFigure();
        Figure f3 = new BezierFigure();
        Figure f4 = new BezierFigure();
        Figure f5 = new BezierFigure();
        
        // Adding figures to drawing
        editor.getActiveView().getDrawing().add(f1);
        editor.getActiveView().getDrawing().add(f2);
        editor.getActiveView().getDrawing().add(f3);
        editor.getActiveView().getDrawing().add(f4);
        editor.getActiveView().getDrawing().add(f5);
        
        // Adding all figures to selection
        editor.getActiveView().addToSelection(f1);
        editor.getActiveView().addToSelection(f2);
        editor.getActiveView().addToSelection(f3);
        editor.getActiveView().addToSelection(f4);
        editor.getActiveView().addToSelection(f5);

        return this;
    }
}
