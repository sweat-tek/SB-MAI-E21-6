/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jhotdraw.draw;
import org.jhotdraw.draw.*;
import org.junit.*;
import static org.junit.Assert.*;

/**
 *
 * @author nikve
 */
public class DeleteEventTest {
    DefaultDrawingView view;
    DrawingEditor edit;
    
    
    @BeforeClass
    public static void setUpClass(){
    
    }
    
    @Before
    public void setUp(){
    view = new DefaultDrawingView();
    edit = new DefaultDrawingEditor();
    view.setDrawing(new QuadTreeDrawing());
    edit.setActiveView(view);
    }
    
    @AfterClass
    public static void tearDownClass(){}
    
    @After
    public void tearDown(){}
    
    
    void selectDrawings(){
    Figure d1 = new LineFigure();
    Figure d2 = new LineFigure();
    Figure d3 = new LineFigure();
    Figure d4 = new LineFigure();
    Figure d5 = new LineFigure();
    Figure d6 = new LineFigure();
    Figure d7 = new LineFigure();
    edit.getActiveView().getDrawing().add(d1);
    edit.getActiveView().getDrawing().add(d7);
    edit.getActiveView().getDrawing().add(d2);
    edit.getActiveView().getDrawing().add(d3);
    edit.getActiveView().getDrawing().add(d4);
    edit.getActiveView().getDrawing().add(d5);
    edit.getActiveView().getDrawing().add(d6);
    edit.getActiveView().addToSelection(d1);
    edit.getActiveView().addToSelection(d2);
    edit.getActiveView().addToSelection(d3);
    edit.getActiveView().addToSelection(d4);
    edit.getActiveView().addToSelection(d5);
    edit.getActiveView().addToSelection(d6);
    edit.getActiveView().addToSelection(d7);
    }
    
    
    @Test
    public void deleteShouldDelete(){
    selectDrawings();
    
    assertEquals(7,edit.getActiveView().getDrawing().getChildCount());
    DeleteEvent event = new DeleteEvent();
    event.delete(view);
    
     assertEquals(0,edit.getActiveView().getDrawing().getChildCount());
    }
    }




