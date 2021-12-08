package com.snailjw.demo.collection.map;

import com.snailjw.demo.Employee;

import java.util.HashMap;
import java.util.Map;

/**
 * Map测试
 *
 * @author : snail
 * @date : 2021-12-07 18:57
 **/
public class MapTest {
    public static void main(String[] args) {
        Map<String, Employee> map = new HashMap<>();
        map.put("1",new Employee("zhangsan",12D));
        map.put("2",new Employee("lisi",15D));
        map.put("3",new Employee("wangwu",14D));
        map.put("4",new Employee("zhaoliu",10D));
        map.put("5",new Employee("wangmazi",11D));
        System.out.println(map.getOrDefault("123",new Employee("test",10)));

        map.forEach((k,v)-> System.out.println("[ k = " + k + ",v = " + v+" ]"));
    }
}
