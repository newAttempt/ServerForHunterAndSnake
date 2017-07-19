package com.nasoftware.Interfaces;

import com.nasoftware.dataSystem.Room;
import com.nasoftware.dataSystem.RoomsManager;
import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

import java.util.ArrayList;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


/**
 * Created by zeyongshan on 7/17/17.
 */
public class DataMnager {

    static private Lock lock = new ReentrantLock(true);
    static private RoomsManager roomsManager = new RoomsManager();

    static public String setNewRole(EventHandlerVoid gameStartHandler)
    {
        lock.lock();
        String roleID = roomsManager.assignNewRole(gameStartHandler);
        lock.unlock();
        return roleID;
    }
    /* 1 : success
           0 : cannot find the role in this room
           -1: the game not start yet
         */
    static public int updatePosition(String id, double x, double y)
    {
        lock.lock();
        int result = roomsManager.updatePosition(id, x, y);
        lock.unlock();
        return result;
    }

    static public String getInfoOfCurrentRoom(String id)
    {
        lock.lock();
        ArrayList<String> info = roomsManager.getRoomRolesInfo(id);
        lock.unlock();
        if(info.get(0).equals("0"))
            return null;
        String result = "";
        for (int i = 1; i<info.size() -1; ++i)
            result += info.get(i) + " ";
        result += info.get(info.size() -1);
        return result;
    }

}


