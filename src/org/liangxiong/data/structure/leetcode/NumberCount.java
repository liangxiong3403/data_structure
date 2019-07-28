package org.liangxiong.data.structure.leetcode;

/**
 * @author liangxiong
 * @Date:2019-07-28
 * @Time:20:48
 * @Description 递归思想应用
 */
public class NumberCount {

    public static int sum(int[] arr) {
        return sum(arr, 0);
    }

    /**
     * 数组求和
     *
     * @param arr 输入
     * @param i   索引
     * @return
     */
    private static int sum(int[] arr, int i) {
        if (i == arr.length) {
            // 数组无需遍历
            return 0;
        } else {
            return arr[i] + sum(arr, i + 1);
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6};
        System.out.println("sum: " + sum(arr));
    }
}
