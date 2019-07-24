package org.liangxiong.data.structure.stack;

/**
 * @author liangxiong
 * @Date:2019-07-24
 * @Time:21:15
 * @Description 检查括号
 */
public class CheckBracket {

    /**
     * 判断字符串中包含的括号是否合法
     *
     * @param input 字符串输入值
     * @return
     */
    private static boolean isValid(String input) {
        Stack<Character> stack = new ArrayStack<>();
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (c == '(' || c == '[' || c == '{' || c == '<') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                Character topElement = stack.pop();
                if (c == ')' && topElement != '(') {
                    return false;
                }
                if (c == ']' && topElement != '[') {
                    return false;
                }
                if (c == '}' && topElement != '{') {
                    return false;
                }
                if (c == '>' && topElement != '<') {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(isValid("([{}<])>"));
        System.out.println(isValid("([{}<>])"));
    }
}
