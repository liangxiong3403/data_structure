package org.liangxiong.data.structure.segmenttree;

import java.util.Arrays;

/**
 * @author liangxiong
 * @Date:2019-08-03
 * @Time:14:50
 * @Description 线段树
 */
public class SegmentTree<E> {

    /**
     * 底层数据结构
     */
    private E[] data;

    /**
     * 模拟线段树
     */
    private E[] tree;

    /**
     * 融合器
     */
    private Merger<E> merger;

    /**
     * 构造函数(如果区间有n个元素，数组最多需要4n空间)
     *
     * @param input 输入
     */
    public SegmentTree(E[] input, Merger<E> merger) {
        this.data = Arrays.copyOf(input, input.length);
        this.tree = (E[]) new Object[input.length * 4];
        this.merger = merger;
        buildSegmentTree(0, 0, data.length - 1);
    }

    /**
     * 查询某个区间地元素
     *
     * @param start 区间开始索引
     * @param end   区间结束索引
     * @return
     */
    public E query(int start, int end) {
        checkIndex(start);
        checkIndex(end);
        if (start > end) {
            throw new IllegalArgumentException("start index bigger than end index");
        }
        return query(0, 0, data.length - 1, start, end);
    }

    /**
     * 更新数据
     *
     * @param index 索引
     * @param e     元素
     * @return
     */
    public void set(int index, E e) {
        checkIndex(index);
        data[index] = e;
        set(0, 0, data.length - 1, index, e);
    }

    /**
     * 在以root为根节点索引地线段树的[left, right]区间中更新数据
     *
     * @param root  根节点索引
     * @param left  起始节点索引
     * @param right 结束节点索引
     * @param index 需要修改的索引
     * @param e     修改值
     */
    private void set(int root, int left, int right, int index, E e) {
        if (left == right) {
            tree[root] = e;
            return;
        }
        int middle = left + (right - left) / 2;
        int leftChildIndex = getLeftChildIndex(root);
        int rightChildIndex = getRightChildIndex(root);
        if (index >= middle + 1) {
            set(rightChildIndex, middle + 1, right, index, e);
        } else {
            set(leftChildIndex, left, middle, index, e);
        }
        tree[root] = merger.merge(tree[leftChildIndex], tree[leftChildIndex]);
    }

    /**
     * 获取指定索引位置处地元素
     *
     * @param index 索引
     * @return
     */
    public E get(int index) {
        checkIndex(index);
        return data[index];
    }

    /**
     * 获取线段树节点个数
     *
     * @return
     */
    public int getSize() {
        return this.data.length;
    }

    /**
     * 构建线段树
     *
     * @param root  根索引
     * @param left  左区间起始索引
     * @param right 右区间截止索引
     */
    private void buildSegmentTree(int root, int left, int right) {
        if (left == right) {
            tree[root] = data[left];
            return;
        }
        int leftChildIndex = getLeftChildIndex(root);
        int rightChildIndex = getRightChildIndex(root);
        // 获取子节点的中间索引值
        int middle = left + (right - left) / 2;
        // 递归构建左子树
        buildSegmentTree(leftChildIndex, left, middle);
        // 递归构建右子树
        buildSegmentTree(rightChildIndex, middle + 1, right);
        // 处理根节点的值
        tree[root] = merger.merge(tree[leftChildIndex], tree[rightChildIndex]);
    }

    /**
     * 获取指定索引的左子节点的索引值
     *
     * @param input 输入
     * @return
     */
    private int getLeftChildIndex(int input) {
        return input * 2 + 1;
    }

    /**
     * 获取指定索引的右子节点的索引值
     *
     * @param input 输入
     * @return
     */
    private int getRightChildIndex(int input) {
        return input * 2 + 2;
    }

    /**
     * 校验索引合法性
     *
     * @param index 待校验参数
     */
    private void checkIndex(int index) {
        if (index < 0 || index >= data.length) {
            throw new IllegalArgumentException("index is illegal");
        }
    }

    /**
     * 在以root为根的线段树中的[left，right]的范围里,搜索区间[start, end]的值
     *
     * @param root  线段树根节点索引
     * @param left  线段树开始节点索引
     * @param right 线段树结束节点索引
     * @param start 查询起点
     * @param end   查询终点
     * @return
     */
    private E query(int root, int left, int right, int start, int end) {
        if (left == start && right == end) {
            // 用户查询范围等于线段树的范围
            return tree[root];
        }
        // 获取线段树中间节点索引
        int middle = left + (right - left) / 2;
        int leftChildIndex = getLeftChildIndex(root);
        int rightChildIndex = getRightChildIndex(root);
        if (start >= middle + 1) {
            // 用户查找的开始节点在右子树
            return query(rightChildIndex, middle + 1, right, start, end);
        } else if (end <= middle) {
            // 用户查找的结束节点在左子树
            return query(leftChildIndex, left, middle, start, end);
        }
        // 用户查找地数据同时包含左子树的节点和右子树的节点
        E leftResult = query(leftChildIndex, left, middle, start, middle);
        E rightResult = query(rightChildIndex, middle + 1, right, middle + 1, end);
        // 融合左子树查找结果和右子树查找结果
        return merger.merge(leftResult, rightResult);
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append("[");
        for (int i = 0; i < tree.length; i++) {
            if (tree[i] != null) {
                result.append(tree[i]);
            } else {
                result.append("null");
            }
            if (i != tree.length - 1) {
                result.append(", ");
            } else {
                result.append(" ]");
            }
        }
        return result.toString();
    }
}
