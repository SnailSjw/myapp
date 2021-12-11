package com.snailjw.demo.bounce;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * The component that draws the balls
 * 绘制球的组件
 *
 * @author : snail
 * @date : 2021-12-08 09:27
 **/
public class BallComponent extends JPanel {
    private static final int DEFAULT_WIDTH = 450;
    private static final int DEFAULT_HEIGHT = 350;

    private List<Ball> balls = new ArrayList<>();

    public void add(Ball ball){
        balls.add(ball);
    }

    @Override
    public void paintComponent(Graphics graphics){
        super.paintComponent(graphics);
        Graphics2D graphics2D = (Graphics2D) graphics;
        for (Ball ball: balls) {
            graphics2D.fill(ball.getShape());
        }
    }
    @Override
    public Dimension getPreferredSize(){
        return new Dimension(DEFAULT_WIDTH,DEFAULT_HEIGHT);
    }
}
