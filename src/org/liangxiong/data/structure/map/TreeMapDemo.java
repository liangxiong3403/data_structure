package org.liangxiong.data.structure.map;

/**
 * @author liangxiong
 * @Date:2019-07-30
 * @Time:15:44
 * @Description 测试TreeMap
 */
public class TreeMapDemo {

    public static void main(String[] args) {
        TreeMap<String, Integer> treeMap = new TreeMap<>();
        treeMap.add("china", 44);
        treeMap.add("american", 33);
        treeMap.add("japan", 22);
        treeMap.add("australian", 11);
        System.out.println(treeMap);
        System.out.println("size: " + treeMap.getSize());
        System.out.println("contains american: " + treeMap.contains("american"));
        System.out.println("search japan: " + treeMap.get("japan"));
        System.out.println("remove australian: " + treeMap.remove("australian"));
        System.out.println(treeMap);
        treeMap.set("china", 66);
        System.out.println(treeMap);
    }
}
