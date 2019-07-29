package org.liangxiong.data.structure.set;

import org.liangxiong.data.structure.linkedlist.LinkedList;

/**
 * @author liangxiong
 * @Date:2019-07-29
 * @Time:21:58
 * @Description 基于链表实现集合
 */
public class LinkedListSet<E> implements Set<E> {

    /**
     * 底层数据结构
     */
    private LinkedList<E> linkedList;

    public LinkedListSet() {
        this.linkedList = new LinkedList<>();
    }

    @Override
    public void add(E e) {
        if (!contains(e)) {
            // 添加到头部时间复杂度最低O(1)
            this.linkedList.addFirst(e);
        }
    }

    @Override
    public void remove(E e) {
        this.linkedList.removeElement(e);
    }

    @Override
    public boolean contains(E e) {
        return this.linkedList.contains(e);
    }

    @Override
    public int getSize() {
        return this.linkedList.getSize();
    }

    @Override
    public boolean isEmpty() {
        return this.linkedList.isEmpty();
    }

    @Override
    public String toString() {
        return linkedList.toString();
    }
}
