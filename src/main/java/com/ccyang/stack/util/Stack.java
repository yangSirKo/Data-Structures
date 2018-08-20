package com.ccyang.stack.util;

/**
 * @author ccyang
 * @date 2018/8/20 21:10
 */
public interface Stack<E> {

    int getSize();

    boolean isEmpty();

    void push(E e);

    E pop();

    E peek();

}
