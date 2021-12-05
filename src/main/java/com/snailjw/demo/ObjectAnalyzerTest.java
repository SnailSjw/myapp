package com.snailjw.demo;

import java.util.ArrayList;

/**
 * 编写一个可供任意类使用的通用toString方法
 *
 * @author : snail
 * @date : 2021-12-04 21:20
 **/
public class ObjectAnalyzerTest {
    public static void main(String[] args) {
        ArrayList<Integer> squares = new ArrayList<>();
        for (int i = 1; i <= 5; i++) {
            squares.add(i * i);
        }
        System.out.println(new ObjectAnalyzer().toString(squares));
        Employee employee = new Employee("zhangsan",23000);
        System.out.println(new ObjectAnalyzer().toString(employee));
    }
}
