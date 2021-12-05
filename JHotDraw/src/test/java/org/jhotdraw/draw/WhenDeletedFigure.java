/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jhotdraw.draw;
import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.BeforeStage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import java.util.HashSet;
import java.util.Set;
/**
 *
 * @author nikve
 */
public class WhenDeletedFigure extends Stage<WhenDeletedFigure> {
      @ExpectedScenarioState
    DefaultDrawingView view;
    @ExpectedScenarioState
    @ProvidedScenarioState
    DrawingEditor edit;
     @ProvidedScenarioState
     DeleteEvent delete;
     @ExpectedScenarioState
     Set<Figure> selectedFigures;
     @ExpectedScenarioState
     Set<Figure> unSelectedFigures;

     @BeforeStage
     public void before(){
     delete = new DeleteEvent();
     selectedFigures = new HashSet<>(edit.getActiveView().getSelectedFigures());
     
     unSelectedFigures = new HashSet<>(edit.getActiveView().getDrawing().getChildren());
     unSelectedFigures.removeAll(selectedFigures);
     }

     WhenDeletedFigure deleting(){
         delete.delete(view);
         
         return this;
     }

}
