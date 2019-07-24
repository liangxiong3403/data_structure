package org.liangxiong.data.structure.stack;

/**
 * @author liangxiong
 * @Date:2019-07-24
 * @Time:20:30
 * @Description 栈
 */
public interface Stack<E> {

    /**
     * 入栈
     *
     * @param e 元素
     */
    void push(E e);

    /**
     * 出栈
     *
     * @return
     */
    E pop();

    /**
     * 获取栈顶元素
     *
     * @return
     */
    E peek();

    /**
     * 获取栈中元素个数
     *
     * @return
     */
    int getSize();

    /**
     * 判断栈是否为空
     *
     * @return
     */
    boolean isEmpty();
}
