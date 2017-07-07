package com.nasoftware.roleSystem;


import com.nasoftware.mapSystem.*;
import org.junit.jupiter.api.Test;

/**
 * Created by zeyongshan on 7/6/17.
 */
class HunterTest {

    @Test
    public void toStringTest()
    {
        double x = 100.5;
        double y = 778.6;
        String id = "123456";
        Hunter hunter = new Hunter(id, x, y);
        assert(hunter.toString().equals("123456-100.5-778.6"));
    }

    @Test
    public void HunterMoveTest()
    {
        Hunter hunter = new Hunter("121212", 15, 15);
        Vec direction = new Vec(-1, -1);
        direction.getMovedPoint(hunter, 4);
        assert(hunter.toString().equals("13, 13"));
    }
}