package com.snailjw.demo;

/**
 * 面试题：为什么局部内部类或匿名内部类只能访问局部final变量
 *
 * @author : snail
 * @date : 2021-11-29 18:31
 **/
public class Test04 {
    public static void main(String[] args) {
        Test04 test04 = new Test04();
        test04.test(19);
    }

    public void test(int a){
        int b = 10;
        new Thread(){
            @Override
            public void run() {
                System.out.println("a = " + a);
                System.out.println("b = " + b);
            }
        }.start();
    }
}

