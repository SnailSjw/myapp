package com.snailjw.demo;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Scanner;

/**
 * 计算用户输入的数据的平均数
 *
 * @author : snail
 * @date : 2021-11-24 17:08
 **/
public class Main01 {
    public static void main(String[] args) {
        //测试集合容器的删除


        ArrayList<Integer> list = new ArrayList<>(10);
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }
        //1.for循环删除
//        forDeleteList(list);

//        2.迭代器删除
//        iteratorDeleteListEle(list);

//        3.forEach删除
        for (Integer value : list) {
            if (value == 4){
                list.remove(4);
            }
        }

        System.out.println(list.size());
        System.out.println(Arrays.toString(list.toArray()));
//        Scanner scanner = new Scanner(System.in);
//        ArrayList<Integer> inList = new ArrayList<>();
//        while (scanner.hasNextInt()){
//            inList.add(scanner.nextInt());
//        }
//        int sum = -1;
//        for (int i : inList) {
//            sum+=i;
//        }
//        double pjs = sum / inList.size();
//        System.out.println("平均数是："+ pjs);
//        for (int j : inList) {
//            if (j > pjs) {
//                System.out.println(j + " ,");
//            }
//        }

        /*int x = 10;
        int test = test(x);
        System.out.println("test = " + test);
        System.out.println("x = " + x);*/
        double negativeInfinity = Double.NEGATIVE_INFINITY;

    }

    private static void iteratorDeleteListEle(ArrayList<Integer> list) {
        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()){
            Integer next = iterator.next();
            if (next == 4){
                iterator.remove();
            }
        }
    }

    private static void forDeleteList(ArrayList<Integer> list) {
        for (int i = 0; i < list.size(); i++) {
            if (i == 3){
                list.remove(i);
            }
            System.out.println(list.get(i));
        }

    }

    public static int test(int x){
        x = x*3;
        return x;
    }
}
