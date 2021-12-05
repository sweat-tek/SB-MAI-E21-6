/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jhotdraw.draw.action;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.BeforeStage;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import org.jhotdraw.draw.DefaultDrawingEditor;
import org.jhotdraw.draw.DefaultDrawingView;
import org.jhotdraw.draw.DrawingEditor;
import org.jhotdraw.draw.DrawingView;
import org.jhotdraw.draw.QuadTreeDrawing;
import org.jhotdraw.draw.action.GivenFiguresToGroup;
import org.jhotdraw.samples.svg.figures.SVGTextFigure;


/**
 *
 * @author Zed V2
 */
class GivenDrawingView extends Stage<GivenDrawingView> {
    
        @ProvidedScenarioState
    private DrawingEditor editor;

        @BeforeStage
    private void before() {
    editor = new DefaultDrawingEditor();
    DrawingView view = new DefaultDrawingView();
    view.setDrawing(new QuadTreeDrawing());
    editor.setActiveView(view);
    }
    
 GivenDrawingView Drawing_View() {
     editor.getActiveView();
    return this;
}    
}

