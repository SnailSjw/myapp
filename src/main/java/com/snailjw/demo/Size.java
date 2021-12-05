package com.snailjw.demo;

import java.util.Arrays;

public enum Size {
    SMALL("S"),MEDIUM("M"),LARGE("L"),EXTRA_LARGE("XL");
    private String value;

    Size(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static void main(String[] args) {
        Size[] values = Size.values();
        System.out.println(Arrays.toString(values));
//        返回具有指定名称的指定枚举类型的枚举常量
        Size small = Enum.valueOf(Size.class, "SMALL");
        System.out.println("small = " + small.toString());
//        ordinal()返回enum声明中枚举常量的位置，位置从0开始计数。
        int ordinal = small.ordinal();
        System.out.println("ordinal = " + ordinal);
        String name = small.name();
        System.out.println("name = " + name);
    }
}
