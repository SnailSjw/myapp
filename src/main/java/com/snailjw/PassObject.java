package com.snailjw;

/**
 * 测试题
 *
 * @author : snail
 * @date : 2021-11-26 14:43
 **/
class Letter {
    char c;
}
public class PassObject {
    static void f(Letter y) {
        y.c = 'z';
    }
    public static void main(String[] args) {
        String s1 = "Hello";
        String s2 = "Hello";
        String s3 = "Hellp".replace('p','o');
        System.out.println("s1 ==s2 = " + s1 == s2);
        System.out.println("s1 == s3 = " + s1 == s3);
    }

}