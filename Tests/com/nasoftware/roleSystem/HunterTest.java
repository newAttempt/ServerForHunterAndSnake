package com.nasoftware.roleSystem;

import com.nasoftware.mapSystem.Point;
import com.nasoftware.mapSystem.Vec;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by zeyongshan on 7/14/17.
 */
class HunterTest {
    @Test
    void HunterCreateTest()
    {
        Hunter hunter = new Hunter();
        assertEquals(0, hunter.getX());
        assertEquals(0, hunter.getY());
        Vec direction = new Vec(0, 0);
        assertEquals("0.0-0.0", direction.toString());
        assertEquals("0.0-0.0", hunter.getDirection().toString());

        Hunter hunter1 = new Hunter(new Point(1, 2));
        assertEquals("1.0-2.0", hunter1.toString());
        assertEquals(direction.toString(), hunter1.getDirection().toString());

        Hunter hunter2 = new Hunter(new Point(1, 2), new Vec(2, 3));
        assertEquals("1.0-2.0", hunter2.toString());
        assertEquals("2.0-3.0", hunter2.getDirection().toString());

    }

    @Test
    void addLevelAndMinLevelTest()
    {
        Hunter hunter = new Hunter();
        assertEquals(1, hunter.getLevel());
        hunter.addLevel();
        assertEquals(2, hunter.getLevel());
        hunter.addLevel();
        assertEquals(3, hunter.getLevel());
        hunter.addLevel();
        assertEquals(4, hunter.getLevel());
        hunter.addLevel();
        assertEquals(5, hunter.getLevel());
        hunter.addLevel();
        assertEquals(6, hunter.getLevel());
        hunter.addLevel();
        assertEquals(6, hunter.getLevel());
        hunter.minLevel();
        assertEquals(5, hunter.getLevel());
        hunter.minLevel();
        assertEquals(4, hunter.getLevel());
        hunter.minLevel();
        assertEquals(3, hunter.getLevel());
        hunter.minLevel();
        assertEquals(2, hunter.getLevel());
        hunter.minLevel();
        assertEquals(1, hunter.getLevel());
        hunter.minLevel();
        assertEquals(1, hunter.getLevel());
    }
}