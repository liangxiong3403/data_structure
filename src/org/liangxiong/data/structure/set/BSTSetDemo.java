package org.liangxiong.data.structure.set;

/**
 * @author liangxiong
 * @Date:2019-07-29
 * @Time:21:39
 * @Description 测试BSTSet
 */
public class BSTSetDemo {

    public static void main(String[] args) {
        BSTSet bstSet = new BSTSet();
        int[] arr = {4, 6, 3, 5, 7, 1, 9, 0};
        for (int i = 0; i < arr.length; i++) {
            bstSet.add(arr[i]);
        }
        System.out.println(bstSet);
        bstSet.remove(6);
        System.out.println(bstSet);
        System.out.println("size: " + bstSet.getSize());
    }
}
