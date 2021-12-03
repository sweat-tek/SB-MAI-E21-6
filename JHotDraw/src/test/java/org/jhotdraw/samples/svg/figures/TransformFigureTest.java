/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jhotdraw.samples.svg.figures;

import org.jhotdraw.draw.Figure;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import org.jhotdraw.samples.svg.figures.SVGRectFigure;
import static org.junit.Assert.assertEquals;

/**
 *
 * @author peter
 */
public class TransformFigureTest {
	private Figure rect;

	@Before
	public void setUp() {
		rect = new SVGRectFigure();
	}

	@After
	public void tearDown(){
	}

	@Test
	public void testTransform2D() {
		System.out.print(rect.getBounds());
		assertEquals(rect.isSelectable(),true);
	}
}
