/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jhotdraw.draw.action;

import java.awt.event.ActionEvent;
import javax.swing.AbstractButton;
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
public class ZoomActionTest {
    
    public ZoomActionTest() {
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
     * Test of getScaleFactor method, of class ZoomAction.
     */
    @Test
    public void testGetScaleFactor() {
        System.out.println("getScaleFactor initial value");
        ZoomAction instance = null;
        double expResult = 0.0;
        double result = instance.getScaleFactor();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getButton method, of class ZoomAction.
     */
    @Test
    public void testGetButton() {
        System.out.println("getButton");
        ZoomAction instance = null;
        AbstractButton expResult = null;
        AbstractButton result = instance.getButton();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getLabel method, of class ZoomAction.
     */
    @Test
    public void testGetLabel() {
        System.out.println("getLabel");
        ZoomAction instance = null;
        String expResult = "";
        String result = instance.getLabel();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of calculateZoom method, of class ZoomAction.
     */
    @Test
    public void testCalculateZoom() {
        System.out.println("calculateZoom");
        ZoomAction instance = null;
        instance.calculateZoom();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of actionPerformed method, of class ZoomAction.
     */
    @Test
    public void testActionPerformed() {
        System.out.println("actionPerformed");
        ActionEvent e = null;
        ZoomAction instance = null;
        instance.actionPerformed(e);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
