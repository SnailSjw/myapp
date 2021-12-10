package com.concurrent.sleep;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 测试sleep方法
 *
 * @author : snail
 * @date : 2021-12-10 10:27
 **/
public class SleepDemo01Test {
    private static final ReentrantLock lock = new ReentrantLock();
    public static void main(String[] args) {
        Thread threadA = new Thread(new Runnable() {
            @Override
            public void run() {
                lock.lock();
                try {
                    System.out.println("threadA is sleep");
                    Thread.sleep(10000);
                    System.out.println("threadA is awaked");
                }catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    lock.unlock();
                }
            }
        });

        Thread threadB = new Thread(new Runnable() {
            @Override
            public void run() {
                lock.lock();
                try {
                    System.out.println("threadB is sleep");
                    Thread.sleep(10000);
                    System.out.println("thread is awaked");

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    lock.unlock();
                }
            }
        });
        threadA.start();
        threadB.start();
    }
}
