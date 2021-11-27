/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jhotdraw.samples.svg.figures;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.util.Collection;
import org.jhotdraw.draw.ConnectionFigure;
import org.jhotdraw.draw.Connector;
import org.jhotdraw.draw.Handle;
import org.jhotdraw.draw.TextHolderFigure;
import org.jhotdraw.draw.Tool;
import org.jhotdraw.geom.Dimension2DDouble;
import org.jhotdraw.geom.Insets2D;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author simo7
 */
public class SVGTextFigureTest {
    
    public SVGTextFigureTest() {
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

    /**
     * Test of drawText method, of class SVGTextFigure.
     */
    @Test
    public void testDrawText() {
        System.out.println("drawText");
        Graphics2D g = null;
        SVGTextFigure instance = new SVGTextFigure();
        instance.drawText(g);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of drawFill method, of class SVGTextFigure.
     */
    @Test
    public void testDrawFill() {
        System.out.println("drawFill");
        Graphics2D g = null;
        SVGTextFigure instance = new SVGTextFigure();
        instance.drawFill(g);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of drawStroke method, of class SVGTextFigure.
     */
    @Test
    public void testDrawStroke() {
        System.out.println("drawStroke");
        Graphics2D g = null;
        SVGTextFigure instance = new SVGTextFigure();
        instance.drawStroke(g);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setCoordinates method, of class SVGTextFigure.
     */
    @Test
    public void testSetCoordinates() {
        System.out.println("setCoordinates");
        Point2D.Double[] coordinates = null;
        SVGTextFigure instance = new SVGTextFigure();
        instance.setCoordinates(coordinates);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCoordinates method, of class SVGTextFigure.
     */
    @Test
    public void testGetCoordinates() {
        System.out.println("getCoordinates");
        SVGTextFigure instance = new SVGTextFigure();
        Point2D.Double[] expResult = null;
        Point2D.Double[] result = instance.getCoordinates();
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setRotates method, of class SVGTextFigure.
     */
    @Test
    public void testSetRotates() {
        System.out.println("setRotates");
        double[] rotates = null;
        SVGTextFigure instance = new SVGTextFigure();
        instance.setRotates(rotates);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getRotates method, of class SVGTextFigure.
     */
//    @Test
//    public void testGetRotates() {
//        System.out.println("getRotates");
//        SVGTextFigure instance = new SVGTextFigure();
//        double[] expResult = null;
//        double[] result = instance.getRotates();
//        assertArrayEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

    /**
     * Test of getBounds method, of class SVGTextFigure.
     */
    @Test
    public void testGetBounds() {
        System.out.println("getBounds");
        SVGTextFigure instance = new SVGTextFigure();
        Rectangle2D.Double expResult = null;
        Rectangle2D.Double result = instance.getBounds();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDrawingArea method, of class SVGTextFigure.
     */
    @Test
    public void testGetDrawingArea() {
        System.out.println("getDrawingArea");
        SVGTextFigure instance = new SVGTextFigure();
        Rectangle2D.Double expResult = null;
        Rectangle2D.Double result = instance.getDrawingArea();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of contains method, of class SVGTextFigure.
     */
    @Test
    public void testContains() {
        System.out.println("contains");
        Point2D.Double p = null;
        SVGTextFigure instance = new SVGTextFigure();
        boolean expResult = false;
        boolean result = instance.contains(p);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setBounds method, of class SVGTextFigure.
     */
    @Test
    public void testSetBounds() {
        System.out.println("setBounds");
        Point2D.Double anchor = null;
        Point2D.Double lead = null;
        SVGTextFigure instance = new SVGTextFigure();
        instance.setBounds(anchor, lead);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of transform method, of class SVGTextFigure.
     */
    @Test
    public void testTransform() {
        System.out.println("transform");
        AffineTransform tx = null;
        SVGTextFigure instance = new SVGTextFigure();
        instance.transform(tx);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of restoreTransformTo method, of class SVGTextFigure.
     */
    @Test
    public void testRestoreTransformTo() {
        System.out.println("restoreTransformTo");
        Object geometry = null;
        SVGTextFigure instance = new SVGTextFigure();
        instance.restoreTransformTo(geometry);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTransformRestoreData method, of class SVGTextFigure.
     */
    @Test
    public void testGetTransformRestoreData() {
        System.out.println("getTransformRestoreData");
        SVGTextFigure instance = new SVGTextFigure();
        Object expResult = null;
        Object result = instance.getTransformRestoreData();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getText method, of class SVGTextFigure.
     */
    @Test
    public void testGetText() {
        System.out.println("getText");
        SVGTextFigure instance = new SVGTextFigure();
        String expResult = "Text";
        String result = instance.getText();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of setAttribute method, of class SVGTextFigure.
     */
//    @Test
//    public void testSetAttribute() {
//        System.out.println("setAttribute");
//        SVGTextFigure instance = new SVGTextFigure();
//        instance.setAttribute(null);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

    /**
     * Test of setText method, of class SVGTextFigure.
     */
    @Test
    public void testSetText() {
        System.out.println("setText");
        String newText = "Hello";
        SVGTextFigure instance = new SVGTextFigure();
        String expResult = "Hello";
        instance.setText(newText);
        assertEquals(expResult, instance);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isEditable method, of class SVGTextFigure.
     */
    @Test
    public void testIsEditable() {
        System.out.println("isEditable");
        SVGTextFigure instance = new SVGTextFigure();
        boolean expResult = false;
        boolean result = instance.isEditable();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setEditable method, of class SVGTextFigure.
     */
    @Test
    public void testSetEditable() {
        System.out.println("setEditable");
        boolean b = false;
        SVGTextFigure instance = new SVGTextFigure();
        instance.setEditable(b);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTextColumns method, of class SVGTextFigure.
     */
    @Test
    public void testGetTextColumns() {
        System.out.println("getTextColumns");
        SVGTextFigure instance = new SVGTextFigure();
        int expResult = 0;
        int result = instance.getTextColumns();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getFont method, of class SVGTextFigure.
     */
    @Test
    public void testGetFont() {
        System.out.println("getFont");
        SVGTextFigure instance = new SVGTextFigure();
        Font expResult = null;
        Font result = instance.getFont();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTextColor method, of class SVGTextFigure.
     */
    @Test
    public void testGetTextColor() {
        System.out.println("getTextColor");
        SVGTextFigure instance = new SVGTextFigure();
        Color expResult = null;
        Color result = instance.getTextColor();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getFillColor method, of class SVGTextFigure.
     */
    @Test
    public void testGetFillColor() {
        System.out.println("getFillColor");
        SVGTextFigure instance = new SVGTextFigure();
        Color expResult = null;
        Color result = instance.getFillColor();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setFontSize method, of class SVGTextFigure.
     */
    @Test
    public void testSetFontSize() {
        System.out.println("setFontSize");
        float size = 0.0F;
        SVGTextFigure instance = new SVGTextFigure();
        instance.setFontSize(size);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getFontSize method, of class SVGTextFigure.
     */
    @Test
    public void testGetFontSize() {
        System.out.println("getFontSize");
        SVGTextFigure instance = new SVGTextFigure();
        float expResult = 0.0F;
        float result = instance.getFontSize();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of invalidate method, of class SVGTextFigure.
     */
    @Test
    public void testInvalidate() {
        System.out.println("invalidate");
        SVGTextFigure instance = new SVGTextFigure();
        instance.invalidate();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPreferredSize method, of class SVGTextFigure.
     */
    @Test
    public void testGetPreferredSize() {
        System.out.println("getPreferredSize");
        SVGTextFigure instance = new SVGTextFigure();
        Dimension2DDouble expResult = null;
        Dimension2DDouble result = instance.getPreferredSize();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of createHandles method, of class SVGTextFigure.
     */
    @Test
    public void testCreateHandles() {
        System.out.println("createHandles");
        int detailLevel = 0;
        SVGTextFigure instance = new SVGTextFigure();
        Collection<Handle> expResult = null;
        Collection<Handle> result = instance.createHandles(detailLevel);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of canConnect method, of class SVGTextFigure.
     */
    @Test
    public void testCanConnect() {
        System.out.println("canConnect");
        SVGTextFigure instance = new SVGTextFigure();
        boolean expResult = false;
        boolean result = instance.canConnect();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findConnector method, of class SVGTextFigure.
     */
    @Test
    public void testFindConnector() {
        System.out.println("findConnector");
        Point2D.Double p = null;
        ConnectionFigure prototype = null;
        SVGTextFigure instance = new SVGTextFigure();
        Connector expResult = null;
        Connector result = instance.findConnector(p, prototype);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findCompatibleConnector method, of class SVGTextFigure.
     */
    @Test
    public void testFindCompatibleConnector() {
        System.out.println("findCompatibleConnector");
        Connector c = null;
        boolean isStartConnector = false;
        SVGTextFigure instance = new SVGTextFigure();
        Connector expResult = null;
        Connector result = instance.findCompatibleConnector(c, isStartConnector);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTool method, of class SVGTextFigure.
     */
    @Test
    public void testGetTool() {
        System.out.println("getTool");
        Point2D.Double p = null;
        SVGTextFigure instance = new SVGTextFigure();
        Tool expResult = null;
        Tool result = instance.getTool(p);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getBaseline method, of class SVGTextFigure.
     */
    @Test
    public void testGetBaseline() {
        System.out.println("getBaseline");
        SVGTextFigure instance = new SVGTextFigure();
        double expResult = 0.0;
        double result = instance.getBaseline();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTabSize method, of class SVGTextFigure.
     */
    @Test
    public void testGetTabSize() {
        System.out.println("getTabSize");
        SVGTextFigure instance = new SVGTextFigure();
        int expResult = 0;
        int result = instance.getTabSize();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getLabelFor method, of class SVGTextFigure.
     */
    @Test
    public void testGetLabelFor() {
        System.out.println("getLabelFor");
        SVGTextFigure instance = new SVGTextFigure();
        TextHolderFigure expResult = null;
        TextHolderFigure result = instance.getLabelFor();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getInsets method, of class SVGTextFigure.
     */
    @Test
    public void testGetInsets() {
        System.out.println("getInsets");
        SVGTextFigure instance = new SVGTextFigure();
        Insets2D.Double expResult = null;
        Insets2D.Double result = instance.getInsets();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of clone method, of class SVGTextFigure.
     */
    @Test
    public void testClone() {
        System.out.println("clone");
        SVGTextFigure instance = new SVGTextFigure();
        SVGTextFigure expResult = null;
        SVGTextFigure result = instance.clone();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isEmpty method, of class SVGTextFigure.
     */
    @Test
    public void testIsEmpty() {
        System.out.println("isEmpty");
        SVGTextFigure instance = new SVGTextFigure();
        boolean expResult = false;
        boolean result = instance.isEmpty();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isTextOverflow method, of class SVGTextFigure.
     */
    @Test
    public void testIsTextOverflow() {
        System.out.println("isTextOverflow");
        SVGTextFigure instance = new SVGTextFigure();
        boolean expResult = false;
        boolean result = instance.isTextOverflow();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
