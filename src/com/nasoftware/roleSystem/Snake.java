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
    public Snake()
    {
        super(0, 0);
        direction = new Vec(0, 0);
        radio = DEF_RADIO;
    }

    public Snake(Point position, Vec direction)
    {
        super(position.getX(), position.getY());
        this.direction = new Vec(direction.getX(), direction.getY());
        radio = DEF_RADIO;
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

}
