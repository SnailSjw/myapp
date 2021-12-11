package com.concurrent.interrupt;

/**
 * 当线程调用了wait/sleep/join方法时会阻塞挂起当前线程，此时再调用interrupted方法，则会抛出异常InterruptedException并返回。
 * @author : snail
 * @date : 2021-12-10 11:47
 **/
public class InterruptedDemo02Test {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {

                try {
                    System.out.println("thread is start and sleep 200000");
                    Thread.sleep(200000);
                    System.out.println("thread is awaked");
                } catch (InterruptedException e) {
                    System.out.println("thread is interrupted while sleeping");
                    System.out.println("catch "+Thread.currentThread().isInterrupted());
                    e.printStackTrace();
                    return;
                }
            }
        });
        thread.start();
        Thread.sleep(1000);
        thread.interrupt();
        System.out.println("join before "+thread.isInterrupted());
        thread.join();
        System.out.println("join after "+thread.isInterrupted());
    }
}
