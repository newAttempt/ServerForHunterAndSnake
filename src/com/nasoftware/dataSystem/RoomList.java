package com.nasoftware.dataSystem;

import com.nasoftware.mapSystem.Point;
import com.nasoftware.roleSystem.Hunter;
import com.nasoftware.roleSystem.Snake;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by zeyongshan on 7/17/17.
 */
public class RoomList {
    private HashMap<String, Room> roomMap;
    private Lock lock;

    public RoomList()
    {
        roomMap = new HashMap<String, Room>();
        lock = new ReentrantLock(true);
    }

    public String addNewRoom()
    {
        lock.lock();
        Integer size = new Integer(roomMap.size());
        Room room = new Room(size.toString());
        roomMap.put(size.toString(), room);
        String result = Integer.toString(roomMap.size() -1);
        lock.unlock();
        return result;
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

    public String getUnstartedUnfullRoomKey()
    {
        lock.lock();
        Iterator it = roomMap.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry)it.next();
            String key = (String) pair.getKey();
            if(roomMap.containsKey(key) && !roomMap.get(key).getGameStatus()&& !roomMap.get(key).canStart())
            {
                lock.unlock();
                return key;
            }
        }
        lock.unlock();
        return null;
    }

    public String toString()
    {
        lock.lock();
        Iterator it = roomMap.entrySet().iterator();
        String result = "";
        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry)it.next();
            String key = (String) pair.getKey();
            result += roomMap.get(key).toString() + "\n";
        }
        lock.unlock();
        return result;
    }

}
