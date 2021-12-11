package com.snailjw.demo.future;

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

/**
 * @author : snail
 * @date : 2021-12-08 20:02
 **/
public class FutureTest {
    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)){
            System.out.println("Enter base directory (e.g. /opt/jdk1.8.0/src): ");
            String directory = in.nextLine();
            System.out.println("Enter keyword (e.g. volatile):");
            String keyword = in.nextLine();
            MatchCounter counter = new MatchCounter(new File(directory),keyword);
            FutureTask<Integer> task = new FutureTask<>(counter);
            new Thread(task).start();
            System.out.println(task.get()+" matching files.");
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class MatchCounter implements Callable<Integer>{

    private File directory;
    private String keyword;

    public MatchCounter(File directory, String keyword) {
        this.directory = directory;
        this.keyword = keyword;
    }
    

    @Override
    public Integer call(){
        int count = 0;
        try {
            File[] files = directory.listFiles();
            List<Future<Integer>> result = new ArrayList<>();
            for (File file : files) {
                if (file.isDirectory()){
                    MatchCounter counter = new MatchCounter(file,keyword);
                    FutureTask<Integer> task = new FutureTask<>(counter);
                    result.add(task);
                    new Thread(task).start();
                }else {
                    if (search(file)){
                        count++;
                    }
                }
            }
            for (Future<Integer> res : result) {
                try {
                    count += res.get();
                }catch (ExecutionException e){
                    e.printStackTrace();
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return count;
    }

    private boolean search(File file) {
        try (Scanner s = new Scanner(file,String.valueOf(StandardCharsets.UTF_8))){
            boolean found = false;
            while (!found && s.hasNextLine()){
                String line = s.nextLine();
                if (line.contains(keyword)){
                    System.out.println(file);
                    found = true;
                }
            }
            return found;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return false;
    }
}
