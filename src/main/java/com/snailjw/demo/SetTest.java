package com.snailjw.demo;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

/**
 * Set集合测试
 *
 * @author : snail
 * @date : 2021-12-07 16:11
 **/
public class SetTest {
    public static void main(String[] args) {
        Set<String> words = new HashSet<>();
        long totalTime = 0;
        try (Scanner scanner = new Scanner(System.in)){
            while (!scanner.hasNext("#")){
                String word = scanner.next();
                long callTime = System.currentTimeMillis();
                words.add(word);
                callTime = System.currentTimeMillis() - callTime;
                totalTime+=callTime;
            }
        }
        Iterator<String> iterator = words.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
        System.out.println("...");
        System.out.println(words.size() + " distinct word; "+ totalTime +" milliseconds.");
    }
}
