/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jhotdraw.samples.svg.figures;

import java.awt.geom.AffineTransform;
import java.awt.geom.Rectangle2D;
import org.jhotdraw.draw.Figure;
import org.jhotdraw.samples.svg.Gradient;
import org.jhotdraw.samples.svg.LinearGradient;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import org.jhotdraw.samples.svg.figures.SVGRectFigure;
import static org.jhotdraw.samples.svg.SVGAttributeKeys.*;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;

/**
 *
 * @author peter
 */
public class SVGRectFigureTest {
	private Figure rect;

	//Run before each test
	@Before
	public void setUp() {
		//Create a Rectangle at 0,0 with 10 width and height
		rect = new SVGRectFigure(0, 0, 10, 10);

		Rectangle2D.Double bounds = rect.getBounds();
		assert bounds.x == 0 && bounds.y == 0;
	}

	@After
	public void tearDown(){
	}

	@Test
	public void testTransform2D() {
		moveFigure(10, 10);
		Rectangle2D.Double bounds = rect.getBounds();
		assertTrue(bounds.x == 10 && bounds.y == 10);
	}

	@Test
	public void testBoundaryTransform2D(){
		moveFigure(-20, -20);
		Rectangle2D.Double bounds = rect.getBounds();
		assertTrue(bounds.x == -20 && bounds.y == -20);
	}

	private void moveFigure(double x, double y){
		AffineTransform tx = new AffineTransform();
		tx.translate(x, y);
		rect.transform(tx);
	}
	
	@Test
	public void testAttributeTransform() {
		rect.setAttribute(FILL_GRADIENT, new LinearGradient());

		moveFigure(10, 10);

		Rectangle2D.Double bounds = rect.getBounds();
		assertTrue(bounds.x == 10 && bounds.y == 10);
	}



	private void printRect(){
		System.out.println("x, y: " + rect.getBounds().x + " " + rect.getBounds().y);
		System.out.println("width, height: " + rect.getBounds().width + " " + rect.getBounds().height);
		System.out.println();
	}
}
