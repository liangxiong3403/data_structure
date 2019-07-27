package org.liangxiong.data.structure.stack;

import org.liangxiong.data.structure.linkedlist.LinkedList;

/**
 * @author liangxiong
 * @Date:2019-07-27
 * @Time:10:39
 * @Description 基于链表实现栈的逻辑
 */
public class LinkedListStack<E> implements Stack<E> {

    /**
     * 底层数据结构
     */
    private LinkedList<E> linkedList;

    public LinkedListStack() {
        this.linkedList = new LinkedList<>();
    }

    /**
     * 入栈操作，时间复杂度O(1)
     *
     * @param e 元素
     */
    @Override
    public void push(E e) {
        // 头部添加元素复杂度最低
        linkedList.addFirst(e);
    }

    /**
     * 弹出栈顶元素
     *
     * @return
     */
    @Override
    public E pop() {
        return linkedList.removeFirst();
    }

    /**
     * 获取栈顶元素
     *
     * @return
     */
    @Override
    public E peek() {
        return linkedList.getFirst();
    }

    @Override
    public int getSize() {
        return linkedList.getSize();
    }

    @Override
    public boolean isEmpty() {
        return linkedList.isEmpty();
    }

    @Override
    public String toString() {
        return linkedList.toString();
    }
}
