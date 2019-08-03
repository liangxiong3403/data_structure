package org.liangxiong.data.structure.leetcode;

import org.liangxiong.data.structure.queue.PriorityQueue;

import java.util.LinkedList;
import java.util.TreeMap;

/**
 * @author liangxiong
 * @Date:2019-08-01
 * @Time:18:52
 * @Description 获取前k个频率数据
 */
public class FrequencyCount {

    /**
     * 频率
     */
    private static class Frequency implements Comparable<Frequency> {

        /**
         * 元素
         */
        private int e;

        /**
         * 频率
         */
        private int frequency;

        public Frequency(int e, int frequency) {
            this.e = e;
            this.frequency = frequency;
        }

        @Override
        public int compareTo(Frequency target) {
            // 频次低则优先级高
            if (this.frequency < target.frequency) {
                return 1;
            } else if (this.frequency > target.frequency) {
                return -1;
            }
            return 0;
        }
    }

    /**
     * 给定一个非空的整数数组，返回其中出现频率前 k 高的元素(top-k-frequent-elements)
     *
     * @param nums
     * @param k
     */
    private static void topKFrequent(int[] nums, int k) {
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        for (int num : nums) {
            if (treeMap.containsKey(num)) {
                treeMap.put(num, treeMap.get(num) + 1);
            } else {
                treeMap.put(num, 1);
            }
        }
        System.out.println(treeMap);
        PriorityQueue<Frequency> priorityQueue = new PriorityQueue<>();
        for (Integer key : treeMap.keySet()) {
            if (priorityQueue.getSize() < k) {
                // 优先队列中元素个数不够
                priorityQueue.enqueue(new Frequency(key, treeMap.get(key)));
            } else if (treeMap.get(key) > priorityQueue.getFront().frequency) {
                // 当前元素频次高于队列中的队首元素
                priorityQueue.dequeue();
                priorityQueue.enqueue(new Frequency(key, treeMap.get(key)));
            }
        }
        LinkedList<Integer> linkedList = new LinkedList<>();
        while (!priorityQueue.isEmpty()) {
            linkedList.add(priorityQueue.dequeue().e);
        }
        System.out.println(linkedList);
        System.out.println("size: " + linkedList.size());
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 2, 3, 4, 5, 5, 5, 8};
        topKFrequent(nums, 3);
    }
}
