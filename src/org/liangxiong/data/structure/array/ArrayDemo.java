package org.liangxiong.data.structure.array;

/**
 * @author liangxiong
 * @Date:2019-07-24
 * @Time:09:28
 * @Description array
 */
public class ArrayDemo {

    public static void main(String[] args) {
        Array<Integer> array = new Array<>();
        int size = 10;
        for (int i = 0; i < size; i++) {
            array.addLast(i);
        }
        System.out.println(array);

        array.add(1, 100);
        System.out.println(array);

        array.addFirst(-1);
        System.out.println(array);

        array.addLast(66);
        System.out.println(array);

        array.set(0, -2);
        System.out.println(array.get(0));

        System.out.println("是否包含: " + array.contains(5));

        System.out.println("索引: " + array.indexOf(5));

        System.out.println("删除元素: " + array.remove(2));
        System.out.println(array);

        System.out.println("是否包含100: " + array.contains(100));
        System.out.println("第一个: " + array.removeFirst());
        System.out.println("最后一个: " + array.removeLast());
        System.out.println(array);

        System.out.println(array.removeElement(8));
        System.out.println(array);

        System.out.println("capacity: " + array.getCapacity());
    }
}
