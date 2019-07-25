package org.liangxiong.data.structure.queue;

import org.liangxiong.data.structure.array.Array;

/**
 * @author liangxiong
 * @Date:2019-07-25
 * @Time:10:19
 * @Description 基于数组实现队列
 */
public class ArrayQueue<E> implements Queue<E> {

    /**
     * 底层基于数组实现
     */
    private Array<E> array;

    /**
     * 构造指定容量大小地队列
     *
     * @param capacity 队列容量
     */
    public ArrayQueue(int capacity) {
        array = new Array<>(capacity);
    }

    public ArrayQueue() {
        array = new Array<>();
    }

    /**
     * 入队
     *
     * @param e 元素
     */
    @Override
    public void enqueue(E e) {
        this.array.addLast(e);
    }

    /**
     * 出队
     *
     * @return
     */
    @Override
    public E dequeue() {
        return this.array.removeFirst();
    }

    /**
     * 获取队列队首元素
     *
     * @return
     */
    @Override
    public E getFront() {
        return this.array.getFirst();
    }

    /**
     * 获取队列中元素个数
     *
     * @return
     */
    @Override
    public int getSize() {
        return this.array.getSize();
    }

    /**
     * 判断队列是否为空
     *
     * @return
     */
    @Override
    public boolean isEmpty() {
        return this.array.isEmpty();
    }

    /**
     * 获取队列容量
     *
     * @return
     */
    public int getCapacity() {
        return this.array.getCapacity();
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append("queue: ");
        result.append("front [");
        for (int i = 0; i < getSize(); i++) {
            result.append(array.get(i));
            if (i != getSize() - 1) {
                result.append(", ");
            } else {
                result.append("] tail");
            }
        }
        return result.toString();
    }
}
