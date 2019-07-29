package org.liangxiong.data.structure.bst;

import org.liangxiong.data.structure.stack.LinkedListStack;
import org.liangxiong.data.structure.stack.Stack;

/**
 * @author liangxiong
 * @Date:2019-07-29
 * @Time:10:58
 * @Description binary search tree 二分搜索树(元素需要具备可比较性)
 */
public class BST<E extends Comparable<E>> {

    /**
     * 二分搜索树中的节点
     */
    private class Node {

        /**
         * 节点值
         */
        private E e;

        /**
         * 左子节点
         */
        private Node left;

        /**
         * 右子节点
         */
        private Node right;

        public Node(E e, Node left, Node right) {
            this.e = e;
            this.left = left;
            this.right = right;
        }

        public Node(E e) {
            this(e, null, null);
        }

        @Override
        public String toString() {
            return e.toString();
        }
    }

    /**
     * 根节点
     */
    private Node root;

    /**
     * 节点个数
     */
    private int size;

    public BST() {
        this.root = null;
        this.size = 0;
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
     * 判断二分搜索树是否为空
     *
     * @return
     */
    public boolean isEmpty() {
        return this.size == 0;
    }

    /**
     * 添加元素
     *
     * @param e 元素
     */
    public void add(E e) {
        this.root = add(this.root, e);
    }

    /**
     * 向以node为根节点的BST中添加节点
     *
     * @param node 根节点
     * @param e    待添加元素
     */
    private Node add(Node node, E e) {
        if (node == null) {
            size++;
            return new Node(e);
        } else if (e.compareTo(node.e) < 0) {
            // 小于根节点
            node.left = add(node.left, e);
        } else if (e.compareTo(node.e) > 0) {
            // 大于根节点
            node.right = add(node.right, e);
        }
        return node;
    }

    /**
     * 判断二分搜索树是否包含某个元素
     *
     * @param e 元素e
     * @return
     */
    public boolean contains(E e) {
        return contains(this.root, e);
    }

    /**
     * 递归查找节点
     *
     * @param node 根节点
     * @param e    待查找元素
     * @return
     */
    private boolean contains(Node node, E e) {
        if (node == null) {
            return false;
        } else if (e.compareTo(node.e) < 0) {
            return contains(node.left, e);
        } else if (e.compareTo(node.e) > 0) {
            return contains(node.right, e);
        }
        return true;
    }

    /**
     * 二分搜索树前序遍历
     */
    public void preOrder() {
        preOrder(this.root);
    }

    /**
     * 递归前序遍历
     *
     * @param node
     */
    private void preOrder(Node node) {
        if (node == null) {
            return;
        }
        System.out.println(node.e);
        preOrder(node.left);
        preOrder(node.right);
    }

    /**
     * 非递归前序遍历
     */
    public void preOrderNR() {
        Stack<Node> stack = new LinkedListStack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node cur = stack.pop();
            System.out.println(cur.e);
            if (cur.right != null) {
                stack.push(cur.right);
            }
            if (cur.left != null) {
                stack.push(cur.left);
            }
        }
    }

    /**
     * 中序遍历
     */
    public void inOrder() {
        inOrder(root);
    }

    /**
     * 中序遍历递归实现
     *
     * @param root 根节点
     */
    private void inOrder(Node root) {
        if (root == null) {
            return;
        }
        inOrder(root.left);
        System.out.println(root.e);
        inOrder(root.right);
    }

    /**
     * 后序遍历
     */
    public void postOrder() {
        postOrder(root);
    }

    /**
     * 后序遍历递归实现
     *
     * @param root 根节点
     */
    private void postOrder(Node root) {
        if (root == null) {
            return;
        }
        postOrder(root.left);
        postOrder(root.right);
        System.out.println(root.e);
    }

    /**
     * 获取二分搜索树中最小元素
     *
     * @return
     */
    public E minimum() {
        if (isEmpty()) {
            throw new IllegalArgumentException("BST is empty");
        }
        return minimum(root).e;
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
     * 获取二分搜索树中最大元素
     *
     * @return
     */
    public E maximum() {
        if (isEmpty()) {
            throw new IllegalArgumentException("BST is empty");
        }
        return maximum(root).e;
    }

    /**
     * 获取二分搜索树中最大元素所在地节点
     *
     * @param node
     * @return
     */
    private Node maximum(Node node) {
        if (node.right == null) {
            return node;
        }
        return maximum(node.right);
    }

    /**
     * 删除最小元素所在节点
     *
     * @return
     */
    public E removeMin() {
        E minimum = minimum();
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
     * 删除最大元素所在节点
     *
     * @return
     */
    public E removeMax() {
        E maximum = maximum();
        this.root = removeMax(root);
        return maximum;
    }

    /**
     * 通过根节点删除指定元素
     *
     * @param node 根节点
     * @return
     */
    private Node removeMax(Node node) {
        if (node.right == null) {
            Node leftNode = node.left;
            node.left = null;
            size--;
            return leftNode;
        }
        node.right = removeMax(node.right);
        return node;
    }

    /**
     * 删除元素
     *
     * @param e 待删除元素
     */
    public void remove(E e) {
        this.root = remove(this.root, e);
    }

    /**
     * 删除指定元素
     *
     * @param node 根节点
     * @param e    待删除元素
     * @return
     */
    private Node remove(Node node, E e) {
        if (node == null) {
            return null;
        }
        if (e.compareTo(node.e) < 0) {
            node.left = remove(node.left, e);
            return node;
        } else if (e.compareTo(node.e) > 0) {
            node.right = remove(node.right, e);
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
            Node target = new Node(minimum(node.right).e);
            size++;
            target.right = removeMin(node.right);
            target.left = node.left;
            node.left = node.right = null;
            size--;
            return target;
        }
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        generateString(root, 0, result);
        return result.toString();
    }

    /**
     * 生产打印字符串
     *
     * @param root   根节点
     * @param depth  遍历深度
     * @param result 字符串
     */
    private void generateString(Node root, int depth, StringBuilder result) {
        if (root == null) {
            return;
        }
        for (int i = 0; i < depth; i++) {
            result.append("-");
        }
        result.append(root.e + ", depth: " + depth + "\n");
        generateString(root.left, depth + 1, result);
        generateString(root.right, depth + 1, result);
    }
}
