package com.snailjw.demo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;

/**
 * 测试内部类
 *
 * @author : snail
 * @date : 2021-12-06 16:40
 **/
public class TalkingClock{
    private int interval;
    private boolean beep;

    public TalkingClock(int interval, boolean beep) {
        this.interval = interval;
        this.beep = beep;
    }

    public void start(){
//        ActionListener listener = new TimePrinter();
//        ActionListener listener = new TalkingClock.TimePrinter();
        ActionListener listener = this.new TimePrinter();
        Timer timer = new Timer(1000,listener);
        timer.start();
    }
    public class TimePrinter implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("At the tone,the time is "+ LocalDateTime.now());
//            if (TalkingClock.this.beep){
            if (beep){
                Toolkit.getDefaultToolkit().beep();
            }
        }
    }
}