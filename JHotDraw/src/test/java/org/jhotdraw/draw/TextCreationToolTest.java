/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jhotdraw.draw;

import java.awt.Component;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import javax.swing.JTextField;
import org.jhotdraw.samples.svg.figures.SVGTextFigure;
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
public class TextCreationToolTest {
    
    public TextCreationToolTest() {
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

    @Test
    public void testEndText() {
        TextHolderFigure textHolder = new SVGTextFigure("hey");
        TextCreationTool instance = new TextCreationTool(textHolder);
        DefaultDrawingView view = new DefaultDrawingView();
        instance.editor = new DefaultDrawingEditor();
        instance.editor.setActiveView(view);
        System.out.println(instance.editor.getDrawingViews());
        
        instance.beginEdit(textHolder);
        
        Component component = view.getComponent();
        
        assertEquals(textHolder.getText(), ((JTextField)component).getText());
    }

}
