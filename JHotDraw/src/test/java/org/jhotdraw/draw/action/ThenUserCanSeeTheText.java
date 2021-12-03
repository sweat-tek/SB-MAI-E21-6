/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jhotdraw.draw.action;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.BeforeStage;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import java.awt.Point;
import org.jhotdraw.draw.DefaultDrawingEditor;
import org.jhotdraw.draw.DefaultDrawingView;
import org.jhotdraw.draw.DrawingEditor;
import org.jhotdraw.draw.DrawingView;
import org.jhotdraw.draw.QuadTreeDrawing;
import org.jhotdraw.draw.TextAreaCreationTool;
import org.jhotdraw.draw.TextHolderFigure;
import org.jhotdraw.draw.action.ThenFiguresGrouped;
import org.jhotdraw.samples.svg.figures.SVGTextAreaFigure;
import org.jhotdraw.samples.svg.figures.SVGTextFigure;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 *
 * @author Zed V2
 */
public class ThenUserCanSeeTheText extends Stage<ThenUserCanSeeTheText> {
    
    private TextAreaCreationTool instance;
    private TextHolderFigure textHolder;
    
    
    
    @BeforeStage
    private void before() {
    textHolder = new SVGTextFigure("Hello");
    instance = new TextAreaCreationTool(textHolder);
    instance.editor = new DefaultDrawingEditor();
    DrawingView view = new DefaultDrawingView();
    view.setDrawing(new QuadTreeDrawing());
    instance.editor.setActiveView(view);
    
    }
    
    ThenUserCanSeeTheText TheUserCanEditTheText() {
    instance.getDrawing().add(textHolder);
    textHolder.setText("text");
    String result = "text";
    assertEquals(textHolder.getText(), result);
    return this; 
}

}
