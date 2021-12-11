package com.snailjw.demo;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Comparator;

/**
 * @author : snail
 * @date : 2021-12-08 19:33
 **/
public class ArraysTest {
    public static void main(String[] args) throws IOException {
        String contents = new String(
                Files.readAllBytes(
                        Paths.get("D:\\IdeaProjects\\myapp\\src\\main\\java\\com\\snailjw\\OverClass.java")
                ), StandardCharsets.UTF_8);
        String[] words = contents.split(" ");
//        Arrays.parallelSort(words);
        Arrays.parallelSort(words, Comparator.comparing(String::length));
        System.out.println("words = " + Arrays.toString(words));
    }

}
