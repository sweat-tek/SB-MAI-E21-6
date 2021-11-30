package org.jhotdraw.draw;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import java.util.Set;
import org.jhotdraw.samples.svg.figures.SVGRectFigure;
import static org.junit.Assert.assertEquals;

public class ThenRectangle extends Stage<ThenRectangle>{
    
    @ExpectedScenarioState
    private DrawingEditor editor;

    @ExpectedScenarioState
    private Figure expectedRect;

    ThenRectangle newRectangleIsCreated() {
        assertRectangleDimensions((SVGRectFigure) editor.getActiveView().getDrawing().getChild(0),(SVGRectFigure) expectedRect);
        return this;
    }

    private void assertRectangleDimensions(SVGRectFigure createdRectangle,SVGRectFigure expectedRectangle) {
        System.out.println("rect "+createdRectangle.getBounds());
        assertEquals("Comparing X values",createdRectangle.getX(), expectedRectangle.getX(),1);
        assertEquals("Comparing Y values", createdRectangle.getY(), expectedRectangle.getY(),1);
        assertEquals("Comparing width values", createdRectangle.getWidth(), expectedRectangle.getWidth(),1);
        assertEquals("Comparing height values", createdRectangle.getHeight(), expectedRectangle.getHeight(),1);
    }
}
