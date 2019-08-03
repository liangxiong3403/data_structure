package org.liangxiong.data.structure.trie;

/**
 * @author liangxiong
 * @Date:2019-08-03
 * @Time:22:20
 * @Description 测试Trie
 */
public class TrieDemo {

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.add("hello");
        trie.add("world");
        System.out.println(trie.contains("hello"));
        System.out.println("size: " + trie.getSize());
        System.out.println(trie.isPrefix("wor"));
    }
}
