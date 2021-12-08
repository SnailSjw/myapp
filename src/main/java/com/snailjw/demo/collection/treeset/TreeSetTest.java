package com.snailjw.demo.collection.treeset;

import java.util.Comparator;
import java.util.NavigableSet;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * 树集测试
 *
 * @author : snail
 * @date : 2021-12-07 16:48
 **/
public class TreeSetTest {
    public static void main(String[] args) {
        SortedSet<Item> items = new TreeSet<>();
        items.add(new Item("Maxine",1234));
        items.add(new Item("Tim",45678));
        items.add(new Item("Harry",7894));
//        通过默认的排序方式排序
        System.out.println(items);

//        通过比较器来排序
        NavigableSet<Item> sortByDesc = new TreeSet<>(Comparator.comparing(Item::getDescription));
        sortByDesc.addAll(items);
        System.out.println(sortByDesc);
    }
}
