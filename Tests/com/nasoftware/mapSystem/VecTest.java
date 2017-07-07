package com.nasoftware.mapSystem;
import org.junit.jupiter.api.Test;


/**
 * Created by zeyongshan on 7/6/17.
 */
class VecTest {
    @Test
    public void toStringTest()
    {
        Vec vector = new Vec(10, 5);
        assert(vector.toString().equals("10-5"));
    }

    @Test
    public void getMovedPointTest()
    {
        Vec vec = new Vec(10.0, 10.0);
        Point point = new Point(10, 10);
        vec.getMovedPoint(point, 16);
        assert(point.toString().equals("14-14"));
        Point point1 = vec.getMovedPoint(point, 16);
        assert(point1.toString().equals("18-18"));
    }
}