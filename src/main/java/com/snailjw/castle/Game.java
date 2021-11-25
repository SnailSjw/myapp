package com.snailjw.castle;

import java.util.Scanner;

/**
 * @author Administrator
 */
public class Game {
    private Room currentRoom;
        
    public Game() 
    {
        createRooms();
    }

    private void createRooms()
    {
        Room outside, lobby, pub, study, bedroom;
      
        //	制造房间
        outside = new Room("城堡外");
        lobby = new Room("大堂");
        pub = new Room("小酒吧");
        study = new Room("书房");
        bedroom = new Room("卧室");
        
        //	初始化房间的出口
        outside.setExits(null, lobby, study, pub);
        lobby.setExits(null, null, null, outside);
        pub.setExits(null, outside, null, null);
        study.setExits(outside, bedroom, null, null);
        bedroom.setExits(null, null, null, study);

        //	从城堡门外开始
        currentRoom = outside;
    }

    private void printWelcome() {
        System.out.println();
        System.out.println("欢迎来到城堡！");
        System.out.println("这是一个超级无聊的游戏。");
        System.out.println("如果需要帮助，请输入 'help' 。");
        System.out.println();
        System.out.println("现在你在" + currentRoom);
        System.out.print("出口有：");
        System.out.println(currentRoom.getExitsDesc());
        System.out.println();
    }

    // 以下为用户命令

    private void printHelp() 
    {
        System.out.print("迷路了吗？你可以做的命令有：go bye help");
        System.out.println("如：\tgo east");
    }

    private void goRoom(String direction) 
    {
        Room nextRoom = currentRoom.getRoomExit(direction);

        if (nextRoom == null) {
            System.out.println("那里没有门！");
        }
        else {
            currentRoom = nextRoom;
            System.out.println("你在" + currentRoom);
            System.out.print("出口有: ");
            System.out.println(currentRoom.getExitsDesc());;
        }
    }


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
		Game game = new Game();
		game.printWelcome();

        while ( true ) {
        		String line = in.nextLine();
        		String[] words = line.split(" ");
        		if ( words[0].equalsIgnoreCase("help") ) {
        			game.printHelp();
        		} else if (words[0].equalsIgnoreCase("go") ) {
        			game.goRoom(words[1]);
        		} else if ( words[0].equalsIgnoreCase("bye") ) {
        			break;
        		} else {
                    System.out.println("输入有误，请查看帮助信息！");
                    game.printHelp();
                }
        }
        System.out.println("感谢您的光临。再见！");
        in.close();
	}

}
