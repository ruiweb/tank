package com.zr;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class TankMain {
    public static void main(String[] args) throws InterruptedException {
        TankFrame tf =new TankFrame();
        //在主线程每隔50ms刷新窗口，调用repaint方法，ccc
        while (true){
            Thread.sleep(50);
            tf.repaint();
        }
    }




}
