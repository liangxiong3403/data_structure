package org.liangxiong.data.structure.map;

/**
 * @author liangxiong
 * @Date:2019-07-30
 * @Time:11:11
 * @Description 基于二分搜索树实现映射
 */
public class TreeMap<K extends Comparable<K>, V> implements Map<K, V> {

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

        public Node(K key, V value) {
            this(key, value, null, null);
        }

        public Node(K key, V value, Node left, Node right) {
            this.key = key;
            this.value = value;
            this.left = left;
            this.right = right;
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
    @Override
    public void add(K key, V value) {
        this.root = add(this.root, key, value);
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
        return node;
    }

    /**
     * 删除key所在节点
     *
     * @param key 键
     * @return
     */
    @Override
    public V remove(K key) {
        Node node = getNode(this.root, key);
        if (node != null) {
            this.root = remove(this.root, key);
            return node.value;
        }
        return null;
    }

    /**
     * 获取二分搜索树中最小元素
     *
     * @return
     */
    public V minimum() {
        if (isEmpty()) {
            throw new IllegalArgumentException("BST is empty");
        }
        return minimum(root).value;
    }

    /**
     * 获取二分搜索树中最小元素所在地节点
     *
     * @param node
     * @return
     */
    private Node minimum(Node node) {
        if (node.left == null) {
            return node;
        }
        return minimum(node.left);
    }

    /**
     * 删除最小元素所在节点
     *
     * @return
     */
    public V removeMin() {
        V minimum = minimum();
        this.root = removeMin(root);
        return minimum;
    }

    /**
     * 通过根节点删除指定元素
     *
     * @param node 根节点
     * @return
     */
    private Node removeMin(Node node) {
        if (node.left == null) {
            Node rightNode = node.right;
            node.right = null;
            size--;
            return rightNode;
        }
        node.left = removeMin(node.left);
        return node;
    }

    /**
     * 删除指定元素
     *
     * @param node 根节点
     * @param key  待删除元素key
     * @return
     */
    private Node remove(Node node, K key) {
        if (node == null) {
            return null;
        }
        if (key.compareTo(node.key) < 0) {
            node.left = remove(node.left, key);
            return node;
        } else if (key.compareTo(node.key) > 0) {
            node.right = remove(node.right, key);
            return node;
        } else {
            // 待删除节点左子树为空的情况
            if (node.left == null) {
                Node rightNode = node.right;
                node.right = null;
                size--;
                return rightNode;
            }
            // 待删除节点右子树为空的情况
            if (node.right == null) {
                Node leftNode = node.left;
                node.left = null;
                size--;
                return leftNode;
            }
            // 找到比待删除节点大的最小节点，即待删除节点右子树的最小节点；用这个节点顶替待删除节点位置
            Node target = minimum(node.right);
            size++;
            target.right = removeMin(node.right);
            target.left = node.left;
            node.left = node.right = null;
            size--;
            return target;
        }
    }

    /**
     * 判断是否包含
     *
     * @param key 键
     * @return
     */
    @Override
    public boolean contains(K key) {
        return getNode(this.root, key) != null;
    }

    /**
     * 查找key
     *
     * @param key 键
     * @return
     */
    @Override
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
    @Override
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
        generateString(root, result);
        return result.toString();
    }

    /**
     * 生产打印字符串
     *
     * @param root   根节点
     * @param result 字符串
     */
    private void generateString(Node root, StringBuilder result) {
        if (root == null) {
            return;
        }
        result.append(root.key + " : " + root.value + " ; ");
        generateString(root.left, result);
        generateString(root.right, result);
    }
}
