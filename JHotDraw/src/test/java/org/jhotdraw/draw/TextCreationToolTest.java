/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jhotdraw.draw;

import java.awt.Component;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;
import javax.swing.JTextField;
import org.jhotdraw.draw.DefaultDrawingEditor;
import org.jhotdraw.draw.DefaultDrawingView;
import org.jhotdraw.draw.FloatingTextArea;
import org.jhotdraw.draw.QuadTreeDrawing;
import org.jhotdraw.draw.TextAreaCreationTool;
import org.jhotdraw.draw.TextHolderFigure;
import static jdk.javadoc.internal.tool.JavadocClassFinder.instance;
import org.jhotdraw.samples.svg.figures.SVGTextFigure;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import sun.print.ProxyGraphics2D;

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
    public void testBeginText() {
        //arrange 
        TextHolderFigure textHolder = new SVGTextFigure("Hello1");
        textHolder.setText("text");
        TextAreaCreationTool instance = new TextAreaCreationTool(textHolder);
        DefaultDrawingView view = new DefaultDrawingView();
        instance.editor = new DefaultDrawingEditor();
        view.setDrawing(new QuadTreeDrawing());
        instance.editor.setActiveView(view);
        
        // act
       instance.beginEdit(textHolder);
       instance.endEdit();
       
        // assert
        assertTrue(instance.getAddedTextArea() instanceof FloatingTextArea);
        assertTrue(instance.isToolDoneAfterCreation());
    }


}