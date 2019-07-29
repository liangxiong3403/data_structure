package org.liangxiong.data.structure.bst;

/**
 * @author liangxiong
 * @Date:2019-07-29
 * @Time:15:40
 * @Description BST测试
 */
public class BSTDemo {

    public static void main(String[] args) {
        BST<Integer> bst = new BST<>();
        int[] scores = {3, 2, 4, 5, 1, 9, 0, 8, 7, 6};
        for (int score : scores) {
            bst.add(score);
        }
        bst.preOrder();
        System.out.println("-------------------");
        bst.preOrderNR();
        System.out.println(bst);
        System.out.println("-------------------");
        bst.removeMax();
        System.out.println(bst);
        System.out.println("-------------------");
        bst.removeMin();
        System.out.println(bst);
        System.out.println("-------------------");
        bst.remove(6);
        System.out.println(bst);
    }
}
