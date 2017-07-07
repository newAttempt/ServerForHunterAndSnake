package com.nasoftware.roleSystem;


import com.nasoftware.mapSystem.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

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
        assertEquals("123456-100.5-778.6", hunter.toString());
    }

    @Test
    public void HunterMoveTest()
    {
        Hunter hunter = new Hunter("121212", 2, 2);
        Vec direction = new Vec(3, 4);
        direction.movePoint(hunter, 5);
        assertEquals("121212-5.0-6.0", hunter.toString());
    }
}