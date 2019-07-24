package org.liangxiong.data.structure.stack;

import org.liangxiong.data.structure.array.Array;

/**
 * @author liangxiong
 * @Date:2019-07-24
 * @Time:20:36
 * @Description 底层基于数组实现
 */
public class ArrayStack<E> implements Stack<E> {

    /**
     * 数据容器
     */
    private Array<E> array;

    /**
     * 构造
     *
     * @param capacity 容量
     */
    public ArrayStack(int capacity) {
        this.array = new Array<>(capacity);
    }

    /**
     * 默认构造器
     */
    public ArrayStack() {
        this.array = new Array<>();
    }

    /**
     * 入栈
     *
     * @param e 元素
     */
    @Override
    public void push(E e) {
        this.array.addLast(e);
    }

    /**
     * 出栈
     *
     * @return
     */
    @Override
    public E pop() {
        return this.array.removeLast();
    }

    /**
     * 获取栈顶元素
     *
     * @return
     */
    @Override
    public E peek() {
        return this.array.getFirst();
    }

    /**
     * 获取栈中元素个数
     *
     * @return
     */
    @Override
    public int getSize() {
        return this.array.getSize();
    }

    /**
     * 判断栈是否为空
     *
     * @return
     */
    @Override
    public boolean isEmpty() {
        return this.array.isEmpty();
    }

    /**
     * 获取栈的容量
     *
     * @return
     */
    public int getCapacity() {
        return this.array.getCapacity();
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append("stack: ");
        result.append("[");
        for (int i = 0; i < getSize(); i++) {
            result.append(array.get(i));
            int lastIndexOfElement = getSize() - 1;
            if (i != lastIndexOfElement) {
                result.append(", ");
            } else {
                result.append("] top");
            }
        }
        return result.toString();
    }
}
