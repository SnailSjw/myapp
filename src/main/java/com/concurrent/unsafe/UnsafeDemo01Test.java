package com.concurrent.unsafe;

import sun.misc.Unsafe;

/**
 * 测试UnSafe类
 *
 * @author : snail
 * @date : 2021-12-10 20:38
 **/
public class UnsafeDemo01Test {
    static final Unsafe unsafe = Unsafe.getUnsafe();
    static final long stateOffset;
    private volatile long state = 0;

    static {
        try {
            stateOffset = unsafe.objectFieldOffset(UnsafeDemo01Test.class.getDeclaredField("state"));
        } catch (NoSuchFieldException e) {
            System.out.println(e.getLocalizedMessage());
            throw new Error(e);
        }
    }

    public static void main(String[] args) {
        UnsafeDemo01Test unsafeDemo01Test = new UnsafeDemo01Test();
        final boolean b = unsafe.compareAndSwapInt(unsafeDemo01Test, stateOffset, 0, 1);
        System.out.println(b);
    }
}
