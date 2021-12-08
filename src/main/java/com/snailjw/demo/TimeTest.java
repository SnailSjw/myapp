package com.snailjw.demo;

import javax.swing.*;
import java.awt.event.ActionListener;

/**
 * 测试定时打印类
 *
 * @author : snail
 * @date : 2021-12-06 13:23
 **/
public class TimeTest {
    public static void main(String[] args) {
        ActionListener listener = new TimePrinter();
//        构造一个定时器，每隔delay毫秒，通告listener一次
        Timer t = new Timer(10000,listener);
        t.start();
        /**
         * public static void showMessageDialog(Component parentComponent,
         *         Object message) throws HeadlessException {...}
         * 显示一个包含一条消息和OK按钮的对话框，这个对话框将位于其parent组件的中央，如果parent为null，对话框将显示在屏幕的中央。
         */
        JOptionPane.showMessageDialog(null,"Quit program?");
        System.exit(0);
    }

}
