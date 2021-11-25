package com.snailjw.castle;

import java.util.HashMap;

/**
 * @author Administrator
 */
public class Room {
    private String description;
    private HashMap<String,Room> roomExitsMap = new HashMap<>();

    public Room(String description) 
    {
        this.description = description;
    }

    public void setExits(String exit){
        roomExitsMap.put(exit,this);
    }


    public String getExitsDesc(){
        StringBuilder sb = new StringBuilder();
        for (String s : this.roomExitsMap.keySet()) {
            sb.append(s+" ");
        }
        return sb.toString();
    }
    public Room getRoomExit(String direction){
        return this.roomExitsMap.get(direction);
    }

    /**
     * 內部类处理魔法值
     */
    public static final class Position {
        public static final String NORTH = "north";
        public static final String EAST = "east";
        public static final String SOUTH = "south";
        public static final String WEST = "west";
    }

    @Override
    public String toString()
    {
        return description;
    }
}
