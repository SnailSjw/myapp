package com.snailjw.demo.thread;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.*;

/**
 * 线程池
 * @author : snail
 * @date : 2021-12-08 21:56
 **/
public class ThreadPoolTest {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Enter base directory (e.g. /opt/jdk1.8.0/src): ");
            String directory = scanner.nextLine();
            System.out.println("Enter keyword (e.g. volatile):");
            String keyword = scanner.nextLine();

            ExecutorService pool = Executors.newCachedThreadPool();
            MatchCounter counter = new MatchCounter(new File(directory),keyword,pool);
            Future<Integer> result = pool.submit(counter);

            try {
                System.out.println(result.get()+" matching files.");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
            pool.shutdown();
            int largestPoolSize = ((ThreadPoolExecutor)pool).getLargestPoolSize();
            System.out.println("largestPoolSize = " + largestPoolSize);
        }
    }
}

class MatchCounter implements Callable<Integer>{
    private File directory;
    private String keyword;
    private ExecutorService pool;
    private int count;

    public MatchCounter(File directory, String keyword, ExecutorService pool) {
        this.directory = directory;
        this.keyword = keyword;
        this.pool = pool;
    }


    @Override
    public Integer call(){
        count = 0;
        try {
            File[] files = directory.listFiles();
            List<Future<Integer>> results = new ArrayList<>();
            for (File file : files) {
                if (file.isDirectory()){
                    MatchCounter counter = new MatchCounter(file, keyword, pool);
                    Future<Integer> result = pool.submit(counter);
                    results.add(result);
                }else {
                    if (serach(file)) {
                        count++;
                    }
                }
            }
            for (Future<Integer> f : results) {
                try {
                    count += f.get();
                }catch (ExecutionException e){
                    e.printStackTrace();
                }
            }
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        return count;
    }

    public boolean serach(File file){
        try (Scanner in  = new Scanner(file,"UTF-8")){
            boolean found = false;
            while (in.hasNextLine()){
                String line = in.nextLine();
                if (line.contains(keyword)){
                    found = true;
                }
            }
            return found;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return false;
        }
    }
}
