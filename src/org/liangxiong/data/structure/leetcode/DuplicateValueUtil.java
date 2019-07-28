package org.liangxiong.data.structure.leetcode;

/**
 * @author liangxiong
 * @Date:2019-07-28
 * @Time:15:39
 * @Description 重复值处理工具类
 */
public class DuplicateValueUtil {

    private static class ListNode {

        /**
         * 具体值
         */
        int value;

        /**
         * 下一个节点
         */
        ListNode next;

        /**
         * 构造器
         *
         * @param value
         */
        ListNode(int value, ListNode next) {
            this.value = value;
            this.next = next;
        }

        ListNode(int value) {
            this(value, null);
        }

        ListNode(int[] arr) {
            if (arr == null || arr.length == 0) {
                throw new IllegalArgumentException("array is empty");
            }
            this.value = arr[0];
            ListNode cur = this;
            for (int i = 1; i < arr.length; i++) {
                cur.next = new ListNode(arr[i]);
                cur = cur.next;
            }
        }

        @Override
        public String toString() {
            StringBuilder result = new StringBuilder();
            result.append("list node: [");
            ListNode cur = this;
            while (cur != null) {
                result.append(cur.value);
                if (cur.next != null) {
                    result.append(", ");
                } else {
                    result.append(" ]");
                }
                cur = cur.next;
            }
            return result.toString();
        }
    }

    /**
     * 删除多个重复值
     *
     * @param head  头节点
     * @param value 重复值
     * @return
     */
    public static ListNode removeElements(ListNode head, int value) {
        while (head != null && head.value == value) {
            // 头节点不为空且头节点的值等于输入地重复值
            ListNode delNode = head;
            head = delNode.next;
            delNode.next = null;
        }
        if (head == null) {
            return null;
        }
        ListNode prev = head;
        // 从头节点的下一个节点开始遍历
        while (prev.next != null) {
            if (prev.next.value == value) {
                ListNode delNode = prev.next;
                prev.next = delNode.next;
                delNode.next = null;
            } else {
                prev = prev.next;
            }
        }
        return head;
    }

    /**
     * 删除多个重复值(通过虚拟头节点)
     *
     * @param head  头节点
     * @param value 重复值
     * @return
     */
    public static ListNode removeElementsByDummyHead(ListNode head, int value) {
        // 构造虚拟头节点
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode prev = dummyHead;
        // 从头节点开始遍历
        while (prev.next != null) {
            if (prev.next.value == value) {
                prev.next = prev.next.next;
            } else {
                prev = prev.next;
            }
        }
        return head;
    }

    public static void main(String[] args) {
        int[] arr = {1, 1, 2, 3, 3, 4, 5, 5, 3};
        ListNode listNode = new ListNode(arr);
        System.out.println(removeElementsByDummyHead(listNode, 5));
        System.out.println(removeElements(listNode, 5));
        System.out.println(removeElements(listNode, 5));
    }
}
