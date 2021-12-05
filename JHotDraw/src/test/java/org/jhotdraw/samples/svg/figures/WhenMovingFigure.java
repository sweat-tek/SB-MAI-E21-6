/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jhotdraw.samples.svg.figures;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.BeforeStage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import java.awt.Point;
import java.awt.geom.AffineTransform;
import java.awt.geom.Point2D;
import java.util.HashSet;
import java.util.Set;
import org.jhotdraw.draw.AbstractFigure;
import org.jhotdraw.draw.DrawingEditor;
import org.jhotdraw.draw.Figure;
import org.jhotdraw.draw.action.GroupAction;
import org.jhotdraw.draw.action.UngroupAction;

/**
 *
 * @author peter
 */
public class WhenMovingFigure extends Stage<WhenMovingFigure> {

    @ProvidedScenarioState
	@ExpectedScenarioState
    private DrawingEditor editor;

	@BeforeStage
	public void before() {
		editor.getActiveView().getDrawing().getFiguresFrontToBack().iterator().forEachRemaining(
			fig -> {
				editor.getActiveView().addToSelection(fig);
			}	
		);
	}

	WhenMovingFigure movingFigure(){
		assert editor.getActiveView().getSelectionCount() > 0;
		Set<Figure> figs = editor.getActiveView().getSelectedFigures();
		figs.forEach((Figure figure) -> {
			assert figure != null;
			AffineTransform transform = new AffineTransform();
			transform.translate(10, 10);
			figure.transform(transform);
			System.out.println(figure.getBounds() + " " + figure.getClass());
		});

		return this;
	}
}
