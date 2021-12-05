package com.snailjw.demo;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * 数组扩容
 *
 * @author : snail
 * @date : 2021-12-05 23:11
 **/
public class CopyOfTest {
    /**
     * 对数组进行扩容/缩容
     * @param o 需要扩容/缩容的数组
     * @param newLength 数组变化后的长度
     * @return 新数组
     */
    public static Object goodCopy(Object o,int newLength){
        Class clazz = o.getClass();
        if (!clazz.isArray()) {
            return null;
        }
        Class componentType = clazz.getComponentType();
        int length = Array.getLength(o);
        Object newArray = Array.newInstance(componentType,newLength);
        System.arraycopy(o,0,newArray,0,Math.min(length,newLength));
        return newArray;
    }

    public static void main(String[] args) {
        int[] a = {1,2,3,4,5,6};
        a = (int[]) goodCopy(a, 3);
        System.out.println(Arrays.toString(a));
    }
}
