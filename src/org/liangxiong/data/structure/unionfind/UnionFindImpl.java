package org.liangxiong.data.structure.unionfind;

/**
 * @author liangxiong
 * @Date:2019-08-04
 * @Time:10:51
 * @Description 实现并查集，quick find
 */
public class UnionFindImpl implements UnionFind {

    /**
     * 底层数据结构
     */
    private int[] ids;

    public UnionFindImpl(int size) {
        this.ids = new int[size];
        for (int i = 0; i < size; i++) {
            // 默认每个索引位置存储值为索引编号
            ids[i] = i;
        }
    }

    /**
     * 查询元素p和元素q是否属于同一个集合
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
     * 合并两个元素
     *
     * @param p
     * @param q
     */
    @Override
    public void union(int p, int q) {
        int i = find(p);
        int j = find(q);
        if (i == j) {
            return;
        }
        for (int k = 0; k < ids.length; k++) {
            if (ids[k] == i) {
                ids[k] = j;
            }
        }
    }

    /**
     * 获取元素个数
     *
     * @return
     */
    @Override
    public int getSize() {
        return this.ids.length;
    }

    /**
     * 查询元素的集合编号
     *
     * @param p
     * @return
     */
    private int find(int p) {
        if (p < 0 || p >= ids.length) {
            throw new IllegalArgumentException("index is illegal");
        }
        return ids[p];
    }
}
