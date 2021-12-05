package com.snailjw.interf;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author : snail
 * @date : 2021-11-29 21:12
 **/
public class ClassB extends Thread {

    public static void main(String[] args) {
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap(10);
        HashMap<String,Object> map = new HashMap<>(10);
        Hashtable<String,Object> table = new Hashtable<>();

         Runnable runnable = new Runnable(){
            @Override
            public void run() {
                System.out.println("");
            }
        };
         runnable.run();

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println();
            }
        });
        thread.start();
    }
}
