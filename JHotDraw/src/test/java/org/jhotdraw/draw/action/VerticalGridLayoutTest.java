/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jhotdraw.draw.action;

import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author nicol
 */
public class VerticalGridLayoutTest {
    
    public VerticalGridLayoutTest() {
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
     * Test of getRows method, of class VerticalGridLayout.
     */
    @Test
    public void testGetRows() {
        System.out.println("getRows");
        VerticalGridLayout instance = new VerticalGridLayout();
        int expResult = 0;
        int result = instance.getRows();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setRows method, of class VerticalGridLayout.
     */
    @Test
    public void testSetRows() {
        System.out.println("setRows");
        int rows = 0;
        VerticalGridLayout instance = new VerticalGridLayout();
        instance.setRows(rows);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setVertical method, of class VerticalGridLayout.
     */
    @Test
    public void testSetVertical() {
        System.out.println("setVertical");
        boolean b = false;
        VerticalGridLayout instance = new VerticalGridLayout();
        instance.setVertical(b);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isVertical method, of class VerticalGridLayout.
     */
    @Test
    public void testIsVertical() {
        System.out.println("isVertical");
        VerticalGridLayout instance = new VerticalGridLayout();
        boolean expResult = false;
        boolean result = instance.isVertical();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getColumns method, of class VerticalGridLayout.
     */
    @Test
    public void testGetColumns() {
        System.out.println("getColumns");
        VerticalGridLayout instance = new VerticalGridLayout();
        int expResult = 0;
        int result = instance.getColumns();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setColumns method, of class VerticalGridLayout.
     */
    @Test
    public void testSetColumns() {
        System.out.println("setColumns");
        int cols = 0;
        VerticalGridLayout instance = new VerticalGridLayout();
        instance.setColumns(cols);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getHgap method, of class VerticalGridLayout.
     */
    @Test
    public void testGetHgap() {
        System.out.println("getHgap");
        VerticalGridLayout instance = new VerticalGridLayout();
        int expResult = 0;
        int result = instance.getHgap();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setHgap method, of class VerticalGridLayout.
     */
    @Test
    public void testSetHgap() {
        System.out.println("setHgap");
        int hgap = 0;
        VerticalGridLayout instance = new VerticalGridLayout();
        instance.setHgap(hgap);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getVgap method, of class VerticalGridLayout.
     */
    @Test
    public void testGetVgap() {
        System.out.println("getVgap");
        VerticalGridLayout instance = new VerticalGridLayout();
        int expResult = 0;
        int result = instance.getVgap();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setVgap method, of class VerticalGridLayout.
     */
    @Test
    public void testSetVgap() {
        System.out.println("setVgap");
        int vgap = 0;
        VerticalGridLayout instance = new VerticalGridLayout();
        instance.setVgap(vgap);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addLayoutComponent method, of class VerticalGridLayout.
     */
    @Test
    public void testAddLayoutComponent() {
        System.out.println("addLayoutComponent");
        String name = "";
        Component comp = null;
        VerticalGridLayout instance = new VerticalGridLayout();
        instance.addLayoutComponent(name, comp);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of removeLayoutComponent method, of class VerticalGridLayout.
     */
    @Test
    public void testRemoveLayoutComponent() {
        System.out.println("removeLayoutComponent");
        Component comp = null;
        VerticalGridLayout instance = new VerticalGridLayout();
        instance.removeLayoutComponent(comp);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of layoutSize method, of class VerticalGridLayout.
     */
    @Test
    public void testLayoutSize() {
        System.out.println("layoutSize");
        Container parent = null;
        String size = "";
        VerticalGridLayout instance = new VerticalGridLayout();
        Dimension expResult = null;
        Dimension result = instance.layoutSize(parent, size);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of preferredLayoutSize method, of class VerticalGridLayout.
     */
    @Test
    public void testPreferredLayoutSize() {
        System.out.println("preferredLayoutSize");
        Container parent = null;
        VerticalGridLayout instance = new VerticalGridLayout();
        Dimension expResult = null;
        Dimension result = instance.preferredLayoutSize(parent);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of minimumLayoutSize method, of class VerticalGridLayout.
     */
    @Test
    public void testMinimumLayoutSize() {
        System.out.println("minimumLayoutSize");
        Container parent = null;
        VerticalGridLayout instance = new VerticalGridLayout();
        Dimension expResult = null;
        Dimension result = instance.minimumLayoutSize(parent);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setBoundsLeftToRight method, of class VerticalGridLayout.
     */
    @Test
    public void testSetBoundsLeftToRight() {
        System.out.println("setBoundsLeftToRight");
        LayoutContainerData data = null;
        VerticalGridLayout instance = new VerticalGridLayout();
        instance.setBoundsLeftToRight(data);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of layoutContainer method, of class VerticalGridLayout.
     */
    @Test
    public void testLayoutContainer() {
        System.out.println("layoutContainer");
        Container parent = null;
        VerticalGridLayout instance = new VerticalGridLayout();
        instance.layoutContainer(parent);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class VerticalGridLayout.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        VerticalGridLayout instance = new VerticalGridLayout();
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
