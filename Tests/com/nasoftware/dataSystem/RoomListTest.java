package com.nasoftware.dataSystem;

import com.nasoftware.roleSystem.Hunter;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by zeyongshan on 7/17/17.
 */
class RoomListTest {
    private RoomList roomList;

    RoomListTest()
    {
        roomList = new RoomList();
    }

    @Test
    public void addRoomTest()
    {
        int result = roomList.addNewRoom();
        assertEquals(0, result);
        result = roomList.addNewRoom();
        assertEquals(1, result);
        Room temp = roomList.getRoomFromID(new Integer(result).toString());
        Room roomForMatching = new Room("1");
        assertEquals(roomForMatching, temp);
    }

    @Test
    public void addHunterAndSnakeToRoomTest()
    {
        int result = roomList.addNewRoom();
        assertEquals(0, result);
        Hunter hunter = new Hunter(result + "-10");
        boolean comple = roomList.addHunterToRoom(new Integer(result).toString(), hunter);
        assertEquals(true, comple);
        comple = roomList.addHunterToRoom(new Integer(result).toString(), hunter);
        assertEquals(false, comple);
    }
}