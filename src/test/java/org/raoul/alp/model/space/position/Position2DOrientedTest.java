package org.raoul.alp.model.space.position;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Position2DOrientedTest {

    @Test
    public void testAngle0() {
        Position2DOriented p2do = new Position2DOriented(0, 0, null, 0);
        Position2D p2d = new Position2D(2, 0, null);
        
        assertEquals(0, p2do.anglevariation(p2d), 0);
    }

    @Test
    public void testAngleMinusPIby2() {
        Position2DOriented p2do = new Position2DOriented(0, 0, null, 0);
        Position2D p2d = new Position2D(0, 3, null);
        
        assertEquals(-Math.PI/2, p2do.anglevariation(p2d), 0.0001);
    }

    @Test
    public void testAnglePIby2() {
        Position2DOriented p2do = new Position2DOriented(0, 0, null, Math.PI);
        Position2D p2d = new Position2D(0, 3, null);
        
        assertEquals(Math.PI/2, p2do.anglevariation(p2d), 0.0001);
    }

    @Test
    public void testAngleMinusPI() {
        Position2DOriented p2do = new Position2DOriented(0, 0, null, 0);
        Position2D p2d = new Position2D(-5, 0, null);
        
        assertEquals(-Math.PI, p2do.anglevariation(p2d), 0.0001);
    }

    @Test
    public void testAnglePI() {
        Position2DOriented p2do = new Position2DOriented(0, 0, null, Math.PI);
        Position2D p2d = new Position2D(5, 0, null);
        
        assertEquals(Math.PI, p2do.anglevariation(p2d), 0.0001);
    }

    @Test
    public void testAngleQuarterPI() {
        Position2DOriented p2do = new Position2DOriented(0, 0, null, Math.PI/4);
        Position2D p2d = new Position2D(5, 0, null);
        
        assertEquals(Math.PI/4, p2do.anglevariation(p2d), 0.0001);
    }

    @Test
    public void testAngleThreeQuarterPI() {
        Position2DOriented p2do = new Position2DOriented(0, 0, null, Math.PI/4);
        Position2D p2d = new Position2D(0, -3, null);
        
        assertEquals(3*Math.PI/4, p2do.anglevariation(p2d), 0.0001);
    }

}
