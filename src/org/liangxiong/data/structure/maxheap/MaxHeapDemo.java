package org.liangxiong.data.structure.maxheap;

import java.util.Random;

/**
 * @author liangxiong
 * @Date:2019-08-01
 * @Time:12:08
 * @Description 测试MaxHeap
 */
public class MaxHeapDemo {

    public static void main(String[] args) {
        int size = 10000;
        Random random = new Random();
        Integer[] data = new Integer[size];
        for (int i = 0; i < size; i++) {
            data[i] = random.nextInt(Integer.MAX_VALUE);
        }
        System.out.println("heapify cost time: " + testMaxHeapPerformance(data, true));
        System.out.println("normal cost time: " + testMaxHeapPerformance(data, false));
    }

    /**
     * 测试堆常规操作
     */
    private static void testMaxHeap(Random random, int size) {
        MaxHeap<Integer> maxHeap = new MaxHeap<>();
        for (int i = 0; i < size; i++) {
            maxHeap.add(random.nextInt(Integer.MAX_VALUE));
        }
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = maxHeap.extractMax();
        }
        for (int i = 1; i < size; i++) {
            if (arr[i - 1] < arr[i]) {
                throw new IllegalArgumentException("error");
            }
        }
        System.out.println("max heap execute success");
    }

    /**
     * 测试普通方式和heapify的性能差异
     *
     * @param data      测试数据
     * @param isHeapify 是否使用heapify
     * @return
     */
    private static double testMaxHeapPerformance(Integer[] data, boolean isHeapify) {
        long startTime = System.nanoTime();
        int size = data.length;
        MaxHeap<Integer> maxHeap;
        if (isHeapify) {
            maxHeap = new MaxHeap<>(data);
        } else {
            maxHeap = new MaxHeap<>(size);
            for (int i = 0; i < size; i++) {
                maxHeap.add(data[i]);
            }
        }
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = maxHeap.extractMax();
        }
        for (int i = 1; i < size; i++) {
            if (arr[i - 1] < arr[i]) {
                throw new IllegalArgumentException("error");
            }
        }
        long endTime = System.nanoTime();
        return (endTime - startTime) / 1000000000.0;
    }
}
