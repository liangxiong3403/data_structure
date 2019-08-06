package org.liangxiong.data.structure.redblack;

/**
 * @author liangxiong
 * @Date:2019-08-05
 * @Time:15:24
 * @Description 红黑树
 */
public class RedBlackTree<K extends Comparable<K>, V> {

    private static final boolean RED = true;

    private static final boolean BLACK = false;

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
         * 左子节点
         */
        private Node left;

        /**
         * 右子节点
         */
        private Node right;

        /**
         * 表示节点颜色
         */
        private boolean color;

        public Node(K key, V value) {
            this(key, value, null, null, RED);
        }

        public Node(K key, V value, Node left, Node right, boolean color) {
            this.key = key;
            this.value = value;
            this.left = left;
            this.right = right;
            this.color = color;
        }

        @Override
        public String toString() {
            return key.toString() + " : " + value.toString();
        }
    }

    /**
     * 根节点
     */
    private Node root;

    /**
     * 二分搜索树中节点个数
     */
    private int size;

    /**
     * 新增
     *
     * @param key   键
     * @param value 值
     */
    public void add(K key, V value) {
        this.root = add(this.root, key, value);
        // 根节点保持黑色
        this.root.color = BLACK;
    }

    /**
     * 在以node为根地二分搜索树中添加节点
     *
     * @param node  根节点
     * @param key   键
     * @param value 值
     * @return
     */
    private Node add(Node node, K key, V value) {
        if (node == null) {
            size++;
            return new Node(key, value);
        }
        if (key.compareTo(node.key) < 0) {
            node.left = add(node.left, key, value);
        } else if (key.compareTo(node.key) > 0) {
            node.right = add(node.right, key, value);
        } else {
            // 当用户输入地key已经存在,则修改值
            node.value = value;
        }
        if (isRed(node.right) && !isRed(node.left)) {
            node = leftRotate(node);
        }
        if (isRed(node.left) && isRed(node.left.left)) {
            node = rightRotate(node);
        }
        if (isRed(node.left) && isRed(node.right)) {
            flipColor(node);
        }
        return node;
    }

    /**
     * 判断是否包含
     *
     * @param key 键
     * @return
     */
    public boolean contains(K key) {
        return getNode(this.root, key) != null;
    }

    /**
     * 查找key
     *
     * @param key 键
     * @return
     */
    public V get(K key) {
        Node node = getNode(this.root, key);
        return node != null ? node.value : null;
    }

    /**
     * 修改
     *
     * @param key   键
     * @param value 值
     */
    public void set(K key, V value) {
        Node node = getNode(this.root, key);
        if (node == null) {
            throw new IllegalArgumentException("key is not exist");
        }
        node.value = value;
    }

    /**
     * 在以node为根地二分搜索树中查找元素为key地节点
     *
     * @param node 节点
     * @param key  键
     * @return
     */
    private Node getNode(Node node, K key) {
        if (node == null) {
            return null;
        }
        if (key.compareTo(node.key) == 0) {
            return node;
        } else if (key.compareTo(node.key) < 0) {
            return getNode(node.left, key);
        } else {
            return getNode(node.right, key);
        }
    }

    /**
     * 判断树结构是否为空
     *
     * @return
     */
    public boolean isEmpty() {
        return this.size == 0;
    }

    /**
     * 获取节点个数
     *
     * @return
     */
    public int getSize() {
        return this.size;
    }

    /**
     * 判断节点颜色
     *
     * @param node
     * @return
     */
    private boolean isRed(Node node) {
        if (node == null) {
            return BLACK;
        }
        return node.color;
    }

    /**
     * 节点左旋转
     *      node                    x
     *     /    \                 /   \
     *    T1     x ----------->  node  T3
     *          / \              /  \
     *         T2  T3           T1   T2
     *
     * @param node
     * @return
     */
    private Node leftRotate(Node node) {
        Node x = node.right;
        node.right = x.left;
        x.left = node;
        x.color = node.color;
        node.color = RED;
        return x;
    }

    /**
     * 节点右旋转
     *      node                    x
     *     /    \                 /   \
     *    x     T3 ----------->  T1   node
     *   /  \                         /  \
     *  T1   T2                      T2   T3
     *
     * @param node
     * @return
     */
    private Node rightRotate(Node node) {
        Node x = node.left;
        node.left = x.right;
        x.right = node;
        x.color = node.color;
        node.color = RED;
        return x;
    }

    /**
     * 颜色翻转
     *
     * @param node
     */
    private void flipColor(Node node) {
        node.color = RED;
        node.left.color = BLACK;
        node.right.color = BLACK;
    }
}
