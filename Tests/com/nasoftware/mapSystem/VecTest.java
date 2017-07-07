package com.nasoftware.mapSystem;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


/**
 * Created by zeyongshan on 7/6/17.
 */
class VecTest {
    @Test
    public void toStringTest()
    {
        Vec vector = new Vec(10, 5);
        assertEquals("10.0-5.0", vector.toString());
    }

    @Test
    public void movePointTest()
    {
        Vec vec = new Vec(3, 4);
        Point point = new Point(10, 10);
        vec.movePoint(point, 10);
        assertEquals("16.0-18.0", point.toString());
        Point point1 = vec.movePoint(point, 10);
        assertEquals("22.0-26.0", point1.toString());
    }

    @Test
    public void getMovedPointTest()
    {
        Vec vec = new Vec(3, 4);
        Point point = new Point(10, 10);
        vec.getMovedPoint(point, 5);
        assertEquals("10.0-10.0", point.toString());
        Point point1 = vec.getMovedPoint(point, 5);
        assert point1.toString().equals("13.0-14.0");
    }
}