/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jhotdraw.samples.svg.figures;

import com.tngtech.jgiven.junit.ScenarioTest;
import org.junit.Test;

/**
 *
 * @author peter
 */
public class BDDFigureMovementTest extends ScenarioTest<GivenFigure, WhenMovingFigure, ThenFigurePositioned> {

	@Test
	public void movingARectangleOnTheCanvas(){
		given().retangularFigure();
		when().movingFigure();
		then().figureHasMoved();
	}

	@Test 
	public void movingAllFiguresOnTheCanvas(){
		given().bezierFigure().and()
				.ellipseFigure().and()
				.imageFigure().and()
				.pathFigure().and()
				.retangularFigure().and()
				.textAreaFigure().and()
				.textFigure();
		when().movingFigure();
		then().figureHasMoved();
	}
}
