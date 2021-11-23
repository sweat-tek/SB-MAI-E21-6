/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jhotdraw.app.action;

import com.tngtech.jgiven.junit.ScenarioTest;
import java.awt.Point;
import org.jhotdraw.draw.DefaultDrawingEditor;
import org.jhotdraw.draw.DefaultDrawingView;
import org.jhotdraw.draw.DrawingEditor;
import org.jhotdraw.draw.DrawingView;
import org.jhotdraw.draw.Figure;
import org.jhotdraw.draw.QuadTreeDrawing;
import org.jhotdraw.samples.svg.figures.SVGRectFigure;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author joakimbetzer
 */
public class UndoActionTest extends ScenarioTest<GivenObject, WhenMakeChange, ThenUndo>{
    
    DrawingEditor editor;
    Point p = new Point(1,1);
    
    public UndoActionTest() {
    }
    
    @Before
    public void setUp() {
        editor = new DefaultDrawingEditor();
        DrawingView view = new DefaultDrawingView();
        view.setDrawing(new QuadTreeDrawing());
        editor.setActiveView(view);
    }

    @Test
    public void testUndo() {
        // TODO review the generated test code and remove the default call to fail.
        Figure f = new SVGRectFigure(1, 1, 100, 100);
        editor.getActiveView().getDrawing().add(f);
        
        assertTrue(editor.getActiveView().findFigure(p)==f);
        
        editor.getActiveView().getDrawing().remove(f);
        
        assertTrue(editor.getActiveView().findFigure(p)==null);
        
    }
    
    @Test
    public void acceptanceTest(){
        given().givenObject();
        
        when().undoRectangle();
        
        then().rectangleUndone();
    }
    
}
