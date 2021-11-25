package com.snailjw.mileage;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 查找里程
 *
 * @author : snail
 * @date : 2021-11-24 15:19
 **/
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> list = new ArrayList<String>();
        while (true){
            String line = scanner.next();
            list.add(line);
            if (line.endsWith("###")) {
                break;
            }
        }
        int[][] distances = new int[list.size()-1][list.size()-1];
        for (int i = 0; i < list.size() - 1; i++) {
            for (int j = 0; j < list.size() - 1; j++) {
                distances[i][j] = scanner.nextInt();
            }
        }
        String city1 = scanner.next();
        String city2 = scanner.next();
        int distance = distances[list.indexOf(city1)][list.indexOf(city2)];
        System.out.println(distance);

    }

}
