package org.liangxiong.data.structure.maxheap;

import org.liangxiong.data.structure.array.Array;

/**
 * @author liangxiong
 * @Date:2019-08-01
 * @Time:10:37
 * @Description 最大堆(本质上是一个二叉堆)
 */
public class MaxHeap<E extends Comparable<E>> {

    /**
     * 底层数据结构
     */
    private Array<E> data;

    /**
     * 构造二叉堆
     *
     * @param capacity 容量
     */
    public MaxHeap(int capacity) {
        this.data = new Array<>(capacity);
    }

    /**
     * 堆用户输入的数组构造为堆
     *
     * @param arr
     */
    public MaxHeap(E[] arr) {
        this.data = new Array<>(arr);
        for (int i = getParentIndex(arr.length - 1); i >= 0; i--) {
            siftDown(i);
        }
    }

    public MaxHeap() {
        this.data = new Array<>();
    }

    /**
     * 获取堆中节点个数
     *
     * @return
     */
    public int getSize() {
        return this.data.getSize();
    }

    /**
     * 判断堆是否为空
     *
     * @return
     */
    public boolean isEmpty() {
        return this.data.isEmpty();
    }

    /**
     * 添加元素(sift up)
     *
     * @param e 元素
     */
    public void add(E e) {
        this.data.addLast(e);
        // 数据上浮操作
        siftUp(data.getSize() - 1);
    }

    /**
     * 比较新增元素和父节点大小,进行sift up操作
     *
     * @param index 新增元素所在索引
     */
    private void siftUp(int index) {
        // 判断新增元素和父节点大小并依次向上比较
        while (index > 0 && data.get(getParentIndex(index)).compareTo(data.get(index)) < 0) {
            // 交换两个索引的元素值
            data.swap(getParentIndex(index), index);
            // 重新计算节点索引
            index = getParentIndex(index);
        }
    }

    /**
     * 获取最大元素
     *
     * @return
     */
    public E findMax() {
        if (isEmpty()) {
            throw new IllegalStateException("heap is empty");
        }
        return data.get(0);
    }

    /**
     * 取出最大元素
     *
     * @return
     */
    public E extractMax() {
        // 获取最大值
        E e = findMax();
        // 交换最大值和最后一个元素位置
        data.swap(0, getSize() - 1);
        // 删除最后一个元素
        data.removeLast();
        // 数据下沉处理
        siftDown(0);
        return e;
    }

    /**
     * 节点向下移动
     *
     * @param index
     */
    private void siftDown(int index) {
        while (getLeftChildIndex(index) < getSize()) {
            // 左子节点的索引小于节点个数
            int j = getLeftChildIndex(index);
            // 存在右子节点并且右子节点的值大于左子节点的值
            if (j + 1 < data.getSize() && data.get(j + 1).compareTo(data.get(j)) > 0) {
                // 右子节点的索引赋值给j(便于后面获取子节点中的最大值)
                j = getRightChildIndex(index);
            }
            // data[j]是子节点中最大值
            if (data.get(index).compareTo(data.get(j)) >= 0) {
                // 节点大于子节点中的最大值
                break;
            }
            // 交换index位置的值和子节点最大值的位置
            data.swap(index, j);
            index = j;
        }
    }

    /**
     * 取出堆中元素最大值并插入新地值
     *
     * @param e 输入
     * @return
     */
    public E replace(E e) {
        // 取出最大值
        E max = findMax();
        // 新的值替换最大值
        this.data.set(0, e);
        // 下沉操作
        siftDown(0);
        return max;
    }

    /**
     * 将任意数组转为为堆结构
     */
    public void heapify() {

    }

    /**
     * 获取当前索引所在节点的父节点的索引
     *
     * @param index 索引
     * @return
     */
    private int getParentIndex(int index) {
        if (index == 0) {
            throw new IllegalArgumentException("index 0 doesn't have parent");
        }
        return (index - 1) / 2;
    }

    /**
     * 获取当前索引所在节点的左子节点的索引
     *
     * @param index 索引
     * @return
     */
    private int getLeftChildIndex(int index) {
        return index * 2 + 1;
    }

    /**
     * 获取当前索引所在节点的右子节点的索引
     *
     * @param index 索引
     * @return
     */
    private int getRightChildIndex(int index) {
        return index * 2 + 2;
    }
}
