package com.concurrent.sleep;

/**
 * 当处于sleep状态时，如果另一个线程中断了它（在其他线程中调用该线程的interrupt()方法），
 * 它会抛出异常(java.lang.InterruptedException: sleep interrupted)之后会返回。
 *
 *
 * @author : snail
 * @date : 2021-12-10 10:49
 **/
public class SleepDemo02Test {
    public static void main(String[] args) {
        Thread threadA = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println("threadA is sleep");
                    Thread.sleep(5000);
                    System.out.println("threadA is awaked");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        threadA.start();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        threadA.interrupt();
        try {
            threadA.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("threadA is over");
    }
}
