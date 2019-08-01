package org.liangxiong.data.structure.array;

/**
 * @author liangxiong
 * @Date:2019-07-24
 * @Time:09:43
 * @Description 数组封装
 */
public class Array<E> {

    /**
     * 存储数据
     */
    private E[] data;

    /**
     * 数组中元素个数
     */
    private int size;

    /**
     * 初始化数组(指定容量和元素个数)
     *
     * @param capacity 数组容量
     */
    public Array(int capacity) {
        data = (E[]) new Object[capacity];
        size = 0;
    }

    /**
     * 默认构造器
     */
    public Array() {
        this(10);
    }

    /**
     * 获取元素个数
     *
     * @return 元素个数
     */
    public int getSize() {
        return this.size;
    }

    /**
     * 获取数组容量
     *
     * @return
     */
    public int getCapacity() {
        return this.data.length;
    }

    /**
     * 判断数组是否为空
     *
     * @return 判断结果
     */
    public boolean isEmpty() {
        return this.size == 0;
    }

    /**
     * 尾部添加元素
     *
     * @param e 待添加元素
     */
    public void addLast(E e) {
        add(size, e);
    }

    /**
     * 头部添加元素
     *
     * @param e 待添加元素
     */
    public void addFirst(E e) {
        add(0, e);
    }

    /**
     * 制定位置添加元素
     *
     * @param index 索引位置
     * @param e     元素
     */
    public void add(int index, E e) {
        // 参数错误
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("index illegal");
        }
        // 数组容量不足
        if (size == data.length) {
            // 数组扩容
            resize(2 * data.length);
        }
        // 元素向后移动1位
        for (int i = size - 1; i >= index; i--) {
            data[i + 1] = data[i];
        }
        data[index] = e;
        size++;
    }

    /**
     * 数组扩容
     *
     * @param newCapacity 容量
     */
    private void resize(int newCapacity) {
        E[] newData = (E[]) new Object[newCapacity];
        for (int i = 0; i < size; i++) {
            newData[i] = data[i];
        }
        data = newData;
    }

    /**
     * 获取元素
     *
     * @param index 索引
     * @return
     */
    public E get(int index) {
        // 参数错误
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("index illegal");
        }
        return data[index];
    }

    /**
     * 获取第一个元素
     *
     * @return
     */
    public E getFirst() {
        return get(0);
    }

    /**
     * 获取最后一个元素
     *
     * @return
     */
    public E getLast() {
        return get(size - 1);
    }

    /**
     * 修改元素
     *
     * @param index 索引
     * @param e     元素
     */
    public void set(int index, E e) {
        // 参数错误
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("index illegal");
        }
        data[index] = e;
    }

    /**
     * 判断是否包含元素
     *
     * @param e 元素
     * @return
     */
    public boolean contains(E e) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e)) {
                return true;
            }
        }
        return false;
    }

    /**
     * 获取元素的索引
     *
     * @param e 元素
     * @return
     */
    public int indexOf(E e) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e)) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 删除制定位置元素
     *
     * @param index 索引
     * @return 被删除的元素
     */
    public E remove(int index) {
        // 参数错误
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("index illegal");
        }
        E deletedElement = data[index];
        // 数组元素往前移动
        for (int i = index; i < size - 1; i++) {
            data[i] = data[i + 1];
        }
        size--;
        // 帮助垃圾回收
        data[size] = null;
        // 数组缩容
        int newCapacity = data.length / 4;
        if (newCapacity != 0 && size == newCapacity) {
            // 防止size因为addFirst和addLast频繁调用导致频繁调整容量
            resize(newCapacity * 2);
        }
        return deletedElement;
    }

    /**
     * 删除第一个元素
     *
     * @return
     */
    public E removeFirst() {
        return remove(0);
    }

    /**
     * 删除最后一个元素
     *
     * @return
     */
    public E removeLast() {
        return remove(size - 1);
    }

    /**
     * 删除指定元素
     *
     * @param e 元素
     */
    public boolean removeElement(E e) {
        int index = indexOf(e);
        if (index != -1) {
            remove(index);
            return true;
        }
        return false;
    }

    /**
     * 交换两个索引位置的值
     *
     * @param from 待交换索引
     * @param to   目标索引
     */
    public void swap(int from, int to) {
        if (from < 0 || from >= size || to < 0 || 0 >= size) {
            throw new IllegalArgumentException("index illegal");
        }
        E source = data[from];
        data[from] = data[to];
        data[to] = source;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append(String.format("Array: size = %d, capacity = %d\n", size, data.length));
        result.append("[");
        for (int i = 0; i < size; i++) {
            result.append(data[i]);
            if (i != size - 1) {
                result.append(", ");
            } else {
                result.append("]");
            }
        }
        return result.toString();
    }
}
