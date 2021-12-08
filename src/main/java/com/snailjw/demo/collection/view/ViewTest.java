package com.snailjw.demo.collection.view;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 视图测试
 *
 * @author : snail
 * @date : 2021-12-07 20:13
 **/
public class ViewTest {
    public static void main(String[] args) {
        List<String> strings = new ArrayList<>(Arrays.asList("a","b","c","d","e","f"));
        List<String> safeStrings = Collections.checkedList(strings,String.class);
        List list = safeStrings;
        list.add(LocalDate.now()); // check list ClassCastException
//        viewList();
    }

    private static void viewList(String[] strings) {

        List<String> list = Arrays.asList(strings);
        List<String> subList = list.subList(2, 5);
        System.out.println("subList = " + subList);
        System.out.println("list = " + list);
        subList.clear();
        System.out.println("=================");
        System.out.println("subList = " + subList);
        System.out.println("list = " + list);
    }
}
