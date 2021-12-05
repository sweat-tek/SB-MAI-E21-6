/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jhotdraw.draw.action;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import org.jhotdraw.draw.DefaultDrawing;
import org.jhotdraw.draw.DefaultDrawingView;
import org.jhotdraw.draw.LineFigure;
import org.junit.Assert;

/**
 *
 * @author lucas
 */
public class GivenADrawnFigure extends Stage<GivenADrawnFigure> {

    @ProvidedScenarioState
    private final DefaultDrawingView drawingView;
    @ProvidedScenarioState
    private final int numberOfDrawnFigures = 25;

    
    public GivenADrawnFigure() {
        drawingView = new DefaultDrawingView();
        drawingView.setDrawing(new DefaultDrawing());

        for(int i = 0; i < numberOfDrawnFigures; i++) {
            drawingView.getDrawing().add(new LineFigure());
        }
    }

    public GivenADrawnFigure aDrawnFigure() {
        Assert.assertNotNull(drawingView.getDrawing());
        Assert.assertEquals(numberOfDrawnFigures, drawingView.getDrawing().getChildren().size());

        return self();
    }
    
}
