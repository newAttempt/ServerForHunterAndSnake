package com.nasoftware.dataSystem;

import com.nasoftware.roleSystem.Hunter;
import com.nasoftware.roleSystem.Snake;

import java.util.HashMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by zeyongshan on 7/17/17.
 */
public class RoomList {
    private HashMap<String, Room> roomMap;
    private int mapSize;
    private Lock lock;

    public RoomList()
    {
        roomMap = new HashMap<String, Room>();
        mapSize = 0;
        lock = new ReentrantLock(true);
    }

    public int addNewRoom()
    {
        lock.lock();
        Integer size = new Integer(mapSize);
        Room room = new Room(size.toString());
        roomMap.put(size.toString(), room);
        ++mapSize;
        lock.unlock();
        return size;
    }

    public Room getRoomFromID(String roomID)
    {
        lock.lock();
        if(roomMap.containsKey(roomID)) {
            final Room result =  roomMap.get(roomID);
            lock.unlock();
            return result;
        }
        lock.unlock();
        return null;
    }

    public boolean addHunterToRoom(String roomID, Hunter hunter)
    {
        lock.lock();
        if(!roomMap.containsKey(roomID))
        {
            lock.unlock();
            return false;
        }
        Room temp = roomMap.get(roomID);
        boolean result = false;
        if(temp.addHunter(hunter))
            result = true;
        lock.unlock();
        return result;
    }

    public boolean addSnakeToRoom(String roomID, Snake snake)
    {
        lock.lock();
        if(!roomMap.containsKey(roomID))
        {
            lock.unlock();
            return false;
        }
        Room temp = roomMap.get(roomID);
        boolean result = false;
        if(temp.addSnake(snake))
            result = true;
        lock.unlock();
        return result;
    }

    public HashMap<String, Room> getRoomMap()
    {
        lock.lock();
        final HashMap<String, Room> result = roomMap;
        lock.unlock();
        return result;
    }
}
