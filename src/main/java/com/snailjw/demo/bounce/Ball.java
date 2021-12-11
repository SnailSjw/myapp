package com.snailjw.demo.bounce;

import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;

/**
 * A ball that moves and bounces off the edges of a rectangle
 * 从矩形边缘移动并可以弹射的球
 *
 * @author : snail
 * @date : 2021-12-08 09:20
 **/
public class Ball {
    private static final int XSIZE = 15;
    private static final int YSIZE = 15;
    private double x = 0;
    private double y = 0;
    private double dx = 1;
    private double dy = 1;

    public void move(Rectangle2D bounds){
        x +=dx;
        y +=dy;
        if (x<bounds.getMinX()){
            x = bounds.getMinX();
            dx = -dx;
        }
        if (x+XSIZE >= bounds.getMaxX()){
            x = bounds.getMaxX() - XSIZE;
            dx = -dx;
        }
        if (y < bounds.getMinY()){
            y = bounds.getMinY();
            dy = -dy;
        }
        if (y +YSIZE >= bounds.getMaxY()){
            y = bounds.getMaxY() -YSIZE;
            dy = -dy;
        }
    }
    public Ellipse2D getShape(){
        return new Ellipse2D.Double(x,y,XSIZE,YSIZE);
    }
}


