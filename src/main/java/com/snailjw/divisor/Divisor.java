package com.snailjw.divisor;

/**
 * 最大公约数计算
 *
 * @author : snail
 * @date : 2021-11-24 16:37
 **/
public class Divisor {

    /**
     * 枚举计算两数最大公约数
     * @param a
     * @param b
     * @return
     */
    public static int maxDivisor(int a, int b){
        int r = 1;
        for (int i = 1; i <= a && i<= b; i++) {
            if (a % i == 0 && b % i == 0){
                r=i;
            }
        }
        return r;
    }

    /**
     * 辗转相除法
     * 步骤：
     *  1.如果b=0，计算结束，a就是最大公约数
     *  2.否则，计算 (a % b),让a=b；b=余数
     *  3.继续第一步。
     * @param a
     * @param b
     * @return
     */
    public static int maxDivisor2(int a,int b){
        if (a == b){
            return a;
        }
        while (b != 0){
            int r = a % b;
            a = b;
            b = r;
        }
        return a;
    }

    public static void main(String[] args) {
//        int i = maxDivisor(12, 18);
//        int i = maxDivisor(13, 13);
        int i = maxDivisor2(12, 15);
        System.out.println("i = " + i);


    }
}
