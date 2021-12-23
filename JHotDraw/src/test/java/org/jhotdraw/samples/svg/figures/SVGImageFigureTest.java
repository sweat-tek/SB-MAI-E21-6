package org.jhotdraw.samples.svg.figures;

import org.junit.Test;
import java.awt.image.BufferedImage;
import java.util.Collection;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import static org.junit.Assert.*;
import java.awt.geom.*;

public class SVGImageFigureTest {
    private SVGImageFigure figure;

    public SVGImageFigureTest() {}

    @BeforeClass
    public static void setUpClass() {}

    @AfterClass
    public static void tearDownClass() {}

    @Before
    public void setUp() {
        this.figure = new SVGImageFigure(0, 0, 0, 0);
    }

    @After
    public void tearDown() {}

    @Test
    public void testCanConnect() {
        assertFalse("Can connect?", figure.canConnect());
    }

    @Test
    public void testClone() {
        SVGImageFigure clone = figure.clone();
        assertSame(clone, clone);
    }

    @Test
    public void testCreateHandles() {
        Collection<org.jhotdraw.draw.Handle> handle = figure.createHandles(1);
        assertNotNull("Is not null", handle);
    }

    @Test
    public void testGetBounds() {
        assertTrue("Is empty", figure.isEmpty());
    }

    @Test
    public void testGetBufferedImage() {
        BufferedImage bufferedImage = figure.getBufferedImage();
        assertNull("Check if null", bufferedImage);
    }

    @Test
    public void testGetDrawingArea() {
        Rectangle2D.Double drawingArea = figure.getDrawingArea();
        assertNotNull("Is not null", drawingArea);
    }

    @Test
    public void testGetHeight() {
        double height = figure.getHeight();
        assertNotNull("Is not null", height);
    }

    @Test
    public void testGetImageData() {
        byte[] data = figure.getImageData(); // Should be null cause no image data
        assertNull("Is not null", data);
    }

    @Test
    public void testGetTransformRestoreData() {
        Object object = figure.getTransformRestoreData();
        assertNotNull("Is not null", object);
    }

    @Test
    public void testGetWidth() {
        double width = figure.getWidth();
        assertNotNull("Is not null", width);
    }

    @Test
    public void testGetX() {
        double X = figure.getX();
        assertNotNull("Is not null", X);
    }

    @Test
    public void testGetY() {
        double Y = figure.getY();
        assertNotNull("Is not null", Y);
    }

    @Test
    public void testIsEmpty() {
        assertTrue("Is not null", figure.isEmpty());
    }

}
