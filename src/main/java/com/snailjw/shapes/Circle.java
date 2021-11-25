package com.snailjw.shapes;


import java.awt.*;

/**
 * 圆
 *
 * @author : snail
 * @date : 2021-11-24 09:04
 **/
public class Circle extends Shape {
    private int x;
    private int y;
    private int radius;

    public Circle() {
    }

    public Circle(int x, int y, int radius) {
        this.x = x;
        this.y = y;
        this.radius = radius;
    }

    @Override
    public void draw(Graphics graphics) {
        graphics.drawOval(x,y,radius*2,radius*2);
    }
}
