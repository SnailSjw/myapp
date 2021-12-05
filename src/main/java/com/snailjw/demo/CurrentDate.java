package com.snailjw.demo;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;

/**
 * 打印当前月的日历
 *
 * @author : snail
 * @date : 2021-12-03 18:08
 **/
public class CurrentDate {
    public static void main(String[] args) {
        LocalDate date = LocalDate.now();
        int month = date.getMonthValue();
        int today = date.getDayOfMonth();
        int dayOfWeek = date.getDayOfWeek().getValue();
        date = date.minusDays(today -1);







        System.out.println("Mon Tue Wed Thu Fri Sat Sun");
        for (int i = 0; i < dayOfWeek; i++) {
            System.out.print("     ");
        }
        while (date.getMonthValue() == month){
            System.out.printf("%3d",date.getDayOfMonth());

        }
        Class<CurrentDate> currentDateClass = CurrentDate.class;
        CurrentDate currentDate = new CurrentDate();
        Class<? extends CurrentDate> aClass = currentDate.getClass();
        try {
            Class<?> aClass1 = Class.forName("com.snailjw.demo.CurrentDate");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
