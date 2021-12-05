/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jhotdraw.samples.svg.figures;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.BeforeStage;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import org.jhotdraw.draw.DefaultDrawingEditor;
import org.jhotdraw.draw.DefaultDrawingView;
import org.jhotdraw.draw.DrawingEditor;
import org.jhotdraw.draw.DrawingView;
import org.jhotdraw.draw.QuadTreeDrawing;
import org.jhotdraw.geom.BezierPath;

/**
 *
 * @author peter
 */
public class GivenFigure extends Stage<GivenFigure> {
    @ProvidedScenarioState
    private DrawingEditor editor;

    @BeforeStage
    private void before() {
        editor = new DefaultDrawingEditor();
        DrawingView view = new DefaultDrawingView();
        view.setDrawing(new QuadTreeDrawing());
        editor.setActiveView(view);
    }

	GivenFigure bezierFigure(){
		SVGBezierFigure bezier = new SVGBezierFigure();
		bezier.addNode(new BezierPath.Node(1,1));
		editor.getActiveView().getDrawing().add(bezier);

		return this;
	}

	GivenFigure ellipseFigure(){
		SVGEllipseFigure ellipse = new SVGEllipseFigure();
		editor.getActiveView().getDrawing().add(ellipse);

		return this;
	}

	GivenFigure imageFigure(){
		SVGImageFigure image = new SVGImageFigure();
		editor.getActiveView().getDrawing().add(image);

		return this;
	}

	GivenFigure pathFigure(){
		SVGPathFigure path = new SVGPathFigure();
		SVGBezierFigure bezier = new SVGBezierFigure();
		bezier.addNode(new BezierPath.Node(1,1));
		path.add(1, bezier);
		editor.getActiveView().getDrawing().add(path);

		return this;
	}

	GivenFigure retangularFigure(){
		SVGRectFigure rect = new SVGRectFigure();
		editor.getActiveView().getDrawing().add(rect);

		return this;
	}


	GivenFigure textFigure(){
		SVGTextFigure textFigure = new SVGTextFigure("The next text figure");
		editor.getActiveView().getDrawing().add(textFigure);

		return this;
	}

	GivenFigure textAreaFigure() {
		SVGTextAreaFigure textFigure = new SVGTextAreaFigure("The next text figure");
		editor.getActiveView().getDrawing().add(textFigure);

		return this;
	}
}
