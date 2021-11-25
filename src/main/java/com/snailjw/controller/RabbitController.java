package com.snailjw.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * 兔子数量问题
 *
 * @author : snail
 * @date : 2021-08-22 20:15
 **/
@RestController
public class RabbitController {

    /**
     * 获取兔子数量
     * @param n 初始兔子数目，成对出现
     */
    @GetMapping("/rabbit/{n}")
    public void rabbitNumber(@PathVariable("n") Integer n){
        int initRabbit = 2;
        for (int i=1;i<=20;i++){
            int num = getNum(i);
            System.out.println("第 " + i + " 月份，兔子的数量为： " + num);
        }
    }

    public static int getNum(int i){
        if((i==1)||(i==2)){
            return 1;
        }else{
            return getNum(i-1)+getNum(i-2);
        }
    }
}
