package org.liangxiong.data.structure.avl;

/**
 * @author liangxiong
 * @Date:2019-07-30
 * @Time:15:44
 * @Description 测试AVLTree
 */
public class AVLTreeDemo {

    public static void main(String[] args) {
        AVLTree<String, Integer> tree = new AVLTree<>();
        tree.add("canada", 55);
        tree.add("china", 44);
        tree.add("american", 33);
        tree.add("australian", 11);
        tree.add("japan", 22);
        System.out.println(tree);
        System.out.println("size: " + tree.getSize());
        System.out.println("is bst: " + tree.isBST());
        System.out.println("is balance: " + tree.isBalance());
        tree.remove("china12");
        System.out.println("is balance: " + tree.isBalance());
    }
}
