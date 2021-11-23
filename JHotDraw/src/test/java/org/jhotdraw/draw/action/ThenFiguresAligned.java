package org.jhotdraw.draw.action;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import java.awt.geom.Rectangle2D;
import java.util.Set;
import org.jhotdraw.draw.DrawingEditor;
import org.jhotdraw.draw.Figure;
import org.junit.Assert;
import static org.junit.Assert.assertEquals;

/**
 *
 * @author Tobias Kristensen
 */
public class ThenFiguresAligned extends Stage<ThenFiguresAligned> {
    @ExpectedScenarioState
    private DrawingEditor editor;

    @ExpectedScenarioState
    private Set<Figure> selectedFigures;
    
    @ExpectedScenarioState
    private Set<Figure> unselectedFigures;
    
    ThenFiguresAligned onlySelectedFiguresAreAlignedNorth() {
        Rectangle2D.Double bounds = selectedFigures.iterator().next().getBounds();
        double northValue = bounds.y;
        
        selectedFigures.forEach(f -> {
            assertEquals(northValue, f.getBounds().y, 0.1);
        });
        
        unselectedFigures.forEach(f -> {
            Assert.assertNotEquals(northValue, f.getBounds().y, 0.1);
        });
        
        return this;
    }
    
    ThenFiguresAligned onlySelectedFiguresAreAlignedSouth() {
        Rectangle2D.Double bounds = selectedFigures.iterator().next().getBounds();
        double southValue = bounds.y + bounds.height;
        
        selectedFigures.forEach(f -> {
            assertEquals(southValue, f.getBounds().y + f.getBounds().height, 0.1);
        });
        
        unselectedFigures.forEach(f -> {
            Assert.assertNotEquals(southValue, f.getBounds().y + f.getBounds().height, 0.1);
        });
        
        return this;
    }
    
    ThenFiguresAligned onlySelectedFiguresAreAlignedWest() {
        Rectangle2D.Double bounds = selectedFigures.iterator().next().getBounds();
        double westValue = bounds.x;
        
        selectedFigures.forEach(f -> {
            assertEquals(westValue, f.getBounds().x, 0.1);
        });
        
        unselectedFigures.forEach(f -> {
            Assert.assertNotEquals(westValue, f.getBounds().x, 0.1);
        });
        
        return this;
    }
    
    ThenFiguresAligned onlySelectedFiguresAreAlignedEast() {
        Rectangle2D.Double bounds = selectedFigures.iterator().next().getBounds();
        double eastValue = bounds.x + bounds.width;
        
        selectedFigures.forEach(f -> {
            assertEquals(eastValue, f.getBounds().x + f.getBounds().width, 0.1);
        });
        
        unselectedFigures.forEach(f -> {
            Assert.assertNotEquals(eastValue, f.getBounds().x + f.getBounds().width, 0.1);
        });
        
        return this;
    }
    
    ThenFiguresAligned onlySelectedFiguresAreAlignedHorizontally() {
        Rectangle2D.Double bounds = selectedFigures.iterator().next().getBounds();
        double horizontalValue = bounds.x + bounds.width / 2;
        
        selectedFigures.forEach(f -> {
            assertEquals(horizontalValue, f.getBounds().x + f.getBounds().width / 2, 0.1);
        });
        
        unselectedFigures.forEach(f -> {
            Assert.assertNotEquals(horizontalValue, f.getBounds().x + f.getBounds().width / 2, 0.1);
        });
        
        return this;
    }
    
    ThenFiguresAligned onlySelectedFiguresAreAlignedVertically() {
        Rectangle2D.Double bounds = selectedFigures.iterator().next().getBounds();
        double verticalValue = bounds.y + bounds.height / 2;
        
        selectedFigures.forEach(f -> {
            assertEquals(verticalValue, f.getBounds().y + f.getBounds().height / 2, 0.1);
        });
        
        unselectedFigures.forEach(f -> {
            Assert.assertNotEquals(verticalValue, f.getBounds().y + f.getBounds().height / 2, 0.1);
        });
        
        return this;
    }
    
}
