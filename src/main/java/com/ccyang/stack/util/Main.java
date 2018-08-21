package com.ccyang.stack.util;

import java.util.Random;

/**
 * @author ccyang
 * @date 2018/8/21 21:56
 */
public class Main {

    private static double testStack(Stack<Integer> stack, int opCount){

        long startTime = System.nanoTime();
        Random random = new Random();
        for (int i=0; i<opCount; i++)
            stack.push(random.nextInt(Integer.MAX_VALUE));

        for (int i=0; i<opCount; i++)
            stack.pop();

        long endTime = System.nanoTime();
        return (endTime - startTime) / 1000000000.0 ;
    }

    public static void main(String[] args) {

        int opCount = 100000;

        ArrayStack<Integer> arrayStack = new ArrayStack<>();
        double time1 = testStack(arrayStack, opCount);
        System.out.println("ArrayStack: time1 = " + time1 +"s");  // 0.0373s

        LinkedListStack<Integer> linkedListStack = new LinkedListStack<>();
        double time2 = testStack(linkedListStack, opCount);
        System.out.println("LinkedListStack: time2 = " + time2 +"s");  // 0.0154s

        // 这个比较很复杂，因为LinkedListStack 中包含更多的 new操作

    }

}
