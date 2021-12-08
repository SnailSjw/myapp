package com.snailjw.demo;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;

/**
 * 定时打印提醒
 *
 * @author : snail
 * @date : 2021-12-06 13:20
 **/
public class TimePrinter implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("At the tone ,this time is "+ LocalDate.now());
        /* *
         * getDefaultToolkit()
         *  获取默认的工具箱，工具箱包含有关GUI环境的信息。
         * public abstract void beep();
         *  发出一声铃响。
         */
        Toolkit.getDefaultToolkit().beep();
    }
}
