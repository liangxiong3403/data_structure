package org.liangxiong.data.structure.queue;

/**
 * @author liangxiong
 * @Date:2019-07-27
 * @Time:11:10
 * @Description 基于链表实现队列
 */
public class LinkedListQueue<E> implements Queue<E> {

    /**
     * 底层数据结构
     */
    private class Node {

        /**
         * 普通元素
         */
        private E e;

        /**
         * 下一个节点
         */
        private Node next;

        public Node(E e, Node next) {
            this.e = e;
            this.next = next;
        }

        public Node(E e) {
            this(e, null);
        }

        @Override
        public String toString() {
            return e.toString();
        }
    }

    /**
     * 头节点
     */
    private Node head;

    /**
     * 尾节点
     */
    private Node tail;

    /**
     * 队列中元素个数
     */
    private int size;

    public LinkedListQueue() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    /**
     * 入队操作
     *
     * @param e 元素
     */
    @Override
    public void enqueue(E e) {
        if (tail == null) {
            // 队列中没有元素
            this.tail = new Node(e);
            this.head = this.tail;
        } else {
            // 队列中已有元素
            tail.next = new Node(e);
            this.tail = tail.next;
        }
        size++;
    }

    /**
     * 出队操作
     *
     * @return
     */
    @Override
    public E dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("Cannot dequeue from an empty queue");
        }
        // 获取头节点
        Node delNode = head;
        // 改变当前头节点指针
        this.head = delNode.next;
        // 帮助垃圾回收
        delNode.next = null;
        if (head == null) {
            // 如果队列为空
            this.tail = null;
        }
        this.size--;
        return delNode.e;
    }

    /**
     * 获取队列中最后一个元素
     *
     * @return
     */
    @Override
    public E getFront() {
        if (isEmpty()) {
            throw new IllegalStateException("Cannot get element from an empty queue");
        }
        return this.head.e;
    }

    @Override
    public int getSize() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append("linked list queue front: [");
        Node cur = head;
        for (int i = 0; i < size; i++) {
            result.append(cur.e);
            if (i != size - 1) {
                result.append(", ");
            } else {
                result.append("] tail");
            }
            cur = cur.next;
        }
        return result.toString();
    }
}
