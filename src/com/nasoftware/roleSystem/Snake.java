package com.nasoftware.roleSystem;

import com.nasoftware.mapSystem.Point;
import com.nasoftware.mapSystem.Vec;
import java.util.ArrayList;

/**
 * Created by zeyongshan on 7/6/17.
 */
public class Snake {
    private ArrayList<SnakeBodyBlock> body;

    public Snake(Point initHeadPosition)
    {
        body = new ArrayList<SnakeBodyBlock>(30);
        body.add(new SnakeBodyBlock(initHeadPosition));
    }

    public void move(Vec direction, double distance)
    {
        SnakeBodyBlock previousBlock = new SnakeBodyBlock(body.get(0));
        direction.movePoint(body.get(0), distance);
        for (int i = 1; i < body.size(); ++i)
        {
            SnakeBodyBlock current = new SnakeBodyBlock(body.get(i));
            body.get(i).copyFrom(previousBlock);
            previousBlock.copyFrom(current);
        }
    }

    public void grow(double distance)
    {
        SnakeBodyBlock newBlock;
        if(body.size() <= 1)
        {
            Vec vec = new Vec(0, 1);
            newBlock = new SnakeBodyBlock(vec.getMovedPoint(body.get(0), distance));
            body.add(newBlock);
            return;
        }
        Vec vec = body.get(body.size() -2).getDirection(body.get(body.size()-1));
        newBlock = new SnakeBodyBlock(vec.getMovedPoint(body.get(body.size() -1), distance));
        body.add(newBlock);
    }

    public String toString()
    {
        String sum = "";
        for(SnakeBodyBlock x : body)
        {
            sum += x.toString() + " ";
        }
        return sum;
    }
}


class SnakeBodyBlock extends Point
{
    public SnakeBodyBlock(Point init)
    {
        super(init);
    }
}
