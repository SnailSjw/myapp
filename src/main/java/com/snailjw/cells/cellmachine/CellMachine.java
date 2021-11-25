package com.snailjw.cells.cellmachine;

import com.snailjw.cells.cell.Cell;
import com.snailjw.cells.field.Field;
import com.snailjw.cells.field.View;

import javax.swing.JFrame;


/**
 * 细胞自动机程序
 * @author : snail
 * @date : 2021-11-25 20:27
 **/
public class CellMachine {

    public static void main(String[] args) {
        Field field = new Field(30,30);
        for ( int row = 0; row<field.getHeight(); row++ ) {
            for ( int col = 0; col<field.getWidth(); col++ ) {
                field.place(row, col, new Cell());
            }
        }
        for ( int row = 0; row<field.getHeight(); row++ ) {
            for ( int col = 0; col<field.getWidth(); col++ ) {
                Cell cell = field.get(row, col);
                if ( Math.random() < 0.2 ) {
                    cell.reborn();
                }
            }
        }
        JFrame frame = new JFrame();
        setView(field,frame);

        for ( int i=0; i<1000; i++ ) {
            for ( int row = 0; row<field.getHeight(); row++ ) {
                for ( int col = 0; col<field.getWidth(); col++ ) {
                    Cell cell = field.get(row, col);
                    Cell[] neighbour = field.getNeighbour(row, col);
                    int numOfLive = 0;
                    for ( Cell c : neighbour ) {
                        if ( c.isAlive() ) {
                            numOfLive++;
                        }
                    }
                    System.out.print("["+row+"]["+col+"]:");
                    System.out.print(cell.isAlive()?"live":"dead");
                    System.out.print(":"+numOfLive+"-->");
                    if ( cell.isAlive() ) {
                        if ( numOfLive <2 || numOfLive >3 ) {
                            cell.die();
                            System.out.print("die");
                        }
                    } else if ( numOfLive == 3 ) {
                        cell.reborn();
                        System.out.print("reborn");
                    }
                    System.out.println();
                }
            }
            System.out.println("UPDATE");
            frame.repaint();
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void setView(Field field,JFrame frame) {
        View view = new View(field);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setTitle("Cells");
        frame.add(view);
        frame.pack();
        frame.setVisible(true);
    }

}
