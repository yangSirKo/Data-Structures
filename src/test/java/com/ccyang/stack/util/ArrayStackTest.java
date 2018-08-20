package com.ccyang.stack.util;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author ccyang
 * @date 2018/8/20 21:24
 */
public class ArrayStackTest {

    @Test
    public void stackTest(){

        ArrayStack<Integer> stack = new ArrayStack<>();

        for(int i=0; i<5; i++) {
            stack.push(i);
            System.out.println(stack);
        }

        stack.pop();
        System.out.println(stack);

    }
}