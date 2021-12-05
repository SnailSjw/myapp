package com.snailjw.demo;

/**
 * @author : snail
 * @date : 2021-11-29 18:42
 **/
public class OutClass{
    public void print(int a){
        int b = 20;
        class InnerClass{
            public void printStr(){
                System.out.println("a = " + a);
                System.out.println("b = " + b);
            }
        }
        new InnerClass().printStr();
    }

    public static void main(String[] args) {
        OutClass outClass = new OutClass();
        outClass.print(10);
        StringBuffer sb = new StringBuffer();
    }
}