package org.liangxiong.data.structure.leetcode;

/**
 * @author liangxiong
 * @Date:2019-08-03
 * @Time:19:30
 * @Description 数组区间求和(leetcode - 303)
 */
public class NumberArray {

    private int[] sum;

    public NumberArray(int[] nums) {
        sum = new int[nums.length + 1];
        sum[0] = 0;
        for (int i = 1; i < sum.length; i++) {
            sum[i] = sum[i - 1] + nums[i - 1];
        }
    }

    public int sumRange(int start, int end) {
        return sum[end + 1] - sum[start];
    }

    public static void main(String[] args) {
        NumberArray array = new NumberArray(new int[]{1, 2, 3, 4, 5, 6});
        System.out.println(array.sumRange(0, 3));
    }
}
