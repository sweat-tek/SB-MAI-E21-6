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
import static org.mockito.Mockito.*;

/**
 *
 * @author nicol
 */
public class VerticalGridLayoutTest {
    
    private static Container container;
    private static Dimension dimensionPref;
    private static Dimension dimensionMin;
    private static VerticalGridLayout vlg;
    private static Component component;

    private static String minimum = "minimum";
    private static String prefered = "prefered";
    
    public VerticalGridLayoutTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        vlg = mock(VerticalGridLayout.class);
        
        dimensionPref = mock(Dimension.class);
        dimensionMin = mock(Dimension.class);

        component = mock(Component.class);
        container = mock(Container.class);
        
        dimensionPref.setSize(200, 200);
        dimensionMin.setSize(100, 100);
        
        component.setPreferredSize(dimensionPref);
        component.setMinimumSize(dimensionMin);
        
        when(component.getMaximumSize()).thenReturn(dimensionPref);
        when(component.getMinimumSize()).thenReturn(dimensionMin);
        when(container.getComponent(0)).thenReturn(component);
        when(vlg.layoutSize(container, minimum)).thenReturn(dimensionMin);
        when(vlg.layoutSize(container, prefered)).thenReturn(dimensionPref);

        
        
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
        int expResult = 1;
        int result = instance.getRows();
        assertEquals(expResult, result);
    }

    /**
     * Test of setRows method, of class VerticalGridLayout.
     */
    @Test
    public void testSetRows() {
        System.out.println("setRows");
        int rows = 2;
        VerticalGridLayout instance = new VerticalGridLayout();
        instance.setRows(rows);
        assertEquals(rows,instance.getRows());
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
        assertFalse(instance.isVertical());
    }

    /**
     * Test of isVertical method, of class VerticalGridLayout.
     */
    @Test
    public void testIsVertical() {
        System.out.println("isVertical");
        VerticalGridLayout instance = new VerticalGridLayout();
        boolean expResult = true;
        boolean result = instance.isVertical();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of getColumns method, of class VerticalGridLayout.
     */
    @Test
    public void testGetColumns() {
        System.out.println("getColumns");
        VerticalGridLayout instance = new VerticalGridLayout();
        int expResult = 3;
        instance.setColumns(3);
        int result = instance.getColumns();
        assertEquals(expResult, result);
        
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
        assertEquals(hgap,instance.getHgap());
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
        assertEquals(vgap,instance.getVgap());
    }


    /**
     * Test of layoutSize method, of class VerticalGridLayout.
     */
    @Test
    public void testLayoutSizePref() {
        System.out.println("layoutSize");
        Container parent = container;
        String size = "prefered";
        VerticalGridLayout instance = vlg;
        Dimension expResult = dimensionPref;
        Dimension result = instance.layoutSize(parent, size);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testLayoutSizeMin() {
        System.out.println("layoutSize");
        Container parent = container;
        String size = "minimum";
        VerticalGridLayout instance = vlg;
        Dimension expResult = dimensionMin;
        Dimension result = instance.layoutSize(parent, size);
        assertEquals(expResult, result);
    }
  
}
