package org.liangxiong.data.structure.unionfind;

import java.util.Random;

/**
 * @author liangxiong
 * @Date:2019-08-04
 * @Time:15:35
 * @Description 测试UnionFind
 */
public class UnionFindDemo {

    public static void main(String[] args) {
        int size = 100000;
        int count = 100000;
        UnionFind unionFind1 = new UnionFindImpl(size);
        UnionFind unionFind2 = new UnionFindImpl2(size);
        UnionFind unionFind3 = new UnionFindImpl3(size);
        UnionFind unionFind4 = new UnionFindImpl4(size);
        UnionFind unionFind5 = new UnionFindImpl5(size);
        System.out.println("unionFind1 cost time: " + testUnionFind(unionFind1, count));
        System.out.println("unionFind2 cost time: " + testUnionFind(unionFind2, count));
        System.out.println("unionFind3 cost time: " + testUnionFind(unionFind3, count));
        System.out.println("unionFind4 cost time: " + testUnionFind(unionFind4, count));
        System.out.println("unionFind5 cost time: " + testUnionFind(unionFind5, count));
    }

    /**
     * 测试并查集性能
     *
     * @param unionFind
     * @param count
     * @return
     */
    private static double testUnionFind(UnionFind unionFind, int count) {
        int size = unionFind.getSize();
        Random random = new Random();
        long startTime = System.nanoTime();
        for (int i = 0; i < count; i++) {
            int a = random.nextInt(size);
            int b = random.nextInt(size);
            unionFind.union(a, b);
        }
        for (int i = 0; i < count; i++) {
            int a = random.nextInt(size);
            int b = random.nextInt(size);
            unionFind.isConnected(a, b);
        }
        long endTime = System.nanoTime();
        return (endTime - startTime) / 1000000000.0;
    }
}
