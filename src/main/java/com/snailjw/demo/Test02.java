package com.snailjw.demo;

import java.util.Random;

/**
 * 测试时间复杂度
 *
 * @author : snail
 * @date : 2021-11-17 16:26
 **/
public class Test02 {

    public static void main(String[] args) {
        int[] list = new int[99];
        Random random = new Random();
        for (int i = 0; i < 99; i++) {
            list[i] = random.nextInt(100) + 1;
        }

        int[] list2 = new int[101];
        System.out.println("==================");
        for (int i = 0; i <list.length; i++) {
            list2[list[i]] = list2[list[i]]+1;
        }
        System.out.println("====================");

        for (int i = 0; i < list2.length; i++) {
            if (list2[i] != 0){
                System.out.println(i+":"+list2[i]);
            }
        }
    }
}
