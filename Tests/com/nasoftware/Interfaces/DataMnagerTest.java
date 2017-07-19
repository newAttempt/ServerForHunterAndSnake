package com.nasoftware.Interfaces;

import org.junit.jupiter.api.Test;

import javax.xml.crypto.Data;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by zeyongshan on 7/19/17.
 */
class DataMnagerTest {

    @Test
    public void setNewRoleTest()
    {
        EventHandlerVoid startHandler = () -> {System.out.println("game start!");};
        String id = DataMnager.setNewRole(startHandler);
        assertEquals("0-10", id);
        for(int i=0; i<19; ++i)
            id = DataMnager.setNewRole(startHandler);
    }

    @Test
    public void getRoomRolesInfoTest()
    {
        setNewRoleTest();
        String info = DataMnager.getInfoOfCurrentRoom("0-10");
        System.out.println(info);
    }

    @Test
    public void updatePositionTest()
    {
        setNewRoleTest();
        DataMnager.updatePosition("0-15", 10, 20);
        String info = DataMnager.getInfoOfCurrentRoom("0-15");
        System.out.println(info);
    }
}