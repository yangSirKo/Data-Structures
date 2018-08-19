package com.ccyang.array.util;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author ccyang
 * @date 2018/8/19 19:51
 */
public class ArrayTest {

    @Test
    public void arrayTest(){
        Array<Integer> arr = new Array<>();
        for (int i = 0; i < 10; i++)
            arr.addLast(i);
        System.out.println(arr);

        arr.add(1,100);
        System.out.println(arr);

        arr.addFrist(-1);
        System.out.println(arr);

        arr.remove(2);
        System.out.println(arr);

        arr.removeElement(4);
        System.out.println(arr);

        arr.add(2, 1);
        System.out.println(arr);

        arr.removeAllElement(1);
        System.out.println(arr);
    }

}