package com.nasoftware.roleSystem;

import com.nasoftware.mapSystem.Point;
import com.nasoftware.mapSystem.Vec;
import com.sun.org.apache.xpath.internal.functions.WrongNumberArgsException;

import java.io.IOException;

/**
 * Created by zeyongshan on 7/13/17.
 */
public class Hunter extends Point {
    private Vec direction;
    private int level;
    private String id;
    private final int MAX_LEVEL = 6;
    private final int MIN_LEVEL = 1;

    private void checkID(String id)
    {
        String[] temp = id.split("-");
        if(temp.length != 2)
        {
            System.err.print("wrong format of hunter id!");
            System.exit(-1);
        }
        try {
            int number = Integer.parseInt(temp[0]);
        } catch (NumberFormatException e)
        {
            System.out.print("hunter id should contains all integers!");
            System.exit(-1);
        }
    }

    public Hunter(String id)
    {
        super(0, 0);
        checkID(id);
        direction = new Vec(0, 0);
        level = MIN_LEVEL;
        this.id = id;
    }

    public Hunter(Point position, String id)
    {
        super(position.getX(), position.getY());
        checkID(id);
        direction = new Vec(0, 0);
        level = MIN_LEVEL;
        this.id = id;
    }

    public Hunter(Point position, Vec direction, String id)
    {
        super(position.getX(), position.getY());
        checkID(id);
        this.direction = new Vec(direction.getX(), direction.getY());
        level = MIN_LEVEL;
        this.id = id;
    }

    public boolean addLevel()
    {
        if(level >= MAX_LEVEL)
            return false;
        level += 1;
        return true;
    }

    public boolean minLevel()
    {
        if(level <= MIN_LEVEL)
            return false;
        level -= 1;
        return true;
    }

    public Vec getDirection()
    {
        return direction;
    }

    public int getLevel()
    {
        return level;
    }

    public boolean equals(Object o)
    {
        Hunter hunter = (Hunter) o;
        if(hunter != null && this.id.equals(hunter.id))
            return true;
        return false;
    }

    public boolean matchRoomNo(String roomNo)
    {
        String[] temp = id.split("-");
        if(temp[0].equals(roomNo))
            return true;
        return false;
    }

    public String getId()
    {
        return id;
    }

    public String toString()
    {
        return "id: " + id + " " + super.toString() + " ";
    }

    public String getInfo()
    {
        return id + "-" + level + "-" + super.toString();
    }
}

