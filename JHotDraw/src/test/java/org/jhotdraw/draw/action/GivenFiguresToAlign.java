package org.jhotdraw.draw.action;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.BeforeStage;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import java.awt.geom.Point2D;
import org.jhotdraw.draw.DefaultDrawingEditor;
import org.jhotdraw.draw.DefaultDrawingView;
import org.jhotdraw.draw.DrawingEditor;
import org.jhotdraw.draw.DrawingView;
import org.jhotdraw.draw.Figure;
import org.jhotdraw.draw.QuadTreeDrawing;
import org.jhotdraw.samples.svg.figures.SVGRectFigure;

/**
 *
 * @author Tobias Kristensen
 */
public class GivenFiguresToAlign extends Stage<GivenFiguresToAlign> {
    
    @ProvidedScenarioState
    private DrawingEditor editor;
    
    @BeforeStage
    private void before() {
        editor = new DefaultDrawingEditor();
        DrawingView view = new DefaultDrawingView();
        view.setDrawing(new QuadTreeDrawing());
        editor.setActiveView(view);
    }
    
    GivenFiguresToAlign someSelectedRectFigures() {
        Figure f1 = new SVGRectFigure();
        Figure f2 = new SVGRectFigure();
        Figure f3 = new SVGRectFigure();
        
        f1.setBounds(new Point2D.Double(0, 0), new Point2D.Double(25, 25));
        f2.setBounds(new Point2D.Double(52, 49), new Point2D.Double(102, 85));
        f3.setBounds(new Point2D.Double(14, 32), new Point2D.Double(25, 200));
        
        editor.getActiveView().getDrawing().add(f1);
        editor.getActiveView().getDrawing().add(f2);
        editor.getActiveView().getDrawing().add(f3);
        editor.getActiveView().addToSelection(f1);
        editor.getActiveView().addToSelection(f2);
        editor.getActiveView().addToSelection(f3);
        
        return this;
    }
    
    GivenFiguresToAlign someUnselectedRectFigure() {
        Figure f1 = new SVGRectFigure();
        Figure f2 = new SVGRectFigure();
        Figure f3 = new SVGRectFigure();
        
        f1.setBounds(new Point2D.Double(152, 130), new Point2D.Double(205, 199));
        f2.setBounds(new Point2D.Double(120, 13), new Point2D.Double(150, 45));
        f3.setBounds(new Point2D.Double(380, 198), new Point2D.Double(500, 422));
        
        editor.getActiveView().getDrawing().add(f1);
        editor.getActiveView().getDrawing().add(f2);
        editor.getActiveView().getDrawing().add(f3);
        
        return this;
    }
    
}
