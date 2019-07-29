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
