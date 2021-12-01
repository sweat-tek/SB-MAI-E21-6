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
public class WhenSelecting extends Stage<WhenSelecting> {
    @ExpectedScenarioState
    @ProvidedScenarioState
    private DrawingEditor editor;

    @ProvidedScenarioState
    private Set<Figure> unselectedFiguresOnView;
    
    @ProvidedScenarioState
    private Set<Figure> selectedFiguresOnView;
    
    private ClearSelectionAction clearSelectionAction;
    private SelectAllAction selectAction;
    
     @BeforeStage
    public void before() {
        clearSelectionAction = new ClearSelectionAction();
        selectAction = new SelectAllAction();
        
        selectedFiguresOnView = new HashSet<>(editor.getActiveView().getSelectedFigures());
        unselectedFiguresOnView = new HashSet<>(editor.getActiveView().getDrawing().getChildren());
    }
    
    WhenSelecting selectingFigures() {
        selectAction.actionPerformed(null);
        return this;
    }
    
    WhenSelecting unselectingFigures() {
        clearSelectionAction.actionPerformed(null);
        return this;
    }
    
}
