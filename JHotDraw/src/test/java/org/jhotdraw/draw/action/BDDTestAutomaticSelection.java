/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jhotdraw.draw.action;

import com.tngtech.jgiven.junit.ScenarioTest;
import org.junit.Test;

/**
 *
 * @author lucas
 */
public class BDDTestAutomaticSelection extends ScenarioTest<GivenADrawnFigure, WhenAllFiguresAreSelected, ThenAllFiguresAreSelected> {

    //Passes as long as GivenADrawnFigure.numberOfDrawnFigures and ThenAllFiguresAreSelected.numberOfSelectedFigures have the same value - as it should
    @Test
    public void selectionBDDTest() {
        given().aDrawnFigure();
        when().allFiguresAreSelected();
        then().allFiguresAreSelectedTest();
    }
    
}
