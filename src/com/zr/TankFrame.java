package com.zr;

import org.omg.PortableServer.AdapterActivator;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class TankFrame extends Frame {
    int x =200;
    int y =200;
    Direction dir = Direction.down;
    final int speed =10;
    public  TankFrame(){
        setSize(800,600);
        setResizable(false);
        setTitle("tank war");
        setVisible(true);
        this.addKeyListener(new MyKeyListener());
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }

    @Override
    public void paint(Graphics g){
        g.fillRect(x,y,50,50);
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
        //x+=2;
        //y+=2;
    }

    //添加按键内部监听类
    class MyKeyListener extends KeyAdapter{
        boolean bl =false;
        boolean br =false;
        boolean bd =false;
        boolean bu =false;
        @Override
        public void keyPressed(KeyEvent e){
            System.out.println("key press");
            int keyCode = e.getKeyCode();
            switch (keyCode){
                case KeyEvent.VK_LEFT:
                    bl =true;
                    break;
                case KeyEvent.VK_UP:
                    bu = true;
                    break;
                case KeyEvent.VK_RIGHT:
                    br = true;
                    break;
                case KeyEvent.VK_DOWN:
                    bd = true;
                    break;
            }
            //repaint();
            setMainPoint();
        }
        @Override
        public void keyReleased(KeyEvent e){
            System.out.println("key released");
            int keyCode = e.getKeyCode();
            switch (keyCode){
                case KeyEvent.VK_LEFT:
                    bl =false;
                    break;
                case KeyEvent.VK_UP:
                    bu = false;
                    break;
                case KeyEvent.VK_RIGHT:
                    br = false;
                    break;
                case KeyEvent.VK_DOWN:
                    bd = false;
                    break;
            }
            setMainPoint();
        }

        private void setMainPoint() {
            if(bl) dir = Direction.left;
            if(bu) dir = Direction.up;
            if(br) dir = Direction.right;
            if(bd) dir = Direction.down;
        }
    }
}
