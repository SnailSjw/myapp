package com.concurrent.join;

/**
 * 测试等待线程终止的方法
 *
 * @author : snail
 * @date : 2021-12-10 10:03
 **/
public class JoinDemo02Test {
    public static void main(String[] args) {
        Thread threadA = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("threadA is over");
            }
        });
        Thread threadB = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("threadB is over");
            }
        });
        threadA.start();
        threadB.start();

        System.out.println("wait all child thread over");
        try {
            threadA.join();
            threadB.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("all thread is over");
    }
}
