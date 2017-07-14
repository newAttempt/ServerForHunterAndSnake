package com.nasoftware.mapSystem;

/**
 * Created by zeyongshan on 7/6/17.
 */
public class Point {
   private double x;
   private double y;

   public Point(double x, double y)
   {
       this.x = x;
       this.y = y;
   }

   public Point(Point p)
   {
       x = p.x;
       y = p.y;
   }

   public void copyFrom(Point p)
   {
       x = p.x;
       y = p.y;
   }

   public Vec getDirection(Point p)
   {
       Vec vec = new Vec(p.x - x, p.y - y);
       return vec;
   }

   public String toString()
   {
       return x + "-" + y;
   }

   public double getDistance(Point p)
   {
        return Math.sqrt(Math.pow(Math.abs(x - p.x), 2) + Math.pow(Math.abs(y - p.y), 2));
   }

   public void addXY(double x, double y)
   {
       this.x += x;
       this.y += y;
   }

   public void add(Vec dir)
   {
       this.x += dir.getX();
       this.y += dir.getY();
   }

   public double getX()
   {
       return x;
   }

   public double getY()
   {
       return y;
   }
}
