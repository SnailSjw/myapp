package com.snailjw.demo.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 混排
 * 要求：
 *  用1～49之间的49个Integer对象填充数组。然后，随机地打乱列表，并从打乱后的列表中选前6个值。最后再将选择的数值进行排序和打印。
 * @author : snail
 * @date : 2021-12-07 21:09
 **/
public class ShuffleTest {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(49);
        for (int i = 1; i <= 49; i++) {
            list.add(i);
        }
        Collections.shuffle(list);
        System.out.println("list = " + list);
//        取出子集
        List<Integer> sortList = list.subList(0,6);
//        再排序
        Collections.sort(sortList);
        System.out.println(sortList);

//        集合转数组
        Integer[] integers = sortList.toArray(new Integer[sortList.size()]);
        System.out.println("integers = " + Arrays.toString(integers));
    }
}
