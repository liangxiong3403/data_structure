package org.liangxiong.data.structure.stack;

/**
 * @author liangxiong
 * @Date:2019-07-24
 * @Time:20:57
 * @Description 测试栈
 */
public class StackDemo {

    public static void main(String[] args) {
        Stack<Integer> arrayStack = new ArrayStack<>();
        Stack<Integer> linkedListStack = new LinkedListStack<>();
        int count = 100000;
        System.out.println("arrayStack 执行次数: " + testStack(arrayStack, count));
        System.out.println("linkedListStack 执行次数: " + testStack(linkedListStack, count));
    }

    private static void testStack(Stack<Integer> stack) {
        int size = 10;
        for (int i = 0; i < size; i++) {
            stack.push(i);
        }
        System.out.println(stack);
        System.out.println("弹出栈顶元素: " + stack.pop());
        System.out.println("剩余元素: " + stack);
        System.out.println("查看栈顶元素: " + stack.peek());
        System.out.println("元素个数: " + stack.getSize());
    }

    /**
     * 测试基于数组实现地栈和基于链表实现地栈的性能差异(差异和数据量有关)
     *
     * @param stack 栈的实现类
     * @param count 执行次数
     * @return
     */
    private static double testStack(Stack<Integer> stack, int count) {
        long startTime = System.nanoTime();
        for (int i = 0; i < count; i++) {
            stack.push(i);
        }
        for (int i = 0; i < count; i++) {
            stack.pop();
        }
        long endTime = System.nanoTime();
        return (endTime - startTime) / 1000000000.0;
    }
}
