package org.liangxiong.data.structure.leetcode;

import java.util.Set;
import java.util.TreeSet;

/**
 * @author liangxiong
 * @Date:2019-07-30
 * @Time:10:40
 * @Description leetcode 804号问题
 */
public class MorseRepresentation {

    /**
     * 二十六个英文单词对应地莫尔斯密码
     */
    private static String[] codes = {".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.."};

    /**
     * 将单词生成莫尔斯密码
     *
     * @param words 单词数组
     * @return
     */
    private static Set<String> uniqueMorseRepresentations(String[] words) {
        TreeSet<String> set = new TreeSet<>();
        for (String word : words) {
            StringBuilder result = new StringBuilder();
            for (int i = 0; i < word.length(); i++) {
                result.append(codes[word.charAt(i) - 'a']);
            }
            set.add(result.toString());
        }
        return set;
    }

    public static void main(String[] args) {
        String[] words = {"hello", "world"};
        System.out.println(uniqueMorseRepresentations(words));
    }
}
