package com.snailjw.demo;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.URL;

/**
 * 多线程学习，下载网络图片
 *
 * @author : snail
 * @date : 2021-11-12 11:38
 **/
public class TestThread1 extends Thread{
    private String url;
    private String name;

    public TestThread1() {
    }

    public TestThread1(String url, String name) {
        this.url = url;
        this.name = name;
    }
    @Override
    public void run() {
        WebDownloader.download(url,name);
    }

    public static void main(String[] args) {
        TestThread1 thread1 = new TestThread1("https://img-blog.csdnimg.cn/6b6b342b483346bb93abb0a6135c0fd9.png?x-oss-process=image/watermark,type_ZHJvaWRzYW5zZmFsbGJhY2s,shadow_50,text_Q1NETiBA6JyX54mb5bCP5Lyg,size_20,color_FFFFFF,t_70,g_se,x_16#pic_center","1.jpg");
        TestThread1 thread2 = new TestThread1("https://img-blog.csdnimg.cn/585b542c62984f18b3969513560239e4.png?x-oss-process=image/watermark,type_ZHJvaWRzYW5zZmFsbGJhY2s,shadow_50,text_Q1NETiBA6JyX54mb5bCP5Lyg,size_20,color_FFFFFF,t_70,g_se,x_16#pic_center","2.jpg");
        TestThread1 thread3 = new TestThread1("https://img-blog.csdnimg.cn/434c0f56f138486d801e730a658ab167.png?x-oss-process=image/watermark,type_ZHJvaWRzYW5zZmFsbGJhY2s,shadow_50,text_Q1NETiBA6JyX54mb5bCP5Lyg,size_20,color_FFFFFF,t_70,g_se,x_16#pic_center","3.jpg");
        thread1.start();
        thread2.start();
        thread3.start();
    }
}

class WebDownloader{

    public static void download(String url, String name){
        try {
            FileUtils.copyURLToFile(new URL(url),new File(name));
            System.out.println("下载文件完成：name = " + name);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("下载方法出现异常");
        }
    }
}
