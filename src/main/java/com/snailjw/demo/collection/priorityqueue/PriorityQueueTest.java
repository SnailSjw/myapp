package com.snailjw.demo.collection.priorityqueue;

import java.time.LocalDate;
import java.util.PriorityQueue;

/**
 * 测试优先级队列
 *
 * @author : snail
 * @date : 2021-12-07 18:42
 **/
public class PriorityQueueTest {
    public static void main(String[] args) {
        /**
         * 这里的迭代并不是按照元素的排列顺序访问的。
         * 而删除却总是删掉剩余元素中优先级数最小的那个元素
         */
        PriorityQueue<LocalDate> priorityQueue = new PriorityQueue<>();
        priorityQueue.add(LocalDate.of(1906,12,9));
        priorityQueue.add(LocalDate.of(1815,12,10));
        priorityQueue.add(LocalDate.of(1903,12,3));
        priorityQueue.add(LocalDate.of(1910,6,10));
        System.out.println("=====Iterating over elements======");
        for (LocalDate date : priorityQueue) {
            System.out.println(date);
        }
        System.out.println("Removing element");
        while (!priorityQueue.isEmpty()){
            System.out.println(priorityQueue.remove());
        }

    }
}
