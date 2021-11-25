package com.snailjw.shapes;

import java.util.Scanner;


/**
 * 第一周练习
 *
 * @author : snail
 * @date : 2021-11-24 10:03
 **/
public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Fraction a = new Fraction(in.nextInt(), in.nextInt());
        Fraction b = new Fraction(in.nextInt(),in.nextInt());
        a.print();
        b.print();
        a.plus(b).print();
        a.multiply(b).plus(new Fraction(5,6)).print();
        a.print();
        b.print();
        in.close();
    }

}

/**
 Fraction(int a, int b)
 构造一个a/b的分数。
 这个类要提供以下的功能：
 double toDouble();
 将分数转换为double
 Fraction plus(Fraction r);
 将自己的分数和r的分数相加，产生一个新的Fraction的对象。注意小学四年级学过两个分数如何相加的哈。
 Fraction multiply(Fraction r);
 将自己的分数和r的分数相乘，产生一个新的Fraction的对象。
 void print();
 将自己以“分子/分母”的形式输出到标准输出，并带有回车换行。如果分数是1/1，应该输出1。当分子大于分母时，不需要提出整数部分，即31/30是一个正确的输出。
 */
class Fraction {
    private int a;
    private int b;
    Fraction (int a,int b){
        this.a = a;
        this.b = b;
    }

    public int getA() {
        return a;
    }
    public int getB() {
        return b;
    }

    /**
     * 将分数转为double类型
     * @param fraction 分数
     * @return double类型
     */
    double toDouble(Fraction fraction){
        double result = 0;
        int a = fraction.getA();
        int b = fraction.getB();
        if (b == 0){
            System.out.println("分母不能为零！");
            return result;
        }
        result = a / b;
        return result;
    }

    /**
     * 分数相加
     * @param r 被加分数
     * @return 两分数之和
     */
    Fraction plus(Fraction r){
        int a = this.getA();
        int b = this.getB();
        int a1 = r.getA();
        int b1 = r.getB();


        int resultA = a * b1 + b * a1;
        int resultB = b * b1;
        int i = maxCommonDivisor(resultA, resultB);
        return new Fraction(resultA / i,resultB / i);
    }

    /**
     * 两分数相乘
     * @param r 被乘分数
     * @return 分数的乘积
     */
    Fraction multiply(Fraction r){
        int a = this.getA();
        int b = this.getB();
        int a1 = r.getA();
        int b1 = r.getB();
        int resultA = a * a1;
        int resultB  = b * b1;
        int i = maxCommonDivisor(resultA, resultB);
        return new Fraction(resultA / i ,resultB /i);
    }

    /**
     * 以分数形式打印
     */
    void print(){
        int a = this.getA();
        int b = this.getB();
        if (a == b){
            System.out.println("1");
            return;
        }
        int i = maxCommonDivisor(a, b);
        System.out.println((a/i)+"/"+(b/i));
    }


    /**
     * 求最小公倍数
     * @param a
     * @param b
     * @return
     */
    private static int gcd(int a, int b) {
        int m = a * b;
        int t;
        while (b != 0) {
            t = b;
            b = a % b;
            a = t;
        }
        return m/a;
    }

    /**
     * 求最大公约数
     * @param m
     * @param n
     * @return
     */
    public static int maxCommonDivisor(int m, int n) {
        // 保证被除数大于除数
        if (m < n) {
            int temp = m;
            m = n;
            n = temp;
        }
        // 在余数不能为0时,进行循环
        while (m % n != 0) {
            int temp = m % n;
            m = n;
            n = temp;
        }
        return n;

    }

    public static void main(String[] args) {
        System.out.println(gcd(38, 24));
        System.out.println(gcd(2, 4));
        System.out.println(maxCommonDivisor(38, 24));
        System.out.println(maxCommonDivisor(2, 2));
    }
}