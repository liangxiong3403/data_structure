package org.liangxiong.data.structure.stack;

/**
 * @author liangxiong
 * @Date:2019-07-24
 * @Time:20:57
 * @Description 测试栈
 */
public class StackDemo {

    public static void main(String[] args) {
        ArrayStack<Integer> arrayStack = new ArrayStack<>();
        int size = 10;
        for (int i = 0; i < size; i++) {
            arrayStack.push(i);
        }
        System.out.println(arrayStack);
        System.out.println("栈顶元素: " + arrayStack.pop());
        System.out.println("剩余元素: " + arrayStack);
    }
}
