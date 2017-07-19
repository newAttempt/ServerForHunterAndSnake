package com.nasoftware.roleSystem;

import com.nasoftware.mapSystem.Point;
import com.nasoftware.mapSystem.Vec;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by zeyongshan on 7/14/17.
 */
class SnakeTest {
    @Test
    void snakeCreateTest()
    {
        Snake snake = new Snake(new Point(0, 0), new Vec(1, 2), "1-1");
        assertEquals("id: 1-1 0.0-0.0 ", snake.toString());
        assertEquals("1.0-2.0", snake.getDirection().toString());
        Snake snake1 = new Snake("1-1");
        assertEquals("id: 1-1 0.0-0.0 ", snake.toString());
        assertEquals("1.0-2.0", snake.getDirection().toString());
    }
}