package com.ccyang.linkedList.util;

/**
 * @author ccyang
 * @date 2018/8/21 20:56
 * 链表
 */
public class LinkedList<E> {

    private class Node{

        public E e;
        public Node next;

        public Node(E e, Node next){
            this.e = e;
            this.next = next;
        }

        public Node(E e){
            this.e = e;
            this.next = null;
        }

        public Node(){
            this(null, null);
        }

        @Override
        public String toString() {
            return e.toString();
        }
    }

    private Node dummyHead;
    private int size;

    public LinkedList(){
        dummyHead = new Node(null,null);
        size = 0;
    }

    /**
     * 获取链表中元素个数
         */
    public int getSize(){
        return size;
    }

    /**
     * 链表是否为空
     * @return
     */
    public boolean isEmpty(){
        return size == 0;
    }

    /**
     * 在链表的index(0-based) 位置添加元素 e
     * 这在链表中不是一个常用的操作,练习用:)
     */
    public void add(int index, E e){

        if (index < 0 || index > size)
            throw new IllegalArgumentException("Add failed, Illegal index");

        Node prev = dummyHead;
        for(int i = 0 ; i < index ; i ++)
            prev = prev.next;

        prev.next = new Node(e, prev.next);
        size ++;
    }

    /**
     * 在链表头添加新元素 e
     */
    public void addFirst(E e){
        add(0, e);
    }

    /**
     * 在链表尾部添加节点
     */
    public void addLast(E e){
        add(size, e);
    }

    /**
     * 获得链表的第 index(0-based)个位置的元素
     * 在链表中不是一个常用操作，练习用：)
     */
    public E get(int index){
        if (index < 0 || index > size)
            throw new IllegalArgumentException("Get failed, Illegal index.");

        Node cur = dummyHead.next;
        for(int i = 0 ; i < index ; i ++)
            cur = cur.next;
        return cur.e;
    }

    /**
     * 获得链表第一个元素
     */
    public E getFirst(){
        return get(0);
    }

    /**
     * 获得链表最后一个元素
     */
    public E getLast(){
        return get(size - 1);
    }

    /**
     * 修改链表的第 index(0-based)个位置的元素
     * 在链表中不是一个常用操作，练习用：)
     */
    public void set(int index, E e){
        if (index < 0 || index > size)
            throw new IllegalArgumentException("Set failed, Illegal index.");

        Node cur = dummyHead.next;
        for(int i = 0 ; i < index ; i ++)
            cur = cur.next;
        cur.e = e;
    }

    /**
     * 查找链表中是否存在 e
     */
    public boolean contains(E e){

        Node cur = dummyHead.next;
        while (cur != null){
            if (cur.e.equals(e))
                return true;
            cur = cur.next;
        }
        return false;
    }

    /**
     * 删除链表的第 index(0-based)个位置的元素
     * 在链表中不是一个常用操作，练习用：)
     */
    public E remove(int index){
        if (index < 0 || index > size)
            throw new IllegalArgumentException("remove failed, Illegal index.");

        Node prev = dummyHead;
        for(int i = 0 ; i < index ; i ++)
            prev = prev.next;

        Node delNode = prev.next;
        prev.next = delNode.next;
        delNode.next = null;
        size --;

        return delNode.e;
    }

    /**
     * 删除第一个元素，返回删除的元素
     * @return
     */
    public E removeFirst(){
        return remove(0);
    }

    /**
     * 删除后一个元素, 返回删除的元素
     * @return
     */
    public E removeLast(){
        return remove(size - 1);
    }

    @Override
    public String toString() {

        StringBuilder res = new StringBuilder();
        Node cur = dummyHead.next;
        while(cur != null){
            res.append(cur + "->");
            cur = cur.next;
        }
        res.append("NULL");
        return res.toString();
    }
}
