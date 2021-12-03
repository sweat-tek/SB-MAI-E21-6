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
import org.jhotdraw.draw.TextAreaCreationTool;
import org.jhotdraw.draw.TextHolderFigure;
import org.jhotdraw.draw.action.WhenGrouping;
import org.jhotdraw.samples.svg.figures.SVGTextAreaFigure;
import org.jhotdraw.samples.svg.figures.SVGTextFigure;


/**
 *
 * @author Zed V2
 */
public class WhenAUserCanCreateATextObejct extends Stage<WhenAUserCanCreateATextObejct> {
    
    
    @ProvidedScenarioState
    private DrawingEditor editor;
    
    @BeforeStage
    private void before() {
    editor = new DefaultDrawingEditor();
    DrawingView view = new DefaultDrawingView();
    view.setDrawing(new QuadTreeDrawing());
    editor.setActiveView(view);
    
    }

WhenAUserCanCreateATextObejct AUserCreatesATextFigure() {
    TextHolderFigure textHolder = new SVGTextAreaFigure("Hello1");
     return this;
}    

}
