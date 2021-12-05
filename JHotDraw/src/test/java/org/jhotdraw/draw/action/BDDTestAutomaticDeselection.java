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
public class BDDTestAutomaticDeselection extends ScenarioTest<GivenADrawnFigure, WhenAllFiguresAreDeselected, ThenAllFiguresAreDeselected>{
    
    //Passes as long as ThenAllFiguresAreDeselected.numberOfSelectedFigures has a value of 0 - as it should
    @Test
    public void selectionBDDTest() {
        given().aDrawnFigure();
        when().allFiguresAreDeselected();
        then().allFiguresAreDeselectedTest();
    }
}
