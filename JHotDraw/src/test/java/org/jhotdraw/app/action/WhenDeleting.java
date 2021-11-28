package org.jhotdraw.app.action;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.BeforeStage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import java.util.HashSet;
import java.util.Set;
import org.jhotdraw.draw.DrawingEditor;
import org.jhotdraw.draw.Figure;
import org.jhotdraw.samples.svg.figures.SVGGroupFigure;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author nicol
 */
public class WhenDeleting extends Stage<WhenDeleting> {
    @ExpectedScenarioState
    @ProvidedScenarioState
    private DrawingEditor editor;

    @ProvidedScenarioState
    private Set<Figure> selectedFigures;
    
    @ProvidedScenarioState
    private Set<Figure> unselectedFigures;
    
    private DeleteAction deleteAction;
    
     @BeforeStage
    public void before() {
        deleteAction = new DeleteAction();

        selectedFigures = new HashSet<>(editor.getActiveView().getSelectedFigures());
        
        unselectedFigures = new HashSet<>(editor.getActiveView().getDrawing().getChildren());
        unselectedFigures.removeAll(selectedFigures);
    }
    
    WhenDeleting DeleteAction() {
        deleteAction.actionPerformed(null);
        return this;
    }
    
}
