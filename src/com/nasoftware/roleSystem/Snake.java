package com.nasoftware.roleSystem;

import com.nasoftware.mapSystem.Point;
import com.nasoftware.mapSystem.Vec;

/**
 * Created by zeyongshan on 7/14/17.
 */
public class Snake extends Point {
    private Vec direction;
    private int radio;
    final int DEF_RADIO = 0;
    String id;

    private void checkID(String id)
    {
        String[] temp = id.split("-");
        if(temp.length != 2)
        {
            System.err.print("wrong format of snake id!");
            System.exit(-1);
        }
        try {
            int number = Integer.parseInt(temp[0]);
        } catch (NumberFormatException e)
        {
            System.out.print("snake id should contains all integers!");
            System.exit(-1);
        }
    }

    public Snake(String id)
    {
        super(0, 0);
        checkID(id);
        direction = new Vec(0, 0);
        radio = DEF_RADIO;
        this.id = id;
    }

    public Snake(Point position, Vec direction, String id)
    {
        super(position.getX(), position.getY());
        checkID(id);
        this.direction = new Vec(direction.getX(), direction.getY());
        radio = DEF_RADIO;
        this.id = id;
    }

    public void setRadio(int radio)
    {
        this.radio = radio;
    }

    public int getRadio()
    {
        return radio;
    }

    public void setDirection(Vec dir)
    {
        direction = dir;
    }

    public Vec getDirection()
    {
        return direction;
    }

    public boolean equals(Object o)
    {
        Snake temp = (Snake) o;
        if(temp.id.equals(this.id))
            return true;
        return false;
    }

    public boolean matchRoomNo(String roomNo)
    {
        String[] temp = this.id.split("-");
        if(temp.length != 2)
            return false;
        if(!temp[0].equals(roomNo))
            return false;
        return true;
    }

    public String getId()
    {
        return id;
    }
}
