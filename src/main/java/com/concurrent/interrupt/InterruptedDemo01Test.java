package com.concurrent.interrupt;

/**
 * 根据中断标志判断线程是否终止
 * @author : snail
 * @date : 2021-12-10 11:32
 **/
public class InterruptedDemo01Test {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (!Thread.currentThread().isInterrupted()){
                    System.out.println(Thread.currentThread() +" hello");
                }
            }
        });
        thread.start();
        System.out.println(thread.isInterrupted());
        Thread.sleep(1000);
        thread.interrupt();
        final boolean interrupted = thread.isInterrupted();
        System.out.println("interrupted = " + interrupted);
        thread.join();
        System.out.println("thread is over");
    }
}
