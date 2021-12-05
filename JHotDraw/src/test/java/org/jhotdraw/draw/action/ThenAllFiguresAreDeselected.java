/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jhotdraw.draw.action;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import org.jhotdraw.draw.DefaultDrawingView;
import org.junit.Assert;

/**
 *
 * @author lucas
 */
public class ThenAllFiguresAreDeselected extends Stage<ThenAllFiguresAreDeselected> {

    @ExpectedScenarioState
    private DefaultDrawingView drawingView;

    @ExpectedScenarioState
    private final int numberOfSelectedFigures = 0;

    public ThenAllFiguresAreDeselected allFiguresAreDeselectedTest() {
        Assert.assertEquals(numberOfSelectedFigures, drawingView.getSelectionCount());

        return self();
    }
}
