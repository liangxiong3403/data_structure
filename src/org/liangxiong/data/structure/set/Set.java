package org.liangxiong.data.structure.set;

/**
 * @author liangxiong
 * @Date:2019-07-29
 * @Time:20:31
 * @Description 集合接口定义
 */
public interface Set<E> {

    /**
     * 新增元素
     *
     * @param e
     */
    void add(E e);

    /**
     * 删除元素
     *
     * @param e
     */
    void remove(E e);

    /**
     * 是否包含元素
     *
     * @param e
     * @return
     */
    boolean contains(E e);

    /**
     * 获取元素个数
     *
     * @return
     */
    int getSize();

    /**
     * 判断集合是否为空
     *
     * @return
     */
    boolean isEmpty();
}
