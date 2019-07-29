package org.liangxiong.data.structure.set;

import org.liangxiong.data.structure.bst.BST;

/**
 * @author liangxiong
 * @Date:2019-07-29
 * @Time:20:34
 * @Description 基于二分搜索树实现集合
 */
public class BSTSet<E extends Comparable<E>> implements Set<E> {

    /**
     * 底层数据结构
     */
    private BST<E> bst;

    public BSTSet() {
        this.bst = new BST<>();
    }

    @Override
    public void add(E e) {
        // 当前BST不能存储重复值
        this.bst.add(e);
    }

    @Override
    public void remove(E e) {
        this.bst.remove(e);
    }

    @Override
    public boolean contains(E e) {
        return this.bst.contains(e);
    }

    @Override
    public int getSize() {
        return this.bst.getSize();
    }

    @Override
    public boolean isEmpty() {
        return this.bst.isEmpty();
    }

    @Override
    public String toString() {
        return this.bst.toString();
    }
}
