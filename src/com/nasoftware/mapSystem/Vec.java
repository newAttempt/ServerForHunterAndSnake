package com.nasoftware.mapSystem;
import java.lang.Math.*;

/**
 * Created by zeyongshan on 7/6/17.
 */
public class Vec {
    private double x;
    private double y;

    public Vec(double x, double y) {
        int bit = 0;
        bit = Math.max((int)x/10, (int)y/10);
        this.x = x/Math.pow(10, bit);
        this.y = y/Math.pow(10, bit);
    }

    public String toString() {
        return x + "-" + y;
    }

    public Point movePoint(Point ori, double moveDistance) {
        double moveDistanceRate =Math.sqrt(Math.pow(moveDistance, 2) / ((Math.pow(x, 2) + Math.pow(y, 2))));
        ori.addXY(moveDistanceRate * x, moveDistanceRate * y);
        return ori;
    }

    public Point getMovedPoint(Point ori, double moveDistance)
    {
        double moveDistanceRate =Math.sqrt(Math.pow(moveDistance, 2) / ((Math.pow(x, 2) + Math.pow(y, 2))));
        Point result = new Point(ori);
        result.addXY(moveDistanceRate * x, moveDistanceRate * y);
        return result;
    }
}
