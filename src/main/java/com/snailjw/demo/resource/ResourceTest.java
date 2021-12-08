package com.snailjw.demo.resource;

import javax.swing.*;
import java.awt.*;
import java.io.InputStream;
import java.net.URL;
import java.util.Scanner;

/**
 * 演示资源加载
 * @author : snail
 * @date : 2021-12-08 07:52
 **/
public class ResourceTest {
    public static void main(String[] args) {
        EventQueue.invokeLater(() ->{
            JFrame frame = new ResourceTestFrame();
            frame.setTitle("ResourceTest");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }
}

class ResourceTestFrame extends JFrame{
    private static final int DEFAULT_WIDTH = 300;
    private static final int DEFAULT_HEIGHT = 300;

    public ResourceTestFrame(){
        setSize(DEFAULT_WIDTH,DEFAULT_HEIGHT);
        URL aboutURL = getClass().getResource("about.gif");
        Image img = new ImageIcon(aboutURL).getImage();
        setIconImage(img);

        JTextArea textArea = new JTextArea();
        InputStream stream =getClass().getResourceAsStream("com/snailjw/demo/resource/about.txt");
        try (Scanner scanner = new Scanner(stream,"UTF-8")){
            while (scanner.hasNext()){
                textArea.append(scanner.nextLine()+"\n");
            }
        }
        add(textArea);
    }
}