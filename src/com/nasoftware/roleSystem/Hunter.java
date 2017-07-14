package com.nasoftware.roleSystem;

import com.nasoftware.mapSystem.Point;
import com.nasoftware.mapSystem.Vec;

/**
 * Created by zeyongshan on 7/13/17.
 */
public class Hunter extends Point {
    private Vec direction;
    private int level;
    final int MAX_LEVEL = 6;
    final int MIN_LEVEL = 1;

    public Hunter()
    {
        super(0, 0);
        direction = new Vec(0, 0);
        level = MIN_LEVEL;
    }

    public Hunter(Point position)
    {
        super(position.getX(), position.getY());
        direction = new Vec(0, 0);
        level = MIN_LEVEL;
    }

    public Hunter(Point position, Vec direction)
    {
        super(position.getX(), position.getY());
        this.direction = new Vec(direction.getX(), direction.getY());
        level = MIN_LEVEL;
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
}

