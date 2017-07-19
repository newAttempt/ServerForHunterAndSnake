package com.nasoftware.dataSystem;

import com.nasoftware.Interfaces.EventHandlerVoid;
import com.nasoftware.roleSystem.Hunter;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

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
        EventHandlerVoid handlerVoid = () -> {System.out.println("game start!");};
        String id = roomsManager.assignNewRole(handlerVoid);
        assertEquals("0-10", id);
        id = roomsManager.assignNewRole(handlerVoid);
        assertEquals("0-00", id);
        id = roomsManager.assignNewRole(handlerVoid);
        assertEquals("0-11", id);
        id = roomsManager.assignNewRole(handlerVoid);
        assertEquals("0-01", id);
        id = roomsManager.assignNewRole(handlerVoid);
        assertEquals("0-12", id);
        id = roomsManager.assignNewRole(handlerVoid);
        assertEquals("0-02", id);
        id = roomsManager.assignNewRole(handlerVoid);
        assertEquals("0-13", id);
        id = roomsManager.assignNewRole(handlerVoid);
        assertEquals("0-03", id);
        id = roomsManager.assignNewRole(handlerVoid);
        assertEquals("0-14", id);
        id = roomsManager.assignNewRole(handlerVoid);
        assertEquals("0-04", id);
        id = roomsManager.assignNewRole(handlerVoid);
        assertEquals("0-15", id);
        id = roomsManager.assignNewRole(handlerVoid);
        assertEquals("0-05", id);
        id = roomsManager.assignNewRole(handlerVoid);
        assertEquals("0-16", id);
        id = roomsManager.assignNewRole(handlerVoid);
        assertEquals("0-06", id);
        id = roomsManager.assignNewRole(handlerVoid);
        assertEquals("0-17", id);
        id = roomsManager.assignNewRole(handlerVoid);
        assertEquals("0-07", id);
        id = roomsManager.assignNewRole(handlerVoid);
        assertEquals("0-18", id);
        id = roomsManager.assignNewRole(handlerVoid);
        assertEquals("0-08", id);
        id = roomsManager.assignNewRole(handlerVoid);
        assertEquals("0-19", id);
        id = roomsManager.assignNewRole(handlerVoid);
        assertEquals("0-09", id);
        id = roomsManager.assignNewRole(handlerVoid);
        assertEquals("1-10", id);
        id = roomsManager.assignNewRole(handlerVoid);
        assertEquals("1-00", id);
        id = roomsManager.assignNewRole(handlerVoid);
        assertEquals("1-11", id);
        id = roomsManager.assignNewRole(handlerVoid);
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

    @Test
    public void getRoomRolesInfoTest()
    {
        assignNewRoleTest();
        ArrayList<String> expectedArray = new ArrayList<String>();
        expectedArray.add("1");
        expectedArray.add("0-10-1-0.0-0.0");
        expectedArray.add("0-11-1-0.0-0.0");
        expectedArray.add("0-12-1-0.0-0.0");
        expectedArray.add("0-13-1-0.0-0.0");
        expectedArray.add("0-14-1-0.0-0.0");
        expectedArray.add("0-15-1-0.0-0.0");
        expectedArray.add("0-16-1-0.0-0.0");
        expectedArray.add("0-17-1-0.0-0.0");
        expectedArray.add("0-18-1-0.0-0.0");
        expectedArray.add("0-19-1-0.0-0.0");
        expectedArray.add("0-00-1-0.0-0.0");
        expectedArray.add("0-01-1-0.0-0.0");
        expectedArray.add("0-02-1-0.0-0.0");
        expectedArray.add("0-03-1-0.0-0.0");
        expectedArray.add("0-04-1-0.0-0.0");
        expectedArray.add("0-05-1-0.0-0.0");
        expectedArray.add("0-06-1-0.0-0.0");
        expectedArray.add("0-07-1-0.0-0.0");
        expectedArray.add("0-08-1-0.0-0.0");
        expectedArray.add("0-09-1-0.0-0.0");
        assertEquals(expectedArray, roomsManager.getRoomRolesInfo("0-00"));
        expectedArray = new ArrayList<String>();
        expectedArray.add("0");
        assertEquals(expectedArray, roomsManager.getRoomRolesInfo("1-00"));
    }

}


