package com.snailjw.demo;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 取随机数
 *
 * @author : snail
 * @date : 2021-12-03 17:05
 **/
public class LotteryDrawing {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("How many numbers do you need to draw?");
        int k = scanner.nextInt();
        System.out.println("What is the highest number you can draw?");
        int n = scanner.nextInt();
        int[] numbers = new int[n];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = i+1;
        }
        System.out.println("=========");
        System.out.println(Arrays.toString(numbers));
        System.out.println("=========");
        int[] result = new int[k];
        for (int i = 0; i < result.length; i++) {
            int r = (int) (Math.random() * n);
            result[i] = numbers[r];
            numbers[r] = numbers[n-1];
            n--;
        }
        Arrays.sort(result);
        System.out.println("Bet the following combination. It's make you rich!");
        for (int r :
                result) {
            System.out.println(r);
        }
    }
}
