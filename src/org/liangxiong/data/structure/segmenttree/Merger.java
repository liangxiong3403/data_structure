package org.liangxiong.data.structure.segmenttree;

/**
 * @author liangxiong
 * @Date:2019-08-03
 * @Time:15:40
 * @Description 融合器
 */
public interface Merger<E> {

    /**
     * 两个元素合并为一个元素
     *
     * @param a
     * @param b
     * @return
     */
    E merge(E a, E b);
}
