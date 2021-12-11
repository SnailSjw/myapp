package com.concurrent.deadlock;

/**
 * 死锁测试：
 * 死锁的条件：
 *  1.互斥条件
 *  2.请求并持有条件
 *  3.不可剥夺条件
 *  4.环路等待条件
 * @author : snail
 * @date : 2021-12-10 14:46
 **/
public class DeadLockDemo01Test {
    private static final Object resourceA = new Object();
    private static final Object resourceB = new Object();

    public static void main(String[] args) {
        Thread threadA = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (resourceA){
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread()+" threadA has resourceA,wait resourceB");
                    synchronized (resourceB){
                        System.out.println(Thread.currentThread()+" threadA wait resourceB ...");
                    }
                }
            }
        });
        Thread threadB = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (resourceB){
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread()+" threadB has resourceB, wait resourceA");
                    synchronized (resourceA){
                        System.out.println(Thread.currentThread()+" threadB wait resourceA ...");
                    }
                }
            }
        });

        threadA.start();
        threadB.start();

    }
}
