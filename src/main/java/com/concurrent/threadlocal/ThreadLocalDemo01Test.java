package com.concurrent.threadlocal;

/**
 * 测试ThreadLocal
 *
 * @author : snail
 * @date : 2021-12-10 15:28
 **/
public class ThreadLocalDemo01Test {
    static void print(){
        System.out.println(Thread.currentThread()+" ThreadLocal:"+ threadLocal.get());
        System.out.println(Thread.currentThread()+" ThreadLocal:"+ threadLocal.get());
        System.out.println(Thread.currentThread()+" ThreadLocal:"+ threadLocalSecond.get());
        threadLocal.remove();
        threadLocalSecond.remove();
    }
    static ThreadLocal<String> threadLocal = new ThreadLocal<>();
    static ThreadLocal<String> threadLocalSecond = new ThreadLocal<>();

    public static void main(String[] args) {
        Thread threadA = new Thread(new Runnable() {
            @Override
            public void run() {
                threadLocal.set("threadA value");
                threadLocal.set("threadA value22222");
                threadLocalSecond.set("threadA value second");
                print();
                System.out.println(" threadA remove after： "+threadLocal.get());
            }
        });
        Thread threadB = new Thread(new Runnable() {
            @Override
            public void run() {
                threadLocal.set("threadB value");
                threadLocalSecond.set("threadB value second");
                print();
                System.out.println(" threadB remove after： "+threadLocal.get());
            }
        });
        threadA.start();
        threadB.start();
    }
}
