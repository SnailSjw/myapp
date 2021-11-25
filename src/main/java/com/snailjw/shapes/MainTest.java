package com.snailjw.shapes;

/**
 * 测试主类
 *
 * @author : snail
 * @date : 2021-11-24 09:18
 **/
public class MainTest {
    public static void main(String[] args) {
        Picture picture = new Picture(500,500);
        Circle c1 = new Circle(200,200,101);
        picture.add(c1);
        picture.draw();
    }
}
