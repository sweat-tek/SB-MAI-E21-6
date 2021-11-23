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
 * @author tobia
 */
public class AlignBehaviorTest  extends ScenarioTest<GivenFiguresToAlign, WhenAligning, ThenFiguresAligned> {
    
    @Test
    public void selectingSimpleFiguresAndAligningThemNorthOnlyAlignsThoseFigures() {
        given().someSelectedRectFigures()
                .and().someUnselectedRectFigure();

        when().alignFiguresNorth();

        then().onlySelectedFiguresAreAlignedNorth();
    }
    
    @Test
    public void selectingSimpleFiguresAndAligningThemSouthOnlyAlignsThoseFigures() {
        given().someSelectedRectFigures()
                .and().someUnselectedRectFigure();

        when().alignFiguresSouth();

        then().onlySelectedFiguresAreAlignedSouth();
    }
    
    @Test
    public void selectingSimpleFiguresAndAligningThemEastOnlyAlignsThoseFigures() {
        given().someSelectedRectFigures()
                .and().someUnselectedRectFigure();

        when().alignFiguresEast();

        then().onlySelectedFiguresAreAlignedEast();
    }
    
    @Test
    public void selectingSimpleFiguresAndAligningThemWestOnlyAlignsThoseFigures() {
        given().someSelectedRectFigures()
                .and().someUnselectedRectFigure();

        when().alignFiguresWest();

        then().onlySelectedFiguresAreAlignedWest();
    }
    
    @Test
    public void selectingSimpleFiguresAndAligningThemHorizontallyOnlyAlignsThoseFigures() {
        given().someSelectedRectFigures()
                .and().someUnselectedRectFigure();

        when().alignFiguresHorizontal();

        then().onlySelectedFiguresAreAlignedHorizontally();
    }
    
    @Test
    public void selectingSimpleFiguresAndAligningThemVerticallyOnlyAlignsThoseFigures() {
        given().someSelectedRectFigures()
                .and().someUnselectedRectFigure();

        when().alignFiguresVertical();

        then().onlySelectedFiguresAreAlignedVertically();
    }
}
