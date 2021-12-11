package com.snailjw.demo.blockingQueue;

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;
import java.util.Set;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 使用阻塞队列来控制一组线程。
 * 在一个目录及它的所有子目录下搜索所有文件，打印出包含指定关键字的行，
 *
 *  在这个程序中，不需要显示的线程同步，使用队列数据结构作为一种同步机制。
 * @author : snail
 * @date : 2021-12-08 17:07
 **/
public class BlockingQueueTest {
    private static final int FILE_QUEUE_SIZE = 10;
    private static final int SEARCH_THREADS = 100;
    private static final File DUMMY = new File("");
    private static BlockingQueue<File> queue = new ArrayBlockingQueue<>(FILE_QUEUE_SIZE);

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)){
            System.out.println("Enter base directory (e.g. /opt/jdk1.8.0/src): ");
            String directory = scanner.nextLine();
            System.out.println("Enter keyword (e.g. volatile):");
            String keyword = scanner.nextLine();

            Runnable enumerator = ()->{
                try {
                    enumerate(new File(directory));
                    queue.put(DUMMY); // 放置一个虚对象到队列中，相当于完成信号。
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            };
            new Thread(enumerator).start();
            for (int i = 1; i < SEARCH_THREADS; i++) {
                Runnable searcher = () -> {
                    try {
                        boolean done = false;
                        while (!done){
                            File file = queue.take();
                            if (file == DUMMY){
                                queue.put(file);
                                done = true;
                            }else {
                                serach(file,keyword);
                            }
                        }
                    } catch (InterruptedException | FileNotFoundException e) {
                        e.printStackTrace();
                    }
                };
                new Thread(searcher).start();
            }
        }
        Set<String> strings = ConcurrentHashMap.<String>newKeySet();
        strings.add("Java");
        strings.forEach(System.out::println);
    }

    /**
     * 递归枚举给定目录及其子目录中的所有文件添加到队列
     * @param directory 给定目录
     * @throws InterruptedException
     */
    public static void enumerate(File directory) throws InterruptedException {
        File[] files = directory.listFiles();
        for (File file : files) {
            if (file.isDirectory()) {
                enumerate(file);
            }else{
                queue.put(file);
            }
        }
    }

    /**
     * 文件汇总查找关键字，查找后输出
     * @param file
     * @param keyword
     * @throws FileNotFoundException
     */
    public static void serach(File file ,String keyword) throws FileNotFoundException {
        try (Scanner scanner = new Scanner(file, String.valueOf(StandardCharsets.UTF_8))){
            int lineNumber = 0;
            while (scanner.hasNextLine()){
                lineNumber++;
                String line = scanner.nextLine();
                if (line.contains(keyword)) {
                    System.out.printf("%s:%d:%s%n",file.getPath(),lineNumber,line);
                }
            }
        }
    }
}
