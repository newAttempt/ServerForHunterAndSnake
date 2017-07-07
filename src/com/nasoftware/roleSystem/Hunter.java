package com.nasoftware.roleSystem;

import com.nasoftware.mapSystem.Point;

/**
 * Created by zeyongshan on 7/6/17.
 */

public class Hunter extends Point {
    private String id;

    public Hunter(String id, double x, double y)
    {
        super(x, y);
        this.id = id;
    }

    public String toString()
    {
        return id + "-" + super.toString();
    }
}
