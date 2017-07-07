package com.nasoftware.roleSystem;

import com.nasoftware.mapSystem.Point;
import com.nasoftware.mapSystem.Vec;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by zeyongshan on 7/6/17.
 */
class SnakeTest {
    private Snake snake;

    public SnakeTest() {
        snake = new Snake(new Point(1, 1));
    }

    @Test
    public void snakeGenerateTest() {
        assertEquals("1.0-1.0 ", snake.toString()) ;
    }

    @Test
    public void movingOneTest() {
        snake.move(new Vec(0, 1), 1);
        assertEquals("1.0-2.0 ", snake.toString());
    }

    @Test
    public void growTest()
    {
        snake.grow(1);
        assertEquals("1.0-1.0 1.0-2.0 ", snake.toString());
        snake.grow(1);
        assertEquals("1.0-1.0 1.0-2.0 1.0-3.0 ", snake.toString());
        snake.grow(3);
        assertEquals("1.0-1.0 1.0-2.0 1.0-3.0 1.0-6.0 ", snake.toString());
    }

    @Test
    public void movingMutipleTest()
    {   snake.grow(1);
        assertEquals("1.0-1.0 1.0-2.0 ", snake.toString());
        snake.grow(1);
        assertEquals("1.0-1.0 1.0-2.0 1.0-3.0 ", snake.toString());
        snake.grow(3);
        assertEquals("1.0-1.0 1.0-2.0 1.0-3.0 1.0-6.0 ", snake.toString());
        snake.move(new Vec(0, 1), 1);
        assertEquals("1.0-2.0 1.0-1.0 1.0-2.0 1.0-3.0 ", snake.toString());
    }
}