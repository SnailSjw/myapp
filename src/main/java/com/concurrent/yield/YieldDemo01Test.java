package com.concurrent.yield;

/**
 * yield 测试
 * 当一个线程调用yield方法时，当前线程让出CPU使用权，然后处于就绪状态，线程调度器会从线程就绪队列中获取一个线程优先级最高的线程，
 * 也可能获取到刚刚让出CPU的线程。
 *
 * @author : snail
 * @date : 2021-12-10 10:58
 **/
public class YieldDemo01Test implements Runnable{
    YieldDemo01Test(){
        new Thread(this).start();
    }
    @Override
    public void run() {
        System.out.println(Thread.currentThread() +" start");
        for (int i = 0; i < 5; i++) {
            if (i % 5 ==0){
                System.out.println(Thread.currentThread() + " yield CPU");
                Thread.yield();
            }
        }
        System.out.println(Thread.currentThread() +" is over");
    }

    public static void main(String[] args) {
        new YieldDemo01Test();
        new YieldDemo01Test();
        new YieldDemo01Test();
    }
    /**
     * 其中一次执行结果：
     * Thread[Thread-2,5,main] start
     * Thread[Thread-2,5,main] yield CPU
     * Thread[Thread-1,5,main] start
     * Thread[Thread-0,5,main] start
     * Thread[Thread-0,5,main] yield CPU
     * Thread[Thread-0,5,main] is over
     * Thread[Thread-1,5,main] yield CPU
     * Thread[Thread-2,5,main] is over
     * Thread[Thread-1,5,main] is over
     */
}
