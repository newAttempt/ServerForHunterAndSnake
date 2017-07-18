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
    private Room room;
    RoomTest()
   {
       room = new Room("1");
       assertEquals("1", room.getRoomID());
   }

   @Test
    public void AddHunterSnakeTest()
   {

       for(int i=0; i<8; ++i)
       {
           String id = room.getNewHunterID();
           assertEquals("1-1" + i, id);
           Hunter hunter = new Hunter(id);
           room.addHunter(hunter);
           assertEquals(hunter, room.getHunterFromID(id));
           assertEquals(i + 1, room.getHunterList().size());
       }
       String id = room.getNewHunterID();
       assertEquals(null, id);

        for(int i=0; i<8; ++i)
       {
           String sid = room.getNewSnakeID();
           assertEquals("1-0" + i, sid);
           Snake snake = new Snake(sid);
           room.addSnake(snake);
           assertEquals(snake, room.getSnakeFromID(sid));
           assertEquals(i + 1, room.getSnakeList().size());
       }
       String sid = room.getNewSnakeID();
       assertEquals(null, id);

       boolean result = room.bestToStart();
       assertEquals(true, result);
       result = room.canStart();
       assertEquals(true, result);
   }
}

