package com.nasoftware.dataSystem;

import com.nasoftware.roleSystem.Hunter;
import com.nasoftware.roleSystem.Snake;
import org.junit.jupiter.api.Test;
import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by zeyongshan on 7/14/17.
 */
class RoomTest {
    @Test
    void roomCreateTest()
    {
        Room room = new Room("1");
        assertEquals(0, room.getHunterList().size());
    }

    @Test
    void roomAddHunterTest()
    {
        Room room = new Room("1");
        Hunter hunter = new Hunter("1-2");
        boolean result = room.addHunter(hunter);
        assertEquals(true, result);
        assertEquals(true, room.getHunterList().contains(hunter));
        hunter = new Hunter("2-2");
        result = room.addHunter(hunter);
        assertEquals(false, result);
        assertEquals(false, room.getHunterList().contains(hunter));
        for(int i = 3; i<=9; ++i)
        {
            hunter = new Hunter("1-" + i);
            result = room.addHunter(hunter);
            assertEquals(true, result);
            assertEquals(true, room.getHunterList().contains(hunter));
        }
        hunter = new Hunter("1-" + 10);
        result = room.addHunter(hunter);
        assertEquals(false, result);
        assertEquals(false, room.getHunterList().contains(hunter));
        hunter = new Hunter("1-8");
        result = room.addHunter(hunter);
        assertEquals(false, result);
        assertEquals(true, room.getHunterList().contains(hunter));

        Snake snake = new Snake("1-2");
        result = room.addSnake(snake);
        assertEquals(false, result);
        snake = new Snake("1-11");
        result = room.addSnake(snake);
        assertEquals(true, result);
    }
}