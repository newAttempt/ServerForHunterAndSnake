package com.nasoftware.dataSystem;

import com.nasoftware.roleSystem.Hunter;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by zeyongshan on 7/18/17.
 */
class RoomsManagerTest {
    private RoomsManager roomsManager;

    RoomsManagerTest()
    {
        roomsManager = new RoomsManager();
    }

    @Test
    public void assignNewRoleTest()
    {
        //0 for snake
        //1 for hunter
        String id = roomsManager.assignNewRole();
        assertEquals("0-10", id);
        id = roomsManager.assignNewRole();
        assertEquals("0-00", id);
        id = roomsManager.assignNewRole();
        assertEquals("0-11", id);
        id = roomsManager.assignNewRole();
        assertEquals("0-01", id);
        id = roomsManager.assignNewRole();
        assertEquals("0-12", id);
        id = roomsManager.assignNewRole();
        assertEquals("0-02", id);
        id = roomsManager.assignNewRole();
        assertEquals("0-13", id);
        id = roomsManager.assignNewRole();
        assertEquals("0-03", id);
        id = roomsManager.assignNewRole();
        assertEquals("0-14", id);
        id = roomsManager.assignNewRole();
        assertEquals("0-04", id);
        id = roomsManager.assignNewRole();
        assertEquals("0-15", id);
        id = roomsManager.assignNewRole();
        assertEquals("0-05", id);
        id = roomsManager.assignNewRole();
        assertEquals("0-16", id);
        id = roomsManager.assignNewRole();
        assertEquals("0-06", id);
        id = roomsManager.assignNewRole();
        assertEquals("0-17", id);
        id = roomsManager.assignNewRole();
        assertEquals("0-07", id);
        id = roomsManager.assignNewRole();
        assertEquals("0-18", id);
        id = roomsManager.assignNewRole();
        assertEquals("0-08", id);
        id = roomsManager.assignNewRole();
        assertEquals("0-19", id);
        id = roomsManager.assignNewRole();
        assertEquals("0-09", id);
        id = roomsManager.assignNewRole();
        assertEquals("1-10", id);
        id = roomsManager.assignNewRole();
        assertEquals("1-00", id);
        id = roomsManager.assignNewRole();
        assertEquals("1-11", id);
        id = roomsManager.assignNewRole();
        assertEquals("1-01", id);
    }

    @Test
    public void testRoomStartStatus()
    {
        assignNewRoleTest();
        Hunter hunter = new Hunter("0-07");
        boolean result = roomsManager.checkIfRoomGameStart(hunter.getId());
        assertEquals(true, result);
        hunter = new Hunter("1-01");
        result = roomsManager.checkIfRoomGameStart(hunter.getId());
        assertEquals(false, result);
        hunter = new Hunter("1-07");
        result = roomsManager.checkIfRoomGameStart(hunter.getId());
        assertEquals(false, result);
    }

    @Test
    public void updatePositionTest()
    {
        assignNewRoleTest();
        Hunter hunter = new Hunter("0-07");
        int result = roomsManager.updatePosition(hunter.getId(), 10, 10);
        assertEquals(1, result);
        hunter = new Hunter("0-0111");
        result = roomsManager.updatePosition(hunter.getId(), 10, 10);
        assertEquals(0, result);
        hunter = new Hunter("1-01");
        result = roomsManager.updatePosition(hunter.getId(), 10, 10);
        assertEquals(-1, result);
    }
}


