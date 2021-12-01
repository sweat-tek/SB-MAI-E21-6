/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jhotdraw.app.action;

import com.tngtech.jgiven.junit.ScenarioTest;
import org.junit.Test;
/**
 *
 * @author nicol
 */
public class SelectingBehaviourTest extends ScenarioTest<GivenFiguresToSelect,WhenSelecting,ThenFiguresSelected> {
    
    @Test
    public void selectingFiguresOnViewAndCheckingIfSelected(){
        
           given().unselectedFiguresOnView();
           when().selectingFigures();
           then().figuresAreSelected();
    }
    
    @Test
    public void unselectingFiguresOnViewAndCheckingIfUnselected(){
        
           given().selectedFiguresOnView();
           when().unselectingFigures();
           then().figuresAreUnselected();
    }
}
