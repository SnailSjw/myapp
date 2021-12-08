package com.snailjw.demo;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URI;
import java.nio.file.*;
import java.util.Iterator;

/**
 * 反射调用方法
 *
 * @author : snail
 * @date : 2021-12-05 23:43
 **/
public class MethodTableTest {
    public static double square(double d){
        return d * d;
    }

    /**
     * 打印方法入参出参的制表
     * @param from 起始值
     * @param to 结束值
     * @param n 需打印的数
     * @param method 执行的方法
     */
    public static void printTable(double from, double to, int n, Method method){
        System.out.println(method);
        double dx = (to - from) / (n -1);
        for (double x = from ;x<= to;x+=dx){
            try {
                double y = (double) method.invoke(null, x);
                System.out.printf("%10.4f | %10.4f%n",x,y);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        try {
            Method square = MethodTableTest.class.getMethod("square", double.class);
            Method sqrt = Math.class.getMethod("sqrt", double.class);
            printTable(1,10,10,square);
            printTable(1,10,10,sqrt);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }

    }
}
