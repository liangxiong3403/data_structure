package org.liangxiong.data.structure.queue;

/**
 * @author liangxiong
 * @Date:2019-07-25
 * @Time:10:16
 * @Description 队列
 */
public interface Queue<E> {

    /**
     * 入队操作
     *
     * @param e 元素
     */
    void enqueue(E e);

    /**
     * 出队操作
     *
     * @return 元素
     */
    E dequeue();

    /**
     * 获取队首元素
     *
     * @return
     */
    E getFront();

    /**
     * 获取队列中元素个数
     *
     * @return
     */
    int getSize();

    /**
     * 队列是否为空
     *
     * @return
     */
    boolean isEmpty();
}
