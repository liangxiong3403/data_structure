package org.liangxiong.data.structure.queue;

/**
 * @author liangxiong
 * @Date:2019-07-25
 * @Time:10:30
 * @Description 测试队列
 */
public class QueueDemo {

    public static void main(String[] args) {
        Queue<Integer> arrayQueue = new ArrayQueue<>();
        Queue<Integer> loopQueue = new LoopQueue<>();
        int count = 100000;
        System.out.println("array queue:" + testEnqueueAndDequeue(arrayQueue, count));
        System.out.println("loop queue:" + testEnqueueAndDequeue(loopQueue, count));
    }

    /**
     * 测试单个队列
     *
     * @param queue 待测试队列
     */
    private static void testQueue(Queue<Integer> queue) {
        int size = 15;
        for (int i = 0; i < size; i++) {
            queue.enqueue(i);
            System.out.println(queue);
            if (i % 3 == 2) {
                System.out.println("出队: " + queue.dequeue());
            }
        }
        System.out.println(queue);
    }

    /**
     * 测试多个队列执行性能
     *
     * @param queue 待测试队列
     * @param count 执行次数
     * @return
     */
    private static double testEnqueueAndDequeue(Queue<Integer> queue, int count) {
        long startTime = System.nanoTime();
        for (int i = 0; i < count; i++) {
            queue.enqueue(i);
        }
        for (int i = 0; i < count; i++) {
            queue.dequeue();
        }
        long endTime = System.nanoTime();
        return (endTime - startTime) / 1000000000.0;
    }
}
