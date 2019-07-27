package org.liangxiong.data.structure.queue;

/**
 * @author liangxiong
 * @Date:2019-07-25
 * @Time:11:08
 * @Description 循环队列(front = = tail表示队列为空 ; ( tail + 1)%data.length==front表示队列已满)
 */
public class LoopQueue<E> implements Queue<E> {

    /**
     * 底层数据结构
     */
    private E[] data;

    /**
     * 队首
     */
    private int front;

    /**
     * 队尾
     */
    private int tail;

    /**
     * 队列中元素个数
     */
    private int size;

    /**
     * 循环队列需要浪费一个存储空间
     *
     * @param capacity 队列容量空间
     */
    public LoopQueue(int capacity) {
        this.data = (E[]) new Object[capacity + 1];
        front = 0;
        tail = 0;
        size = 0;
    }

    public LoopQueue() {
        this(10);
    }

    /**
     * 入队操作
     *
     * @param e 元素
     */
    @Override
    public void enqueue(E e) {
        // 判断队列是否已满
        if ((tail + 1) % data.length == front) {
            // 扩容操作
            resize(this.getCapacity() * 2);
        }
        // 数据填充
        data[tail] = e;
        // tail位置移动
        tail = (tail + 1) % data.length;
        size++;
    }

    /**
     * 队列扩容操作
     *
     * @param newCapacity 队列容量
     */
    private void resize(int newCapacity) {
        E[] newData = (E[]) new Object[newCapacity + 1];
        for (int i = 0; i < this.size; i++) {
            newData[i] = this.data[(i + this.front) % this.data.length];
        }
        this.data = newData;
        this.front = 0;
        this.tail = size;

    }

    @Override
    public E dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("Cannot dequeue from an empty queue");
        }
        // 获取队首元素
        E returnElement = data[front];
        // 帮助垃圾回收
        data[front] = null;
        // front位置移动
        front = (front + 1) % data.length;
        size--;
        int capacity = getCapacity();
        if (capacity != 0 && size == capacity / 4) {
            resize(capacity / 2);
        }
        return returnElement;
    }

    @Override
    public E getFront() {
        if (isEmpty()) {
            throw new IllegalStateException("Cannot get element from an empty queue");
        }
        return data[front];
    }

    @Override
    public int getSize() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        // 也可以使用size == 0 判断
        return this.front == this.tail;
    }

    /**
     * 获取队列容量(循环队列需要浪费一个存储空间)
     *
     * @return
     */
    public int getCapacity() {
        return this.data.length - 1;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append(String.format("Queue: size = %d, capacity = %d\n", size, getCapacity()));
        result.append("front [");
        for (int i = front; i != tail; i = (i + 1) % data.length) {
            result.append(data[i]);
            if ((i + 1) % data.length != tail) {
                result.append(", ");
            } else {
                result.append("] tail");
            }
        }
        return result.toString();
    }
}
