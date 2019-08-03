package org.liangxiong.data.structure.segmenttree;

/**
 * @author liangxiong
 * @Date:2019-08-03
 * @Time:15:51
 * @Description 测试SegmentTree
 */
public class SegmentTreeDemo {

    public static void main(String[] args) {
        Integer[] data = {1, 2, 3, 4, 5, 6, 7, 8};
        // 构造线段树，融合函数底层是求和逻辑
        SegmentTree<Integer> segmentTree = new SegmentTree<>(data, (Integer a, Integer b) -> a + b);
        System.out.println(segmentTree);
        // 求0～2区间的元素求和
        System.out.println(segmentTree.query(0, 7));
        segmentTree.set(2, 5);
        System.out.println(segmentTree);
        System.out.println(segmentTree.query(0, 7));
    }
}
