package org.jhotdraw.draw;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.BeforeStage;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;


public class GivenRectangle extends Stage<GivenRectangle> {
    
    @ProvidedScenarioState
    private DrawingEditor editor;

    @BeforeStage
    private void before() {
        editor = new DefaultDrawingEditor();
        DrawingView view = new DefaultDrawingView();
        view.setDrawing(new QuadTreeDrawing());
        editor.add(view);
        editor.setActiveView(view);
    }
    
    GivenRectangle emptyDrawing(){
        return this;
    }

}
