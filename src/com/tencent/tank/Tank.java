package com.tencent.tank;

import javax.imageio.ImageIO;
import java.awt.*;

public class Tank {

    private int x,y;
    private Dir dir;
    private static final int SPEED = 10;

    private boolean moving = false;

    public static final int WIDTH = ResourceMgr.tankL.getWidth();
    public static final int HEIGHT = ResourceMgr.tankL.getHeight();

    TankFrame tf = null;

    public Tank(int x,int y,Dir dir,TankFrame tf){
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.tf = tf;
    }

    public boolean isMoving() {
        return moving;
    }

    public void setMoving(boolean moving) {
        this.moving = moving;
    }

    public Dir getDir() {
        return dir;
    }

    public void setDir(Dir dir) {
        this.dir = dir;
    }

    public void paint(Graphics g){
        switch (dir){
            case LEFT:
                g.drawImage(ResourceMgr.tankL,x,y,null);
                break;
            case UP:
                g.drawImage(ResourceMgr.tankU,x,y,null);
                break;
            case RIGHT:
                g.drawImage(ResourceMgr.tankR,x,y,null);
                break;
            case DOWN:
                g.drawImage(ResourceMgr.tankD,x,y,null);
                break;
        }

        move();
    }

    public void move(){
        if(!moving) return;

        switch(dir){
            case LEFT:
                x -= SPEED;
                break;
            case UP:
                y -= SPEED;
                break;
            case RIGHT:
                x += SPEED;
                break;
            case DOWN:
                y += SPEED;
                break;
            default:
                break;
        }
    }


    public void fire() {
        int bX = this.x + WIDTH/2 -Bullet.WIDTH/2;
        int bY = this.y + HEIGHT/2 - Bullet.HEIGHT/2;
        tf.bullets.add(new Bullet(bX,bY,this.dir,this.tf));
    }
}
