package com.snailjw.demo;

import java.io.File;

/**
 * 递归计算n!
 *
 * @author : snail
 * @date : 2021-11-18 11:17
 **/
public class Test03 {
    public static void main(String[] args) {
//        System.out.println(diGui(10));

        outFilePath(new File("D:\\user\\Videos\\Captures\\"));
    }

    /**
     * 递归计算n的阶乘
     *
     * @param n
     * @return
     */
    private static int diGui(int n){
        if (n == 1){
            return 1;
        }
        return n * diGui(n - 1);
    }


    /**
     * 输出某个文件目录
     *
     * @param file 输入文件或路径
     */
    private static void outFilePath(File file) {
        System.out.println(file);
        if (file.isDirectory()) {
            File[] files = file.listFiles();
            for (File currentFile : files) {
                outFilePath(currentFile);
            }
        }
    }
}
