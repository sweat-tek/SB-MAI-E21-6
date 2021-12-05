/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jhotdraw.draw;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.*;
import org.jhotdraw.samples.svg.figures.SVGGroupFigure;
import org.junit.Before;

/**
 *
 * @author nikve
 */
public class GivenFigureToDelete extends Stage<GivenFigureToDelete> {
    
    @ProvidedScenarioState
    DefaultDrawingView view;
       @ProvidedScenarioState
    DrawingEditor edit;
     @BeforeStage
    public void setUp(){
    view = new DefaultDrawingView();
    edit = new DefaultDrawingEditor();
    view.setDrawing(new QuadTreeDrawing());
    edit.setActiveView(view);
    }
    
    GivenFigureToDelete selectFigures(){
      Figure d1 = new LineFigure();
    Figure d2 = new LineFigure();
    Figure d3 = new LineFigure();
    Figure d4 = new LineFigure();
    Figure d5 = new LineFigure();
    Figure d6 = new LineFigure();
    Figure d7 = new LineFigure();
    edit.getActiveView().getDrawing().add(d1);
    edit.getActiveView().getDrawing().add(d7);
    edit.getActiveView().getDrawing().add(d2);
    edit.getActiveView().getDrawing().add(d3);
    edit.getActiveView().getDrawing().add(d4);
    edit.getActiveView().getDrawing().add(d5);
    edit.getActiveView().getDrawing().add(d6);
    edit.getActiveView().addToSelection(d1);
    edit.getActiveView().addToSelection(d2);
    edit.getActiveView().addToSelection(d3);
    edit.getActiveView().addToSelection(d4);
    edit.getActiveView().addToSelection(d5);
    edit.getActiveView().addToSelection(d6);
    edit.getActiveView().addToSelection(d7);
    return this;
    }
    
    GivenFigureToDelete addFiguresToDrawing(){
          Figure d1 = new LineFigure();
    Figure d2 = new LineFigure();
    Figure d3 = new LineFigure();
    Figure d4 = new LineFigure();
    Figure d5 = new LineFigure();
    Figure d6 = new LineFigure();
    Figure d7 = new LineFigure();
    edit.getActiveView().getDrawing().add(d1);
    edit.getActiveView().getDrawing().add(d7);
    edit.getActiveView().getDrawing().add(d2);
    edit.getActiveView().getDrawing().add(d3);
    edit.getActiveView().getDrawing().add(d4);
    edit.getActiveView().getDrawing().add(d5);
    edit.getActiveView().getDrawing().add(d6);
    return this;
    }
    GivenFigureToDelete selectedGroupFigures(){
    CompositeFigure group = new SVGGroupFigure();
    Figure d1 = new LineFigure();
    Figure d2 = new LineFigure();
    group.add(d1);
    group.add(d2);
    edit.getActiveView().getDrawing().add(group);   
     edit.getActiveView().addToSelection(group);
    return this;
    }
     GivenFigureToDelete unSelectedGroupFigures(){
    CompositeFigure group = new SVGGroupFigure();
    Figure d1 = new LineFigure();
    Figure d2 = new LineFigure();
    group.add(d1);
    group.add(d2);
    edit.getActiveView().getDrawing().add(group);   
    
    return this;
    }
       GivenFigureToDelete emptySelectedGroupFigures(){
    CompositeFigure group = new SVGGroupFigure();
    edit.getActiveView().getDrawing().add(group);   
     edit.getActiveView().addToSelection(group);
    return this;
    }
}
