package com.snailjw.castle;

/**
 * @author Administrator
 */
public class Room {
    private String description;
    private Room northExit;
    private Room southExit;
    private Room eastExit;
    private Room westExit;

    public Room(String description) 
    {
        this.description = description;
    }

    public void setExits(Room north, Room east, Room south, Room west) 
    {
        if(north != null) {
            northExit = north;
        }
        if(east != null) {
            eastExit = east;
        }
        if(south != null) {
            southExit = south;
        }
        if(west != null) {
            westExit = west;
        }
    }

    public String getExitsDesc(){
        StringBuilder sb = new StringBuilder();
        if(northExit != null) {
            sb.append("north ");
        }
        if(eastExit != null) {
            sb.append("east ");
        }
        if(southExit != null) {
            sb.append("south ");
        }
        if(westExit != null) {
            sb.append("west ");
        }
        return sb.toString();
    }
    public Room getRoomExit(String direction){
        Room room = null;
        if(InnerPosition.NORTH.equalsIgnoreCase(direction)) {
            room = northExit;
        }
        if(InnerPosition.EAST.equalsIgnoreCase(direction)) {
            room = eastExit;
        }
        if(InnerPosition.SOUTH.equalsIgnoreCase(direction)) {
            room = southExit;
        }
        if(InnerPosition.WEST.equalsIgnoreCase(direction)) {
            room = westExit;
        }
        return room;
    }

    /**
     * 內部类处理魔法值
     */
    public static final class InnerPosition{
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
