package com.snailjw.demo;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * 计算用户输入的数据的平均数
 *
 * @author : snail
 * @date : 2021-11-24 17:08
 **/
public class Main01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> inList = new ArrayList<>();
        while (scanner.hasNextInt()){
            inList.add(scanner.nextInt());
        }
        int sum = -1;
        for (int i : inList) {
            sum+=i;
        }
        double pjs = sum / inList.size();
        System.out.println("平均数是："+ pjs);
        for (int j : inList) {
            if (j > pjs) {
                System.out.println(j + " ,");
            }
        }

    }
}
