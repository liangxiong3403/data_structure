package org.liangxiong.data.structure.unionfind;

/**
 * @author liangxiong
 * @Date:2019-08-04
 * @Time:10:43
 * @Description 并查集
 */
public interface UnionFind {

    /**
     * 判断两个元素是否链接
     *
     * @param p
     * @param q
     * @return
     */
    boolean isConnected(int p, int q);

    /**
     * 求两个元素的并集
     *
     * @param p
     * @param q
     */
    void union(int p, int q);

    /**
     * 获取元素个数
     *
     * @return
     */
    int getSize();
}
