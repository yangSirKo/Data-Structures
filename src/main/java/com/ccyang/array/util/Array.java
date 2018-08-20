package com.ccyang.array.util;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ccyang
 * @date 2018/8/19 19:14
 */
public class Array<E> {

    private E[] data;
    // 指向当前数组中第一没有元素的位置
    private int size;

    /**
     * 构造函数，传入数组的容量 capacity 构造Array
     * @param capacity
     */
    public Array(int capacity){
        data = (E[])new Object[capacity];
        size = 0;
    }

    /**
     * 无参构造函数，数组默认容量为 capacity = 10
     */
    public Array(){
        this(10);
    }

    /**
     * 获取数组中的元素的个数
     * @return
     */
    public int getSize(){
        return size;
    }

    /**
     * 获取数组的容量
     * @return
     */
    public int getCapacity(){
        return data.length;
    }

    /**
     * 数组是否为空
     * @return
     */
    public boolean isEmpty(){
        return size == 0;
    }

    /**
     * 向第index 个位置插入一个新元素e
     * @param index
     * @param e
     */
    public void add(int index, E e){
        if(index < 0 || index > size)
            throw new IllegalArgumentException("add failed, Array is full");

        if(size == data.length)
            resize(2 * data.length);

        for(int i=size-1; i>=index; i--)
            data[i+1] = data[i];
        data[index] = e;
        size ++;
    }


    /**
     * 向所有元素后添加一个新元素
     * @param e
     */
    public void addLast(E e){
        add(size, e);
    }


    /**
     * 向第一个位置插入元素
     * @param e
     */
    public void addFrist(E e){
        add(0, e);
    }

    /**
     * 获取 index位置的元素
     * @return
     */
    public E get(int index){
        if(index < 0 || index >= size)
            throw new IllegalArgumentException("Get failed , Index is illegal");
        return data[index];
    }

    /**
     * 获取最后一个的元素
     * @return
     */
    public E getLast(){
        return get(size-1);
    }

    /**
     * 获取第一个位置的元素
     * @return
     */
    public E getFirst(){
        return get(0);
    }

    /**
     * 修改index索引位置的元素
     * @return
     */
    public void set(int index, E e){
        if(index < 0 || index >= size)
            throw new IllegalArgumentException("Set failed , Index is illegal");
        data[index] = e;
    }

    /**
     * 查找数组中是否有元素e
     * @return
     */
    public boolean contains(E e){
        for(int i=0; i<size; i++)
            if(data[i].equals(e))
                return true;
        return false;
    }

    /**
     * 查找数组中元素 e 的索引，如果不存在e, 则返回-1
     * @return
     */
    public int find(E e){
        for(int i=0; i<size; i++)
            if(data[i].equals(e))
                return i;
        return -1;
    }

    /**
     * 查找数组中值为 e 的所有元素的索引，如果不存在e, 则返回-1
     * @return
     */
    public int[] findAll(E e){
        List<Integer> res = new ArrayList<>();
        for(int i=0; i<size; i++)
            if(data[i].equals(e))
                res.add(i);
        // 存放索引
        int[] ret = new int[res.size()];
        for(int i = 0; i<res.size(); i++)
            ret[i] = res.get(i);
        return ret;
    }

    /**
     * 删除 index位置的元素，并返回删除的元素
     * @param index
     * @return
     */
    public E remove(int index){
        if(index < 0 || index >= size )
            throw new IllegalArgumentException("Remove failed, index is illegal");

        E ret = data[index];
        for(int i=index+1; i<size; i++)
            data[i-1] = data[i];
        size--;
        data[size] = null;   // loitering objects != memory leak , loitering objects 不算内存泄露

        // length/4避免复杂度震荡， length/2!=0 防止缩容到0
        if(size == data.length / 4 && data.length/2 != 0)
            resize(data.length/2);
        return ret;
    }

    /**
     * 从数组中删除数组第一个元素，返回删除的元素
     * @return
     */
    public E removeFirst(){
        return remove(0);
    }

    /**
     * 从数组中删除最后一个元素，并返回删除的元素
     * @return
     */
    public E removeLast(){
        return remove(size-1);
    }

    /**
     * 从数组中删除元素 e， 默认删第一个e
     * @return
     */
    public void removeElement(E e){
        int index = find(e);
        if(index != -1){
            remove(index);
        }
    }

    /**
     * 从数组中删除所有等于e 的元素
     * @return
     */
    public void removeAllElement(E e){

        int[] indexs = findAll(e);
        if(indexs == null || indexs.length <= 0){
            throw new IllegalArgumentException("not found element e");
        }
        for(int i=indexs.length-1; i>=0; i--)
            remove(indexs[i]);
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append(String.format("Array: size = %d , capacity = %d\n", size, data.length));
        res.append('[');
        for(int i=0; i<size; i++){
            res.append( data[i] );
            if (i != size-1)
                res.append(", ");
        }
        return res.append(']').toString();
    }
    // 2 倍扩容
    private void resize(int newCapacity){
        E[] newData = (E[])new Object[newCapacity];
        for(int i=0; i<size; i++)
            newData[i] = data[i];
        data = newData;
    }
}
