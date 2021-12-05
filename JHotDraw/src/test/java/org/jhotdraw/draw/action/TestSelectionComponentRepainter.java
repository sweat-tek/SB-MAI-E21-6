/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jhotdraw.draw.action;

import java.util.Arrays;
import javax.swing.JComponent;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;
import org.jhotdraw.draw.DefaultDrawingEditor;
import org.jhotdraw.draw.DefaultDrawingView;
import org.jhotdraw.draw.DrawingEditor;
import org.jhotdraw.draw.FigureSelectionListener;
/**
 *
 * @author lucas
 */
public class TestSelectionComponentRepainter {
    private SelectionComponentRepainter selectCompRepainter;
 

    public TestSelectionComponentRepainter() { 
    }


    @Before
    public void setUp() {
        DrawingEditor editor = new DefaultDrawingEditor();
        JComponent component = new JComponent() {};
        selectCompRepainter = new SelectionComponentRepainter(editor, component);
    }

    
    
    @After
    public void tearDown() {
    }

    
    @Test
    public void addListener() {
        DefaultDrawingView view = new DefaultDrawingView();

        //Checks if empty - which they should be
        Assert.assertFalse(Arrays.asList(view.getPropertyChangeListeners()).contains(selectCompRepainter));
        Assert.assertFalse(Arrays.asList(view.getListeners(FigureSelectionListener.class)).contains(selectCompRepainter));
        
        //Checks if not empty
        //Assert.assertTrue(Arrays.asList(view.getPropertyChangeListeners()).contains(selectCompRepainter));
        //Assert.assertTrue(Arrays.asList(view.getListeners(FigureSelectionListener.class)).contains(selectCompRepainter));
        
        
        //Adds listener, array shouldnt be empty anymore
        selectCompRepainter.addListener(view);
        
        Assert.assertTrue(Arrays.asList(view.getPropertyChangeListeners()).contains(selectCompRepainter));
        Assert.assertTrue(Arrays.asList(view.getListeners(FigureSelectionListener.class)).contains(selectCompRepainter));
        
        //Assert.assertFalse(Arrays.asList(view.getPropertyChangeListeners()).contains(selectCompRepainter));
        //Assert.assertFalse(Arrays.asList(view.getListeners(FigureSelectionListener.class)).contains(selectCompRepainter));
    }

    
    
    @Test
    public void removeListener() {
        DefaultDrawingView view = new DefaultDrawingView();
        selectCompRepainter.addListener(view);
        
        Assert.assertTrue(Arrays.asList(view.getPropertyChangeListeners()).contains(selectCompRepainter));
        Assert.assertTrue(Arrays.asList(view.getListeners(FigureSelectionListener.class)).contains(selectCompRepainter));
        
        //Removes listener - array should be empty
        selectCompRepainter.removeListener(view);
        
        Assert.assertFalse(Arrays.asList(view.getPropertyChangeListeners()).contains(selectCompRepainter));
        Assert.assertFalse(Arrays.asList(view.getListeners(FigureSelectionListener.class)).contains(selectCompRepainter));
        
        //Assert.assertTrue(Arrays.asList(view.getPropertyChangeListeners()).contains(selectCompRepainter));
        //Assert.assertTrue(Arrays.asList(view.getListeners(FigureSelectionListener.class)).contains(selectCompRepainter));
        
        
    }


    
    
}
