package com.concurrent.join;

/**
 * 测试join方法
 * 线程A调用线程B的join方法后会被阻塞，当其他线程调用线程A的interrupt方法中断A时，线程A会抛出java.lang.InterruptedException异常而返回。
 * @author : snail
 * @date : 2021-12-10 09:51
 **/
public class JoinDemo1Test {
    public static void main(String[] args) {
        Thread threadOne = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("执行threadOne线程！");
                for(;;){}
            }
        });
        final Thread mainThread = Thread.currentThread();
        Thread threadTwo = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                mainThread.interrupt();
            }
        });

        threadOne.start();
        threadTwo.start();
        try {
            threadOne.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
