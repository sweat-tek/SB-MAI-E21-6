package org.jhotdraw.draw;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import java.util.Set;
import org.jhotdraw.samples.svg.figures.SVGRectFigure;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ThenRectangle extends Stage<ThenRectangle>{
    
    @ExpectedScenarioState
    private DrawingEditor editor;

    @ExpectedScenarioState
    private Figure expectedRect;

    ThenRectangle newRectangleIsCreated() {
        assertRectangleDimensions((SVGRectFigure) editor.getActiveView().getDrawing().getChild(0),(SVGRectFigure) expectedRect);
        assertTrue("Is a rectangle",(editor.getActiveView().getDrawing().getChild(0).getClass() == (SVGRectFigure.class)));
        return this;
    }

    private void assertRectangleDimensions(SVGRectFigure createdRectangle,SVGRectFigure expectedRectangle) {
        assertEquals("Comparing X values",createdRectangle.getX(), expectedRectangle.getX(),1);
        assertEquals("Comparing Y values", createdRectangle.getY(), expectedRectangle.getY(),1);
        assertEquals("Comparing width values", createdRectangle.getWidth(), expectedRectangle.getWidth(),1);
        assertEquals("Comparing height values", createdRectangle.getHeight(), expectedRectangle.getHeight(),1);
    }
}
