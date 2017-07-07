package com.nasoftware.mapSystem;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by zeyongshan on 7/6/17.
 */
class PointTest {

    @Test
    public void toStringTest()
    {
        double x = 100.5;
        double y = 121.3;
        Point point = new Point(x, y);
        assertEquals("100.5-121.3", point.toString());
    }

    @Test
    public void getDistanceTest()
    {
        Point p1 = new Point(100, 100);
        Point p2 = new Point(100, 100);
        assertEquals(0, p1.getDistance(p2));
        Point p3 = new Point(1, 2);
        Point p4 = new Point(1, 3);
        assertEquals(1, p3.getDistance(p4));
        Point p5 = new Point(1, 1);
        Point p6 = new Point(2, 2);
        assertEquals(Math.sqrt(2), p5.getDistance(p6));
    }

}