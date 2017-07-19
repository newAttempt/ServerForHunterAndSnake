package com.nasoftware.dataSystem;

import com.nasoftware.roleSystem.Hunter;
import com.nasoftware.roleSystem.Snake;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by zeyongshan on 7/18/17.
 */
public class RoomsManager {
    private RoomList roomList;
    Lock lock;

    public RoomsManager(){
        roomList = new RoomList();
        lock = new ReentrantLock(true);
    }

    public String assignNewRole()
    {
        lock.lock();
        String key = roomList.getUnstartedUnfullRoomKey();
        if(key==null)
            key = roomList.addNewRoom();
        Room room = roomList.getRoomFromID(key);
        switch (room.balanceFactor())
        {
            case -1:case 0:
                Hunter hunter = new Hunter(room.getNewHunterID());
                room.addHunter(hunter);
                if(room.canStart())
                    room.startGame();
                lock.unlock();
                return hunter.getId();
            case 1:
                Snake snake = new Snake(room.getNewSnakeID());
                room.addSnake(snake);
                if(room.canStart())
                    room.startGame();
                lock.unlock();
                return snake.getId();
            default:
                System.err.println("unknow error!");
                lock.unlock();
                System.exit(-5);
        }
        lock.unlock();
        return null;
    }

    public boolean checkIfRoomGameStart(String id)
    {
        String[] temp = id.split("-");
        if(temp.length != 2)
            System.exit(-2);
        lock.lock();
        Room room = roomList.getRoomFromID(temp[0]);
        boolean result = false;
        if(room.getHunterFromID(id)!=null || room.getSnakeFromID(id)!=null)
            result = room.getGameStatus();
        lock.unlock();
        return result;
    }

    /* 1 : success
       0 : cannot find the role in this room
       -1: the game not start yet
     */
    public int updatePosition(String id, double x, double y)
    {
        String[] temp = id.split("-");
        if(temp.length != 2)
            System.exit(-2);
        String roomID       = temp[0];
        lock.lock();
        Room room = roomList.getRoomFromID(roomID);
        if(!room.getGameStatus())
            return -1;
        if(room.updatePosition(id, x, y))
            return 1;
        return 0;
    }

    /**
     * This function is only for unit test!
     * @return return the roomListDirectly;
     */
    public RoomList getRoomList()
    {
        return roomList;
    }
}
