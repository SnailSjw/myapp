package com.snailjw.demo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;

/**
 * 内部类测试
 *
 * @author : snail
 * @date : 2021-12-06 16:14
 **/
public class InnerClassTest {
    public static void main(String[] args) {
        TalkingClock talkingClock = new TalkingClock(1000,true);
        talkingClock.start();
        JOptionPane.showMessageDialog(null,"Quit");
        System.exit(0);
    }
}


