package org.liangxiong.data.structure.map;

/**
 * @author liangxiong
 * @Date:2019-07-30
 * @Time:12:04
 * @Description 测试LinkedListMap
 */
public class LinkedListMapDemo {

    public static void main(String[] args) {
        Map<String, Integer> linkedListMap = new LinkedListMap();
        testLinkedListMap(linkedListMap);

    }

    /**
     * 测试linkedListMap
     *
     * @param linkedListMap
     */
    private static void testLinkedListMap(Map<String, Integer> linkedListMap) {
        linkedListMap.add("lb", 44);
        linkedListMap.add("df", 33);
        linkedListMap.add("zs", 22);
        linkedListMap.add("ww", 11);
        System.out.println(linkedListMap);
        System.out.println("size: " + linkedListMap.getSize());
        System.out.println("contains df: " + linkedListMap.contains("df"));
        System.out.println("search zs: " + linkedListMap.get("zs"));
        System.out.println("remove ww: " + linkedListMap.remove("ww"));
        System.out.println(linkedListMap);
        linkedListMap.set("lb", 66);
        System.out.println(linkedListMap);
    }
}
