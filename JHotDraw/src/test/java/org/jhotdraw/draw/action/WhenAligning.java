package org.jhotdraw.draw.action;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.BeforeStage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import java.util.HashSet;
import java.util.Set;
import org.jhotdraw.draw.DrawingEditor;
import org.jhotdraw.draw.Figure;
import org.jhotdraw.samples.svg.figures.SVGGroupFigure;

/**
 *
 * @author Tobias Kristensen
 */
public class WhenAligning extends Stage<WhenAligning> {
    
    @ExpectedScenarioState
    @ProvidedScenarioState
    private DrawingEditor editor;

    @ProvidedScenarioState
    private Set<Figure> selectedFigures;
    
    @ProvidedScenarioState
    private Set<Figure> unselectedFigures;
    
    private AlignAction.North alignNorthAction;
    private AlignAction.South alignSouthAction;
    private AlignAction.East alignEastAction;
    private AlignAction.West alignWestAction;
    private AlignAction.Horizontal alignHorizontalAction;
    private AlignAction.Vertical alignVerticalAction;
    
    @BeforeStage
    public void before() {
        alignNorthAction = new AlignAction.North(editor);
        alignSouthAction = new AlignAction.South(editor);
        alignEastAction = new AlignAction.East(editor);
        alignWestAction = new AlignAction.West(editor);
        alignHorizontalAction = new AlignAction.Horizontal(editor);
        alignVerticalAction = new AlignAction.Vertical(editor);

        selectedFigures = new HashSet<>(editor.getActiveView().getSelectedFigures());
        
        unselectedFigures = new HashSet<>(editor.getActiveView().getDrawing().getChildren());
        unselectedFigures.removeAll(selectedFigures);
    }
    
    WhenAligning alignFiguresNorth() {
        alignNorthAction.actionPerformed(null);
        return this;
    }
    
    WhenAligning alignFiguresSouth() {
        alignSouthAction.actionPerformed(null);
        return this;
    }
    
    WhenAligning alignFiguresEast() {
        alignEastAction.actionPerformed(null);
        return this;
    }
    
    WhenAligning alignFiguresWest() {
        alignWestAction.actionPerformed(null);
        return this;
    }
    
    WhenAligning alignFiguresHorizontal() {
        alignHorizontalAction.actionPerformed(null);
        return this;
    }
    
    WhenAligning alignFiguresVertical() {
        alignVerticalAction.actionPerformed(null);
        return this;
    }
}
