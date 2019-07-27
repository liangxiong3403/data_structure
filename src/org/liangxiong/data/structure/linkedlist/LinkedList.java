package org.liangxiong.data.structure.linkedlist;

/**
 * @author liangxiong
 * @Date:2019-07-26
 * @Time:21:22
 * @Description 链表
 */
public class LinkedList<E> {

    /**
     * 链表中的节点
     *
     * @param
     */
    private class Node {

        /**
         * 节点元素
         */
        public E e;

        /**
         * 当前节点的下一个节点
         */
        public Node next;

        /**
         * 构造一个节点
         *
         * @param e    节点元素
         * @param next 下一个节点
         */
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
     * 虚拟头节点(位于索引为0的元素的前一个位置：dummyHead,0,1,2,...)
     */
    private Node dummyHead;

    /**
     * 链表中节点个数
     */
    private int size;

    /**
     * 构造一个链表
     */
    public LinkedList() {
        this.dummyHead = new Node(null, null);
        this.size = 0;
    }

    /**
     * 获取链表中节点个数
     *
     * @return
     */
    public int getSize() {
        return this.size;
    }

    /**
     * 判断链表是否为空
     *
     * @return
     */
    public boolean isEmpty() {
        return this.size == 0;
    }

    /**
     * 节点添加到链表头部
     *
     * @param e
     */
    public void addFirst(E e) {
        add(0, e);
    }

    /**
     * 添加节点到链表尾部
     *
     * @param e
     */
    public void addLast(E e) {
        add(size, e);
    }

    /**
     * 指定位置添加节点
     *
     * @param index 索引
     * @param e     元素
     */
    public void add(int index, E e) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("index is illegal");
        }
        // 从虚拟节点开始遍历
        Node prev = dummyHead;
        for (int i = 0; i < index; i++) {
            // 获取指定位置的节点
            prev = prev.next;
        }
        prev.next = new Node(e, prev.next);
        size++;
    }

    /**
     * 获取指定位置的元素
     *
     * @param index 索引
     * @return
     */
    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("index is illegal");
        }
        // 遍历起点: 索引为0的元素开始
        Node cur = dummyHead.next;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        return cur.e;
    }

    /**
     * 获取第一个节点
     *
     * @return
     */
    public E getFirst() {
        return get(0);
    }

    /**
     * 获取最后一个节点
     *
     * @return
     */
    public E getLast() {
        return get(size - 1);
    }

    /**
     * 更新指定位置节点
     *
     * @param index 索引
     * @param e     元素
     */
    public void set(int index, E e) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("index is illegal");
        }
        Node cur = dummyHead.next;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        cur.e = e;
    }

    /**
     * 判断链表的节点中是否包含某个元素
     *
     * @param e 待比较元素
     * @return
     */
    public boolean contains(E e) {
        Node cur = dummyHead.next;
        while (cur != null) {
            if (cur.e.equals(e)) {
                return true;
            }
            cur = cur.next;
        }
        return false;
    }

    /**
     * 删除指定位置元素
     *
     * @param index 索引
     */
    public E remove(int index) {
        Node prev = dummyHead;
        // 获取待删除元素的上一个节点
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }
        // 待删除节点
        Node delNode = prev.next;
        // 待删除节点的下一个节点重新链接上一个节点
        prev.next = delNode.next;
        // 帮助垃圾回收
        delNode.next = null;
        size--;
        return delNode.e;
    }

    /**
     * 删除第一个节点
     */
    public E removeFirst() {
        return remove(0);
    }

    /**
     * 删除最后一个节点
     */
    public E removeLast() {
        return remove(size - 1);
    }

    @Override
    public String toString() {
        Node cur = dummyHead.next;
        StringBuilder result = new StringBuilder();
        result.append("linked list: top [ ");
        for (int i = 0; i < size; i++) {
            result.append(cur.e.toString());
            if (i != size - 1) {
                result.append(", ");
            } else {
                result.append("] ");
            }
            cur = cur.next;
        }
        return result.toString();
    }

}
