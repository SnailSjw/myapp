package com.snailjw.demo;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

/**
 * 集合链表测试
 *
 * @author : snail
 * @date : 2021-12-07 15:46
 **/
public class LinkedListTest {
    public static void main(String[] args) {
        List<String> a  = new LinkedList<>();
        a.add("Maxine");
        a.add("Harry");
        a.add("Tim");
        List<String> b = new LinkedList<>();
        b.add("Gonden");
        b.add("Via");
        b.add("Srelam");

        ListIterator<String> aListIterator = a.listIterator();
        Iterator<String> bIterator = b.iterator();
        while (bIterator.hasNext()){
            if (aListIterator.hasNext()){
                aListIterator.next();
            }
            aListIterator.add(bIterator.next());
        }
        System.out.println(a);
        bIterator = b.iterator();
        while (bIterator.hasNext()){
            bIterator.next();
            if (bIterator.hasNext()){
                bIterator.next();
                bIterator.remove();
            }
        }
        System.out.println(b);
        a.removeAll(b);
        System.out.println(a);
    }
}
