package com.concurrent.sleep;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 测试sleep方法
 * sleep方法执行后，线程会暂时让出指定时间的执行权（即：在指定时间内不参与CPU调度的竞争），但是不会让出它所拥有的监视器资源（比如：锁），
 * 时间到了后，线程会处于就绪状态，继续参与CPU的调度获取到CPU资源就继续执行。
 *
 * @author : snail
 * @date : 2021-12-10 10:27
 **/
public class SleepDemo01Test {
    /**
     * 创建独占锁
     */
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
