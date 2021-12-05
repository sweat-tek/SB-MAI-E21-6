/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jhotdraw.samples.svg.figures;

import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.util.List;
import org.jhotdraw.draw.AbstractFigure;
import org.jhotdraw.draw.DrawingEditor;
import org.jhotdraw.draw.Figure;
import static org.junit.Assert.assertTrue;
import org.junit.Before;

/**
 *
 * @author peter
 */
public class ThenFigurePositioned {

    @ExpectedScenarioState
    private DrawingEditor editor;

    private List<Figure> figureList;

	ThenFigurePositioned figureHasMoved(){
		figureList = editor.getActiveView().getDrawing().getFiguresFrontToBack();
		assert figureList.size() > 0;

		figureList.forEach((Figure figure) -> {
			Rectangle2D.Double bounds = figure.getBounds();
			assertBounds(bounds);
		});
		return this;
	}

	private void assertBounds(Rectangle2D.Double bounds) {
		assertTrue(bounds.x != 0);
		assertTrue(bounds.y != 0);
	}
}
