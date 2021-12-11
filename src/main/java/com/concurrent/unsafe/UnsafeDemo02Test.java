package com.concurrent.unsafe;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * 反射获取Unsafe类并使用
 *
 * @author : snail
 * @date : 2021-12-10 20:54
 **/
public class UnsafeDemo02Test {
    static final Unsafe unsafe ;
    static final long stateOffset;
    private volatile long state = 0;

    static{
        try {
            final Field field = Unsafe.class.getDeclaredField("theUnsafe");
            field.setAccessible(true);
            unsafe = (Unsafe) field.get(null);
            stateOffset = unsafe.objectFieldOffset(UnsafeDemo02Test.class.getDeclaredField("state"));
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
            throw new Error(e);
        }
    }

    public static void main(String[] args) {
        UnsafeDemo02Test test = new UnsafeDemo02Test();
        final boolean b = unsafe.compareAndSwapInt(test, stateOffset, 0, 1);
        System.out.println("b = " + b);
    }
}
