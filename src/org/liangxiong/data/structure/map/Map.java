package org.liangxiong.data.structure.map;

/**
 * @author liangxiong
 * @Date:2019-07-30
 * @Time:11:08
 * @Description 映射定义
 */
public interface Map<K, V> {

    /**
     * 新增
     *
     * @param key   键
     * @param value 值
     */
    void add(K key, V value);

    /**
     * 删除
     *
     * @param key 键
     * @return
     */
    V remove(K key);

    /**
     * 判断是否包含key
     *
     * @param key 键
     * @return
     */
    boolean contains(K key);

    /**
     * 获取指定key的值
     *
     * @param key 键
     * @return
     */
    V get(K key);

    /**
     * 修改数据
     *
     * @param key   键
     * @param value 值
     */
    void set(K key, V value);

    /**
     * 获取映射中元素个数
     *
     * @return
     */
    int getSize();

    /**
     * 判断映射是否为空
     *
     * @return
     */
    boolean isEmpty();
}
