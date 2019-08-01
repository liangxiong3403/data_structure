package org.liangxiong.data.structure.queue;

import org.liangxiong.data.structure.maxheap.MaxHeap;

/**
 * @author liangxiong
 * @Date:2019-08-01
 * @Time:10:01
 * @Description 优先队列，队列中的元素具有优先级，基于堆实现
 */
public class PriorityQueue<E extends Comparable<E>> implements Queue<E> {

    /**
     * 底层数据结构为堆
     */
    private MaxHeap<E> maxHeap;

    public PriorityQueue() {
        this.maxHeap = new MaxHeap<>();
    }

    /**
     * 入队操作
     *
     * @param e 元素
     */
    @Override
    public void enqueue(E e) {
        this.maxHeap.add(e);
    }

    /**
     * 出队操作
     *
     * @return
     */
    @Override
    public E dequeue() {
        return this.maxHeap.extractMax();
    }

    /**
     * 获取最高优先级元素
     *
     * @return
     */
    @Override
    public E getFront() {
        return this.maxHeap.findMax();
    }

    /**
     * 获取队列元素个数
     *
     * @return
     */
    @Override
    public int getSize() {
        return this.maxHeap.getSize();
    }

    /**
     * 判断队列是否为空
     *
     * @return
     */
    @Override
    public boolean isEmpty() {
        return this.maxHeap.isEmpty();
    }
}
