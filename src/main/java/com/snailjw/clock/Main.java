package com.snailjw.clock;

/**
 * 有秒计时的数字时钟
 *
 * @author : snail
 * @date : 2021-11-24 13:41
 **/
public class Main {
    public static void main(String[] args) {

        java.util.Scanner in = new java.util.Scanner(System.in);

        Clock clock = new Clock(in.nextInt(), in.nextInt(), in.nextInt());

        clock.tick();

        System.out.println(clock);

        in.close();

    }
}

class Clock {

    private Display hourDisplay = new Display(24);
    private Display minuteDisplay = new Display(60);
    private Display secondDisplay = new Display(60);
    public Clock(int hour, int minute, int second){
        hourDisplay.setValue(hour);
        minuteDisplay.setValue(minute);
        secondDisplay.setValue(second);
    }
    public void tick(){
        secondDisplay.increase();
        if (secondDisplay.getValue() == 0) {
            minuteDisplay.increase();
            if (minuteDisplay.getValue() == 0) {
                hourDisplay.increase();
            }
        }
    }
    @Override
    public String toString(){
        return String.format("%02d:%02d:%02d", hourDisplay.getValue(), minuteDisplay.getValue(), secondDisplay.getValue());
    }
}

class Display{
    private int limit;

    private int value;

    public Display() {
    }

    public Display(int limit) {
        this.limit = limit;
    }

    public void increase(){
        value++;
        if (value == limit){
            value = 0;
        }
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

}