package com.zr;

import java.awt.*;

public class Tank {
    private int x,y ;
    private Direction dir ;
    private final int speed =10;
   private boolean isMoving =false;

    public boolean isMoving() {
        return isMoving;
    }

    public void setMoving(boolean moving) {
        isMoving = moving;
    }

    public Direction getDir() {
        return dir;
    }

    public void setDir(Direction dir) {
        this.dir = dir;
    }

    public Tank(int x, int y, Direction dir){
        this.x =x;
        this.y =y;
        this.dir =dir;
    }



    public void paint(Graphics g){
        //构造坦克大小
        g.fillRect(x,y,50,50);
        //坦克移动
        move();
    }

    public void move() {
        if(!isMoving) return;
        switch (dir){
            case up:
                y-=speed;
                break;
            case down:
                y+=speed;
                break;
            case left:
                x-=speed;
                break;
            case right:
                x+=speed;
                break;
        }
    }
}
