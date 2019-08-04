package org.liangxiong.data.structure.unionfind;

/**
 * @author liangxiong
 * @Date:2019-08-04
 * @Time:16:19
 * @Description 并查集实现方式3
 */
public class UnionFindImpl3 implements UnionFind {


    /**
     * 底层数据结构，子节点指向父节点
     */
    private int[] parent;

    /**
     * rank[i]表示以i为根的集合所表示的树的层数
     */
    private int[] rank;

    public UnionFindImpl3(int size) {
        this.parent = new int[size];
        this.rank = new int[size];
        for (int i = 0; i < size; i++) {
            // 每个节点默认的parent指向自己
            parent[i] = i;
            // 默认深度为1
            rank[i] = 1;
        }
    }

    /**
     * 判断元素是否链接(O(h))
     *
     * @param p
     * @param q
     * @return
     */
    @Override
    public boolean isConnected(int p, int q) {
        return find(p) == find(q);
    }

    /**
     * 求两个元素并集
     *
     * @param p
     * @param q
     */
    @Override
    public void union(int p, int q) {
        int pRoot = find(p);
        int qRoot = find(q);
        if (pRoot == qRoot) {
            return;
        }
        if (rank[pRoot] < rank[qRoot]) {
            parent[pRoot] = qRoot;
        } else if (rank[qRoot] < rank[pRoot]) {
            parent[qRoot] = pRoot;
        } else {
            parent[qRoot] = pRoot;
            rank[pRoot] += 1;
        }
    }

    /**
     * 查找元素(O(h)复杂度)
     *
     * @param p
     * @return
     */
    private int find(int p) {
        if (p < 0 || p >= parent.length) {
            throw new IllegalArgumentException("index is illegal");
        }
        while (p != parent[p]) {
            // 当前节点的父节点不是指向自己(默认指向自己),则依次向上遍历
            p = parent[p];
        }
        return p;
    }

    @Override
    public int getSize() {
        return this.parent.length;
    }
}
