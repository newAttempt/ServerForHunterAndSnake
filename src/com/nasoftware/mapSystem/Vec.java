package com.nasoftware.mapSystem;
import java.lang.Math.*;

/**
 * Created by zeyongshan on 7/6/17.
 */
public class Vec {
    private double x;
    private double y;

    public Vec(double x, double y)
    {
        this.x = x;
        this.y = y;
    }

    public String toString()
    {
        return x + "-" + y;
    }

    public Point getMovedPoint(Point ori, double moveDistance)
    {
        double moveDistanceRate = Math.pow(moveDistance, 2)/(Math.pow(x, 2) + Math.pow(y, 2));
        ori.addXY(moveDistanceRate * x, moveDistanceRate * y);
        return ori;
    }
}
