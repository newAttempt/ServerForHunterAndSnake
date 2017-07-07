package com.nasoftware.mapSystem;

import com.nasoftware.mapSystem.Point;
import org.junit.jupiter.api.Test;

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
        assert(point.toString().equals("100.5-121.3"));
    }

    @Test
    public void getDistanceTest()
    {
        Point p1 = new Point(100, 100);
        Point p2 = new Point(100, 100);
        assert(p1.getDistance(p2) == 0);
        Point p3 = new Point(1, 2);
        Point p4 = new Point(1, 3);
        assert(p3.getDistance(p4) == 1);
        Point p5 = new Point(1, 1);
        Point p6 = new Point(2, 2);
        assert(p5.getDistance(p6) == Math.sqrt(2));
    }

}