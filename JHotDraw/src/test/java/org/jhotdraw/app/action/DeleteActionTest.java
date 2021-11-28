/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jhotdraw.app.action;

import java.awt.Component;
import java.awt.KeyboardFocusManager;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import javax.swing.AbstractButton;
import javax.swing.FocusManager;
import javax.swing.JComponent;
import org.jhotdraw.draw.DrawingEditor;
import org.jhotdraw.draw.DrawingView;
import org.jhotdraw.draw.Figure;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 *
 * @author nicol
 */
public class DeleteActionTest {
    private static DrawingEditor editor;
    private static double scaleFactor;
    private static DrawingView view;
    private static AbstractButton button;
    private static String label;
    private Figure figure;
    private static Component component;
    private static KeyboardFocusManager keyboardFocusManager;
    
    public DeleteActionTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        keyboardFocusManager = mock(KeyboardFocusManager.class);
        
        
        when(keyboardFocusManager.getCurrentKeyboardFocusManager()).thenReturn( keyboardFocusManager);
        when(keyboardFocusManager.getCurrentKeyboardFocusManager().getPermanentFocusOwner()).thenReturn(component);
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
     * Test of actionPerformed method, of class DeleteAction.
     */
    @Test
    public void testActionPerformed() {
        System.out.println("actionPerformed");
        ActionEvent evt = null;
        DeleteAction instance = new DeleteAction();
        instance.actionPerformed(evt);
        // TODO review the generated test code and remove the default call to fail.
    }
}
