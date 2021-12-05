/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jhotdraw.draw.action;

import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import javax.swing.AbstractButton;
import javax.swing.JComponent;
import org.jhotdraw.draw.DrawingEditor;
import org.jhotdraw.draw.DrawingView;
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
public class ZoomActionTest {
    
    private static DrawingEditor editor;
    private static double scaleFactor;
    private static DrawingView view;
    private static AbstractButton button;
    private static String label;
    private Rectangle rectangle;
    private static JComponent jComponent;
    
    
    
    
    
    public ZoomActionTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        editor = mock(DrawingEditor.class);
        view = mock(DrawingView.class);
        button = mock(AbstractButton.class);
        label =  (int) (scaleFactor * 100)+" %";
        jComponent = mock(JComponent.class);
        
        when(view.getScaleFactor()).thenReturn(1.0);
        when(view.getComponent()).thenReturn(jComponent);
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        scaleFactor = 1.0;
        rectangle = new Rectangle(0,0,100,100);
        when(view.getComponent().getVisibleRect()).thenReturn(rectangle);

    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getScaleFactor method, of class ZoomAction.
     */
    @Test
    public void testGetScaleFactor() {
        System.out.println("getScaleFactor");
        ZoomAction instance = new ZoomAction(view, scaleFactor, button);
        double expResult = 1.0;
        double result = instance.getScaleFactor();
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of getButton method, of class ZoomAction.
     */
    @Test
    public void testGetButton() {
        System.out.println("getButton");
        ZoomAction instance = new ZoomAction(view, scaleFactor, button);
        AbstractButton expResult = button;
        AbstractButton result = instance.getButton();
        assertEquals(expResult, result);
    }

    /**
     * Test of getLabel method, of class ZoomAction.
     */
    @Test
    public void testGetLabel() {
        System.out.println("getLabel");
        ZoomAction instance = new ZoomAction(view, scaleFactor, button);
        instance.getButton().setText(label);
        String expResult = (int) (scaleFactor * 100)+" %";
        String result = instance.getLabel();
        assertEquals(expResult, result);
    }
   
    /**
     * Test of actionPerformed method, of class ZoomAction.
     */
    @Test
    public void testActionPerformed() {
        System.out.println("actionPerformed");
        ActionEvent e = null;
        ZoomAction instance = new ZoomAction(view, 2.0, button);
        instance.actionPerformed(e);
        Rectangle rect = instance.getView().getComponent().getVisibleRect();
        assertEquals(100,rect.width);
    }
    
}
