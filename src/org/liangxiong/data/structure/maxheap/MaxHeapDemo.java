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
        MaxHeap<Integer> maxHeap = new MaxHeap<>();
        int size = 10000;
        Random random = new Random();
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
}
