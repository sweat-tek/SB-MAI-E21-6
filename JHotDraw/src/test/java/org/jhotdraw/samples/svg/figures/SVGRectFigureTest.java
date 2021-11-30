/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jhotdraw.samples.svg.figures;

import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.awt.geom.RoundRectangle2D;
import java.util.Collection;
import org.jhotdraw.draw.ConnectionFigure;
import org.jhotdraw.draw.Connector;
import org.jhotdraw.draw.Handle;
import org.jhotdraw.geom.Dimension2DDouble;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

/**
 *
 * @author jonathan
 */
public class SVGRectFigureTest {
    public SVGRectFigureTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }
    
    
    /*
    *Test if it can succesfully set and get the bounds
    */
    @Test
    public void testSetAndGetBounds(){
        //Bounds should be x:0, y:0, height:40, width:40.
        Rectangle2D.Double testData = new Rectangle2D.Double(0,0,40,40);
        Point2D.Double anchor = new Point2D.Double(0,0);
        Point2D.Double lead = new Point2D.Double(40,40);
        
        SVGRectFigure instance = new SVGRectFigure();
        instance.setBounds(anchor, lead);
        
        assertEquals("Comparing boundaries",instance.getBounds(),testData.getBounds2D());
    }
    
    /*
    Test if minimum rectangle is created, even if points are on top of each others
    */
        @Test
    public void testMinimumRectangle(){
        //Bounds should be x:0, y:0, height:40, width:40.
        Rectangle2D.Double testData = new Rectangle2D.Double(0,0,0.1,0.1);

        Point2D.Double anchor = new Point2D.Double(0,0);
        Point2D.Double lead = new Point2D.Double(0,0);
        
        SVGRectFigure instance = new SVGRectFigure();
        instance.setBounds(anchor, lead);
        
        assertEquals("Comparing boundaries",instance.getBounds(),testData.getBounds2D());
    }
}
