package org.liangxiong.data.structure.avl;

import java.util.ArrayList;

/**
 * @author liangxiong
 * @Date:2019-08-04
 * @Time:20:29
 * @Description AVL树
 */
public class AVLTree<K extends Comparable<K>, V> {

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
         * 节点高度
         */
        private int height;

        public Node(K key, V value) {
            this(key, value, null, null, 1);
        }

        public Node(K key, V value, Node left, Node right, int height) {
            this.key = key;
            this.value = value;
            this.left = left;
            this.right = right;
            this.height = height;
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
        // 更新height
        node.height = 1 + Math.max(getHeight(node.left), getHeight(node.right));
        // 更新平衡因子
        int balanceFactor = getBalanceFactor(node);
        // LL
        if (balanceFactor > 1 && getBalanceFactor(node.left) >= 0) {
            return rightRotate(node);
        }
        // RR
        if (balanceFactor < -1 && getBalanceFactor(node.right) <= 0) {
            return leftRotate(node);
        }
        // LR
        if (balanceFactor > 1 && getBalanceFactor(node.left) < 0) {
            node.left = leftRotate(node.left);
            // LR - LL
            return rightRotate(node);
        }
        // RL
        if (balanceFactor < -1 && getBalanceFactor(node.right) > 0) {
            node.right = rightRotate(node.right);
            // RL - RR
            return leftRotate(node);
        }
        return node;
    }

    /**
     * 右旋转
     *        y             向右旋转(y)        x
     *      /   \                          /    \
     *     x    T4                        z      y
     *    / \                            / \    / \
     *   z   T3                         T1  T2 T3  T4
     *  /  \
     * T1   T2
     * @param y
     * @return
     */
    private Node rightRotate(Node y) {
        Node x = y.left;
        Node T3 = x.right;
        x.right = y;
        y.left = T3;
        // 更新height
        y.height = Math.max(getHeight(y.left), getHeight(y.right)) + 1;
        x.height = Math.max(getHeight(x.left), getHeight(x.right)) + 1;
        return x;
    }

    /**
     * 左旋转
     *        y             向左旋转(y)        x
     *      /   \                          /    \
     *     T1    x                        y      z
     *          /  \                     / \    / \
     *        T2    z                  T1  T2 T3  T4
     *             /  \
     *            T3   T4
     * @param y
     * @return
     */
    private Node leftRotate(Node y) {
        Node x = y.right;
        Node T2 = x.left;
        x.left = y;
        y.right = T2;
        // 更新height
        y.height = Math.max(getHeight(y.left), getHeight(y.right)) + 1;
        x.height = Math.max(getHeight(x.left), getHeight(x.right)) + 1;
        return x;
    }

    /**
     * 删除key所在节点
     *
     * @param key 键
     * @return
     */
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
        Node retNode;
        if (key.compareTo(node.key) < 0) {
            node.left = remove(node.left, key);
            retNode = node;
        } else if (key.compareTo(node.key) > 0) {
            node.right = remove(node.right, key);
            retNode = node;
        } else {
            // 待删除节点左子树为空的情况
            if (node.left == null) {
                Node rightNode = node.right;
                node.right = null;
                size--;
                retNode = rightNode;
            } else if (node.right == null) {
                // 待删除节点右子树为空的情况
                Node leftNode = node.left;
                node.left = null;
                size--;
                retNode = leftNode;
            } else {
                // 找到比待删除节点大的最小节点，即待删除节点右子树的最小节点；用这个节点顶替待删除节点位置
                Node target = minimum(node.right);
                size++;
                target.right = remove(node.right, target.key);
                target.left = node.left;
                node.left = node.right = null;
                size--;
                retNode = target;
            }
        }
        if (retNode == null) {
            return null;
        }
        // 更新height
        retNode.height = 1 + Math.max(getHeight(retNode.left), getHeight(retNode.right));
        // 更新平衡因子
        int balanceFactor = getBalanceFactor(retNode);
        // LL
        if (balanceFactor > 1 && getBalanceFactor(retNode.left) >= 0) {
            return rightRotate(retNode);
        }
        // RR
        if (balanceFactor < -1 && getBalanceFactor(retNode.right) <= 0) {
            return leftRotate(retNode);
        }
        // LR
        if (balanceFactor > 1 && getBalanceFactor(retNode.left) < 0) {
            retNode.left = leftRotate(retNode.left);
            // LR - LL
            return rightRotate(retNode);
        }
        // RL
        if (balanceFactor < -1 && getBalanceFactor(retNode.right) > 0) {
            retNode.right = rightRotate(retNode.right);
            // RL - RR
            return leftRotate(retNode);
        }
        return retNode;
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
     * 获取节点个数
     *
     * @return
     */
    public int getSize() {
        return this.size;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    /**
     * 获取节点高度
     *
     * @param node
     * @return
     */
    private int getHeight(Node node) {
        if (node == null) {
            return 0;
        }
        return node.height;
    }

    /**
     * 获取某个节点的平衡因子
     *
     * @param node
     * @return
     */
    private int getBalanceFactor(Node node) {
        if (node == null) {
            return 0;
        }
        return getHeight(node.left) - getHeight(node.right);
    }

    /**
     * 判断当前二叉树是否是一颗二分搜索树
     *
     * @return
     */
    public boolean isBST() {
        ArrayList<K> keys = new ArrayList<>();
        inOrder(root, keys);
        for (int i = 1; i < keys.size(); i++) {
            if (keys.get(i - 1).compareTo(keys.get(i)) > 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * 中序遍历(遍历顺序:左子树-根节点-右子树)
     *
     * @param node 根节点
     * @param keys
     */
    private void inOrder(Node node, ArrayList<K> keys) {
        if (node == null) {
            return;
        }
        inOrder(node.left, keys);
        keys.add(node.key);
        inOrder(node.right, keys);
    }

    /**
     * 判断二叉树是否是一个平衡二叉树
     *
     * @return
     */
    public boolean isBalance() {
        return isBalance(root);
    }

    private boolean isBalance(Node node) {
        if (node == null) {
            return true;
        }
        // 判断当前节点
        int balanceFactor = getBalanceFactor(node);
        if (Math.abs(balanceFactor) > 1) {
            return false;
        }
        // 判断当前节点的左子节点和右子节点
        return isBalance(node.left) && isBalance(node.right);
    }
}
