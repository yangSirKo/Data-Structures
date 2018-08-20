package com.ccyang.stack.util;

/**
 * @author ccyang
 * @date 2018/8/20 21:39
 * 使用自己的 ArrayStack
 */
public class Solution20 {

    public boolean isValid(String s){

        ArrayStack<Character> stack = new ArrayStack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '[' || c == '{')
                stack.push(c);
            else {
                if(stack.isEmpty())
                    return false;

                char topChar = stack.pop();
                if( c == ')' && topChar != '(')
                    return false;
                if( c == ']' && topChar != '[')
                    return false;
                if( c == '}' && topChar != '{')
                    return false;
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {

        boolean b = new Solution20().isValid("{}[]");
        boolean b2 = new Solution20().isValid("{}[(])");
        System.out.println(b);
        System.out.println(b2);
    }

}
