package com.cn.game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MyGame extends JFrame {
//初始化窗口
    public void launchFrame(){
        this.setTitle("Game");
        this.setVisible(true);
        this.setLocation(500,500);
        this.setSize(500,500);

        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e){
                System.exit(0);
            }
        });


    }
    public static void main(String[] args){
        MyGame f = new MyGame();
        f.launchFrame();

    }

    @Override
    public void paint(Graphics g) {
         
    }

    class PaintThread extends Thread{
        @Override
        public void run() {
            while (true){
                repaint();
                try {
                    Thread.sleep(40);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
