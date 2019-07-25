package org.liangxiong.data.structure.queue;

/**
 * @author liangxiong
 * @Date:2019-07-25
 * @Time:10:30
 * @Description 测试队列
 */
public class QueueDemo {

    public static void main(String[] args) {
        Queue<Integer> queue = new ArrayQueue<>();
        int size = 10;
        for (int i = 0; i < size; i++) {
            queue.enqueue(i);
            System.out.println(queue);
            if (i % 3 == 2) {
                System.out.println("出队: " + queue.dequeue());
            }
        }
        System.out.println(queue);
    }
}
