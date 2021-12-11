package com.concurrent.interrupt;

/**
 * interrupted()和isInterrupted()方法的区别
 *  interrupted()是针对于当前线程来说，与哪个线程调用它无关。
 *  isInterrupted()是针对调用此方法的线程来说的。
 *
 * @author : snail
 * @date : 2021-12-10 13:58
 **/
public class InterruptedDemo03Test {
    public static void main(String[] args) throws InterruptedException {
        interruptedTest01();
//        interruptedTest02();

    }

    /**
     * 在thread内调用Thread.interrupted()，中断标志被清除
     * @throws InterruptedException
     */
    private static void interruptedTest02() throws InterruptedException {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (!Thread.interrupted()){
                    System.out.println("thread running...");
                }
                System.out.println(Thread.currentThread()+" Thread.currentThread().isInterrupted() = " + Thread.currentThread().isInterrupted());
            }
        });
        thread.start();

        thread.interrupt();

        thread.join();
        System.out.println("main thread is over");
    }

    /**
     * 在主线程调用thread.interrupted()/Thread.interrupted()都是针对的当前线程（主线程），与thread无关
     * @throws InterruptedException
     */
    private static void interruptedTest01() throws InterruptedException {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                for (;;){}
            }
        });

        thread.start();
        thread.interrupt();
//        获取线程中断标志
        System.out.println("thread.isInterrupted() = " + thread.isInterrupted());
        System.out.println("thread.interrupted() = " + thread.interrupted());
        System.out.println("Thread.interrupted() = " + Thread.interrupted());
        System.out.println(Thread.currentThread()+" Thread.currentThread().isInterrupted() = " + Thread.currentThread().isInterrupted());
        System.out.println("thread.isInterrupted() = " + thread.isInterrupted());

        thread.join();
        System.out.println("main thread is over");
    }
}
