package org.liangxiong.data.structure.trie;

import java.util.TreeMap;

/**
 * @author liangxiong
 * @Date:2019-08-03
 * @Time:21:43
 * @Description 字典树，前缀树(多叉树)
 */
public class Trie {

    /**
     * 节点
     */
    private class Node {

        /**
         * 是否表示一个单词
         */
        public boolean isWord;

        /**
         * 下一个节点的引用
         */
        public TreeMap<Character, Node> next;

        public Node(boolean isWord) {
            this.isWord = isWord;
            this.next = new TreeMap<>();
        }

        public Node() {
            this(false);
        }
    }

    /**
     * 字典树根节点
     */
    private Node root;

    /**
     * 节点个数
     */
    private int size;

    public Trie() {
        this.root = new Node();
        this.size = 0;
    }

    /**
     * 向字典树添加一个单词
     *
     * @param word
     */
    public void add(String word) {
        Node cur = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (cur.next.get(c) == null) {
                cur.next.put(c, new Node());
            }
            cur = cur.next.get(c);
        }
        if (!cur.isWord) {
            // 避免重复添加
            cur.isWord = true;
            size++;
        }
    }

    /**
     * 判断字典树是否包含某个单词
     *
     * @param word 待查询单词
     * @return
     */
    public boolean contains(String word) {
        Node cur = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (cur.next.get(c) == null) {
                return false;
            }
            cur = cur.next.get(c);
        }
        return cur.isWord;
    }

    /**
     * 判断前缀是否存在(单词是自身的前缀)
     *
     * @param prefix 前缀
     * @return
     */
    public boolean isPrefix(String prefix) {
        Node cur = root;
        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            if (cur.next.get(c) == null) {
                return false;
            }
            cur = cur.next.get(c);
        }
        return true;
    }

    /**
     * 获取节点个数
     *
     * @return
     */
    public int getSize() {
        return size;
    }
}
