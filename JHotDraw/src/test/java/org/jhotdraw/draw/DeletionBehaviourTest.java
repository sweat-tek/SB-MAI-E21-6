/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jhotdraw.draw;

import com.tngtech.jgiven.junit.ScenarioTest;
import org.junit.Test;

/**
 *
 * @author nikve
 */
public class DeletionBehaviourTest extends ScenarioTest<GivenFiguresToDelete, WhenDeletedFigure, ThenDeletingFigure> {
    @Test
    public void selectingSimpleFiguresAndDeletingThemResultsInJustThoseFiguresBeingDeleted(){
    given().someSelectedFigures().someUnselectedFigures();
            
    when().deleting();
    then().selectedFiguresDeleted();
    }
}
