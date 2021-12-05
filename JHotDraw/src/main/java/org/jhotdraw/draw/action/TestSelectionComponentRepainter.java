/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jhotdraw.draw.action;

//import java.beans.PropertyChangeEvent;
//import java.beans.PropertyChangeListener;
import java.util.Arrays;
import javax.swing.JComponent;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.jhotdraw.draw.DefaultDrawingEditor;
import org.jhotdraw.draw.DefaultDrawingView;
import org.jhotdraw.draw.DrawingEditor;
//import org.jhotdraw.draw.DrawingView;
import org.jhotdraw.draw.FigureSelectionListener;
import org.junit.Assert;
/**
 *
 * @author lucas
 */
public class TestSelectionComponentRepainter {
    private SelectionComponentRepainter scr;
    //private AbstractComponentRepainter acr;
    //private PropertyChangeEvent evt;
    //private Object source;

    public TestSelectionComponentRepainter() { 
    }

    @BeforeClass
    public static void setUpClass() {
        System.out.println("beforeclass");
    }

    @AfterClass
    public static void tearDownClass() {
        System.out.println("afterclass");

    }

    @Before
    public void setUp() {
        DrawingEditor editor = new DefaultDrawingEditor();
        JComponent component = new JComponent() {};
        //evt = new PropertyChangeEvent(source, null, null, null);
        scr = new SelectionComponentRepainter(editor, component);
        //acr = new AbstractComponentRepainter(editor, component);
    }

    @After
    public void tearDown() {
    }

    @Test
    public void addListener() {
        DefaultDrawingView view = new DefaultDrawingView();

        Assert.assertTrue(Arrays.asList(view.getPropertyChangeListeners()).contains(scr));
        Assert.assertTrue(Arrays.asList(view.getListeners(FigureSelectionListener.class)).contains(scr));

        scr.addListener(view);

        Assert.assertFalse(Arrays.asList(view.getPropertyChangeListeners()).contains(scr));
        Assert.assertFalse(Arrays.asList(view.getListeners(FigureSelectionListener.class)).contains(scr));
    }

    @Test
    public void removeListener() {
        DefaultDrawingView view = new DefaultDrawingView();

        scr.removeListener(view);

        Assert.assertFalse(Arrays.asList(view.getPropertyChangeListeners()).contains(scr));
        Assert.assertFalse(Arrays.asList(view.getListeners(FigureSelectionListener.class)).contains(scr));
    }

    /*@Test
    public void activeViewPropertyChangedHandler() {
        String name = evt.getPropertyName();
        String expectedName = DrawingEditor.ACTIVE_VIEW_PROPERTY;

        Assert.assertEquals(expectedName, name);


    }

    @Test
    public void drawingPropertyChangedHandler() {

    }*/
}
