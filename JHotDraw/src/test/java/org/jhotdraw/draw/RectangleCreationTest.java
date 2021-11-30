package org.jhotdraw.draw;

import com.tngtech.jgiven.junit.ScenarioTest;
import org.junit.Test;

public class RectangleCreationTest extends ScenarioTest<GivenRectangle,WhenRectangle,ThenRectangle> {
    @Test
    public void creatingARectangleTest() {
        given().emptyDrawing();

        when().rectangleIsDrawn();

        then().newRectangleIsCreated();
    }
}
