package com.snailjw.demo;

import javax.swing.*;
import java.awt.*;
import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;
import java.util.Arrays;
import java.util.function.Predicate;

/**
 * 测试lambda表达式
 *
 * @author : snail
 * @date : 2021-12-06 14:18
 **/
public class LambdaTest {
    public static void main(String[] args) {
        String[] plants = {"The","greatest","test","of","courage","on","earth","is","to","bear","defeat","without","losing","heart"};
        System.out.println(Arrays.toString(plants));
        System.out.println("Sorted in dictionary order");
        Arrays.sort(plants);
        System.out.println(Arrays.toString(plants));
        System.out.println("Sorted by length");
        Arrays.sort(plants,(first,second) ->{
            return first.length() - second.length();
        });
        //上面代码与下面的代码等效
        Arrays.sort(plants, Comparator.comparingInt(String::length));
        System.out.println(Arrays.toString(plants));

        List<String> names = Arrays.asList("Java", "Scala", "C++", "Haskell", "Lisp","Hell","opt");
        names.stream()
                .filter(s -> s.length()>4 ? true : false)
                .forEach((n) -> System.out.println("this is:"+ n));


//        调用repeat方法
        repeat(10,()-> System.out.println("Hello Lambda"));
        repeat(10,i-> System.out.println("CountDown:"+(i)));

        Timer timer = new Timer(1000,listener -> {
            System.out.println("The time is "+ LocalDateTime.now());
            Toolkit.getDefaultToolkit().beep();
        });

        timer.start();
        JOptionPane.showMessageDialog(null,"Quit program?");
        System.exit(0);
    }

    public static void repeat(int n ,Runnable action){
        for (int i = 0; i < n; i++) {
            action.run();
        }
    }
    public static void repeat(int n,IntConsumer action){
        for (int i = 0; i < n; i++) {
            action.accept(i);
        }
    }

}
interface IntConsumer{
    void accept(int value);
}
