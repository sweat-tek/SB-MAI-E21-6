package org.jhotdraw.draw;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.BeforeStage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import java.awt.event.MouseEvent;
import java.util.HashMap;
import org.jhotdraw.samples.svg.figures.SVGRectFigure;
import org.mockito.Mockito;
import static org.mockito.Mockito.*;

public class WhenRectangle extends Stage<WhenRectangle>{
 
    @ExpectedScenarioState
    @ProvidedScenarioState
    private DrawingEditor editor;

    @ProvidedScenarioState
    private Figure expectedRect;

    private RectangleCreationTool rectangleCreationTool;
    protected transient Object defaultView;
    
    @BeforeStage
    public void before() {
        HashMap<AttributeKey, Object> attributes = new HashMap<AttributeKey, Object>();
        rectangleCreationTool = new RectangleCreationTool(new SVGRectFigure(), attributes);
        
        rectangleCreationTool.activate(editor);
        
        //Creating two mock mouse events with the positions (100,100) and (200,200)
        MouseEvent startingMousePosition = Mockito.mock(MouseEvent.class);
        doReturn(100).when(startingMousePosition).getX();
        doReturn(100).when(startingMousePosition).getY();
        defaultView = editor.getActiveView();
        Mockito.when(startingMousePosition.getSource()).thenReturn(editor.getActiveView());
        MouseEvent endingMousePosition = Mockito.mock(MouseEvent.class);
        doReturn(200).when(endingMousePosition).getX();
        doReturn(200).when(endingMousePosition).getY();
        Mockito.when(startingMousePosition.getSource()).thenReturn(editor.getActiveView());
        
        //Simulatnig the mouse clicking, dragging and realeasing.
        rectangleCreationTool.mousePressed(startingMousePosition);
        rectangleCreationTool.mouseDragged(endingMousePosition);
        rectangleCreationTool.mouseReleased(endingMousePosition);
        
        rectangleCreationTool.deactivate(editor);
        
        expectedRect = new SVGRectFigure(100,100,100,100);
    }

    WhenRectangle rectangleIsDrawn() {
        return this;
    }
}
