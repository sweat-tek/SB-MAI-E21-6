package org.jhotdraw.draw.action;

import java.awt.geom.Point2D;
import org.jhotdraw.draw.DrawingEditor;
import java.awt.geom.Rectangle2D;
import java.util.HashSet;
import java.util.Set;
import org.jhotdraw.draw.DefaultDrawingEditor;
import org.jhotdraw.draw.DefaultDrawingView;
import org.jhotdraw.draw.DrawingView;
import org.jhotdraw.draw.Figure;
import org.jhotdraw.draw.Drawing;
import org.jhotdraw.draw.DefaultDrawing;
import org.jhotdraw.samples.svg.figures.SVGRectFigure;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

/**
 *
 * @author Tobias Kristensen
 */
public class AlignActionTest {
    
    private static DrawingEditor editor;
    private static DrawingView view;
    private static Drawing drawing;
    private Figure selectedFigure1;
    private Figure selectedFigure2;
    private Set<Figure> selectedFigures;
    
    @BeforeClass
    public static void setUpClass() {
        editor = mock(DefaultDrawingEditor.class);
        view = mock(DefaultDrawingView.class);
        drawing = mock(DefaultDrawing.class);
        when(editor.getActiveView()).thenReturn(view);
        when(view.isEnabled()).thenReturn(true);
        when(view.getSelectionCount()).thenReturn(2);
        when(view.getDrawing()).thenReturn(drawing);
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        selectedFigure1 = new SVGRectFigure();
        selectedFigure2 = new SVGRectFigure();
        
        selectedFigure1.setBounds(
            new Point2D.Double(0, 0), 
            new Point2D.Double(10, 10)
        );
        
        selectedFigure2.setBounds(
            new Point2D.Double(15, 10), 
            new Point2D.Double(40, 40)
        );
        
        selectedFigures = new HashSet<>();
        selectedFigures.add(selectedFigure1);
        selectedFigures.add(selectedFigure2);
        when(view.getSelectedFigures()).thenReturn(selectedFigures);
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of updateEnabledState method, of class AlignAction.
     */
    @Test
    public void testUpdateEnabledState() {
        AlignAction instance = new AlignAction.North(editor);   
        instance.setEnabled(false);
        
        instance.updateEnabledState();

        assertTrue(instance.isEnabled());
    }

    /**
     * Test of alignFigures method, of class AlignAction.
     */
    @Test
    public void testAlignFiguresNorth() {
        AlignAction instance = new AlignAction.North(editor); 
        Rectangle2D.Double selectionBounds = instance.getSelectionBounds();
        instance.alignFigures(selectedFigures, selectionBounds);
        double northValue = instance.getSelectionBounds().y;
       
        assertEquals(northValue, selectedFigure1.getBounds().y, 0.1);
        assertEquals(northValue, selectedFigure2.getBounds().y, 0.1);
    }
    
    @Test
    public void testAlignFiguresSouth() {
        AlignAction instance = new AlignAction.South(editor); 
        Rectangle2D.Double selectionBounds = instance.getSelectionBounds();
        instance.alignFigures(selectedFigures, selectionBounds);
        double southValue = instance.getSelectionBounds().y + instance.getSelectionBounds().height;
       
        assertEquals(
            southValue,
            selectedFigure1.getBounds().y + selectedFigure1.getBounds().height,
            0.1
        );
        assertEquals(
            southValue,
            selectedFigure2.getBounds().y +  selectedFigure2.getBounds().height,
            0.1
        );
    }
    
    @Test
    public void testAlignFiguresWest() {
        AlignAction instance = new AlignAction.West(editor); 
        Rectangle2D.Double selectionBounds = instance.getSelectionBounds();
        instance.alignFigures(selectedFigures, selectionBounds);
        double westValue = instance.getSelectionBounds().x;
       
        assertEquals(westValue, selectedFigure1.getBounds().x, 0.1);
        assertEquals(westValue, selectedFigure2.getBounds().x, 0.1);
    }
    
    @Test
    public void testAlignFiguresEast() {
        AlignAction instance = new AlignAction.East(editor); 
        Rectangle2D.Double selectionBounds = instance.getSelectionBounds();
        instance.alignFigures(selectedFigures, selectionBounds);
        double eastValue = instance.getSelectionBounds().x + instance.getSelectionBounds().width;
       
        assertEquals(
            eastValue,
            selectedFigure1.getBounds().x + selectedFigure1.getBounds().width,
            0.1
        );
        assertEquals(
            eastValue,
            selectedFigure2.getBounds().x +  selectedFigure2.getBounds().width,
            0.1
        );
    }
    
    @Test
    public void testAlignFiguresHorizontal() {
        AlignAction instance = new AlignAction.Horizontal(editor); 
        Rectangle2D.Double selectionBounds = instance.getSelectionBounds();
        instance.alignFigures(selectedFigures, selectionBounds);
        double horizontalValue = instance.getSelectionBounds().x + instance.getSelectionBounds().width / 2;

        assertEquals(
            horizontalValue,
            selectedFigure1.getBounds().x + (selectedFigure1.getBounds().width / 2),
            0.1
        );
        assertEquals(
            horizontalValue,
            selectedFigure2.getBounds().x + (selectedFigure2.getBounds().width / 2),
            0.1
        );
    }
    
    @Test
    public void testAlignFiguresVertical() {
        AlignAction instance = new AlignAction.Vertical(editor); 
        Rectangle2D.Double selectionBounds = instance.getSelectionBounds();
        instance.alignFigures(selectedFigures, selectionBounds);
        double verticalValue = instance.getSelectionBounds().y + instance.getSelectionBounds().height / 2;

        assertEquals(
            verticalValue,
            selectedFigure1.getBounds().y + (selectedFigure1.getBounds().height / 2),
            0.1
        );
        assertEquals(
            verticalValue,
            selectedFigure2.getBounds().y + (selectedFigure2.getBounds().height / 2),
            0.1
        );
    }

    /**
     * Test of getSelectionBounds method, of class AlignAction.
     */
    @Test
    public void testGetSelectionBounds() {
        AlignAction instance = new AlignAction.North(editor);
        
        when(view.getSelectedFigures()).thenReturn(selectedFigures);
        
        Rectangle2D.Double expectedBounds = selectedFigure1.getBounds();
        expectedBounds.add(selectedFigure2.getBounds());
        
        assertEquals(instance.getSelectionBounds(), expectedBounds);
    }
    
}
