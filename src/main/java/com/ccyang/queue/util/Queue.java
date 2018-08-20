package com.ccyang.queue.util;

/**
 * @author ccyang
 * @date 2018/8/20 22:18
 */
public interface Queue<E> {

    int getSize();

    boolean isEmpty();

    void enqueue(E e);

    E dequeue();

    E getFront();

}
