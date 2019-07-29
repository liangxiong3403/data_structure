package org.liangxiong.data.structure.set;

import java.util.Random;

/**
 * @author liangxiong
 * @Date:2019-07-29
 * @Time:22:12
 * @Description 测试LinkedListSet
 */
public class LinkedListSetDemo {

    public static void main(String[] args) {
        Set<Integer> linkedListSet = new LinkedListSet();
        Set<Integer> bstSet = new BSTSet<>();
        int count = 100000;
        System.out.println("linkedListSet time cost: " + testSetPerformance(linkedListSet, count));
        System.out.println("bstSet time cost: " + testSetPerformance(bstSet, count));
    }

    /**
     * 测试集合逻辑
     *
     * @param linkedListSet 基于链表实现集合
     */
    private static void testSet(Set<Integer> linkedListSet) {
        int size = 10;
        for (int i = 0; i < size; i++) {
            linkedListSet.add(i);
        }
        System.out.println(linkedListSet);
        System.out.println("size: " + linkedListSet.getSize());
        linkedListSet.remove(5);
        System.out.println(linkedListSet);
    }

    /**
     * 测试集合性能
     *
     * @param linkedListSet 基于链表实现集合
     * @param count         执行次数
     */
    private static double testSetPerformance(Set<Integer> linkedListSet, int count) {
        long startTime = System.nanoTime();
        Random random = new Random();
        for (int i = 1; i <= count; i++) {
            linkedListSet.add(random.nextInt(i));
        }
        for (int i = 1; i <= count; i++) {
            linkedListSet.remove(random.nextInt(i));
        }
        long endTime = System.nanoTime();
        return (endTime - startTime) / 1000000000.0;
    }
}
