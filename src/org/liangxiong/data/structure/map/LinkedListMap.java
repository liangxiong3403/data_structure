package org.liangxiong.data.structure.map;

/**
 * @author liangxiong
 * @Date:2019-07-30
 * @Time:11:14
 * @Description 基于链表实现映射(key是无序地)
 */
public class LinkedListMap<K, V> implements Map<K, V> {

    /**
     * 底层数据结构
     */
    private class Node {

        /**
         * 键
         */
        private K key;

        /**
         * 值
         */
        private V value;

        /**
         * 下一个节点引用
         */
        private Node next;

        public Node(K key, V value, Node next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }

        public Node(K key) {
            this(key, null, null);
        }

        public Node() {
            this(null, null, null);
        }

        @Override
        public String toString() {
            return key.toString() + " : " + value.toString();
        }
    }

    /**
     * 虚拟头节点
     */
    private Node dummyHead;

    /**
     * 映射中元素个数
     */
    private int size;

    public LinkedListMap() {
        this.dummyHead = new Node();
        this.size = 0;
    }

    /**
     * 新增元素
     *
     * @param key   键
     * @param value 值
     */
    @Override
    public void add(K key, V value) {
        Node node = getNode(key);
        if (node == null) {
            // 添加到头部
            dummyHead.next = new Node(key, value, dummyHead.next);
            size++;
        } else {
            // 更新已有key的value
            node.value = value;
        }
    }

    /**
     * 获取指定键所在节点
     *
     * @param key 键
     * @return
     */
    private Node getNode(K key) {
        Node cur = dummyHead.next;
        while (cur != null) {
            if (cur.key.equals(key)) {
                return cur;
            }
            cur = cur.next;
        }
        return null;
    }

    /**
     * 删除元素
     *
     * @param key 键
     * @return
     */
    @Override
    public V remove(K key) {
        Node prev = dummyHead;
        while (prev.next != null) {
            if (prev.next.key.equals(key)) {
                break;
            }
            prev = prev.next;
        }
        if (prev.next != null) {
            Node delNode = prev.next;
            prev.next = delNode.next;
            delNode.next = null;
            size--;
            return delNode.value;
        }
        return null;
    }

    /**
     * 是否包含键
     *
     * @param key 键
     * @return
     */
    @Override
    public boolean contains(K key) {
        return getNode(key) != null;
    }

    @Override
    public V get(K key) {
        Node cur = getNode(key);
        return cur != null ? cur.value : null;
    }

    /**
     * 修改
     *
     * @param key   键
     * @param value 值
     */
    @Override
    public void set(K key, V value) {
        Node node = getNode(key);
        if (node != null) {
            node.value = value;
        } else {
            throw new IllegalArgumentException("key is not exist");
        }
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
        Node cur = dummyHead.next;
        result.append("linked list map: [ ");
        for (int i = 0; i < getSize(); i++) {
            result.append(cur.toString());
            if (i != getSize() - 1) {
                result.append(", ");
            } else {
                result.append(" ]");
            }
            cur = cur.next;
        }
        return result.toString();
    }
}
