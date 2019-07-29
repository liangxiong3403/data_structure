package org.liangxiong.data.structure.linkedlist;

/**
 * @author liangxiong
 * @Date:2019-07-26
 * @Time:23:05
 * @Description 测试LinkedList
 */
public class LinkedListDemo {

    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.addFirst(1);
        linkedList.addLast(3);
        linkedList.add(1, 2);
        linkedList.addLast(4);
        System.out.println(linkedList);
        linkedList.set(2, 666);
        System.out.println(linkedList.contains(666));
        System.out.println(linkedList);
        System.out.println("remove element: " + linkedList.remove(2));
        System.out.println(linkedList);
        linkedList.removeElement(2);
        System.out.println(linkedList);
        System.out.println("size: " + linkedList.getSize());
    }
}
