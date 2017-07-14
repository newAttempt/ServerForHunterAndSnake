package com.nasoftware.dataSystem;

import com.nasoftware.roleSystem.Hunter;
import com.nasoftware.roleSystem.Snake;

import java.util.ArrayList;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by zeyongshan on 7/14/17.
 */
public class Room {
    private ArrayList<Hunter> hunterList;
    private ArrayList<Snake> snakeList;
    private Lock lock;
    private final int MAX_SIZE = 8;
    private String id;

    public Room(String id) {
        hunterList = new ArrayList<Hunter>(10);
        snakeList = new ArrayList<Snake>(10);
        lock = new ReentrantLock(true);
        this.id = id;
    }

    public boolean addHunter(Hunter hunter) {
        if (hunterList.size() >= MAX_SIZE)
            return false;
        if(!hunter.matchRoomNo(id))
            return false;
        if(hunterList.contains(hunter))
            return false;
        Snake snake = new Snake(hunter.getId());
        if(snakeList.contains(snake))
            return false;
        lock.lock();
        hunterList.add(hunter);
        lock.unlock();
        return true;
    }

    public boolean addSnake(Snake snake) {
        if (snakeList.size() >= MAX_SIZE)
            return false;
        if(!snake.matchRoomNo(id))
            return false;
        if(snakeList.contains(snake))
            return false;
        Hunter hunter = new Hunter(snake.getId());
        if(hunterList.contains(hunter))
            return false;
        lock.lock();
        snakeList.add(snake);
        lock.unlock();
        return true;
    }

    public boolean canStart() {
        int snakeSize;
        int hunterSize;
        lock.lock();
        snakeSize = snakeList.size();
        hunterSize = hunterList.size();
        lock.unlock();
        if (snakeSize >= MAX_SIZE / 3 * 2 && hunterSize >= MAX_SIZE / 3 * 2) {
            return true;
        }
        return false;
    }

    public boolean bestToStart()
    {
        int snakeSize;
        int hunterSize;
        lock.lock();
        snakeSize = snakeList.size();
        hunterSize = hunterList.size();
        lock.unlock();
        if (snakeSize >= MAX_SIZE / 3 * 2 && hunterSize >= MAX_SIZE / 3 * 2 && snakeSize == hunterSize) {
            return true;
        }
        return false;
    }

    public int balanceFactor()
    {
        if(hunterList.size() > snakeList.size())
            return 1;
        else if(hunterList.size() == snakeList.size())
            return 0;
        else
            return -1;
    }

    public ArrayList<Hunter> getHunterList()
    {
        return hunterList;
    }

    public ArrayList<Snake> getSnakeList()
    {
        return snakeList;
    }

    public boolean equals(Object o)
    {
        Room room = (Room) o;
        if(room != null && room.id.equals(this.id))
            return true;
        return false;
    }
}
