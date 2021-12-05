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
public class WhenAllFiguresAreSelected extends Stage<WhenAllFiguresAreSelected> {

    @ExpectedScenarioState
    private DefaultDrawingView drawingView;

    public WhenAllFiguresAreSelected allFiguresAreSelected() {
        drawingView.selectAll();
        
        return self();
    }
}
