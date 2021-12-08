package com.snailjw.interf;

/**
 * @author : snail
 * @date : 2021-11-29 21:09
 **/
public interface InterfaceC extends InterfaceA {
    void printStr();
    default void defaultMethod(){
        System.out.println("dd");
    }
    void sleep(long millis);
}
