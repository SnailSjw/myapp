package com.snailjw.cells.cell;

import java.awt.Graphics;

/**
 * @author : snail
 * @date : 2021-11-25 20:26
 **/
public class Cell {
    private boolean alive = false;

    public void die() { alive = false; }
    public void reborn() { alive = true; }
    public boolean isAlive() { return alive; }

    public void draw(Graphics g, int x, int y, int size) {
        g.drawRect(x, y, size, size);
        if ( alive ) {
            g.fillRect(x, y, size, size);
        }
    }
}
