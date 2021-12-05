/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jhotdraw.draw.action;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import org.junit.Assert;
import org.jhotdraw.draw.DefaultDrawingView;

/**
 *
 * @author lucas
 */
public class ThenAllFiguresAreSelected extends Stage<ThenAllFiguresAreSelected> {

    @ExpectedScenarioState
    private DefaultDrawingView drawingView;

    //Test only passes if numberOfSelectedFigures is = 25 (or whatever the number of drawn figures are) 
    @ExpectedScenarioState
    private final int numberOfExpectedSelectedFigures = 25;

    public ThenAllFiguresAreSelected allFiguresAreSelectedTest() {
        Assert.assertEquals(numberOfExpectedSelectedFigures, drawingView.getSelectionCount());

        return self();
    }
}
