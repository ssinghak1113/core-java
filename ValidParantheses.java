package com.kkd.leetcode.queuesnstacks;

import java.util.HashMap;
import java.util.Stack;

public class ValidParantheses {

    public boolean isValid(String s) {
        int a = 0;
        Stack<Character> stack = new Stack<>();
        HashMap<Character, Character> map = new HashMap<>();
        map.put('}', '{');
        map.put(')', '(');
        map.put(']', '[');

        while (a <= s.length() - 1) {
            char val = s.charAt(a);
            switch (val) {
                case '{':
                case '(':
                case '[':
                    stack.push(val);
                    break;
                case '}':
                case ')':
                case ']':
                    if(stack.isEmpty()){
                        return false;
                    }
                    if(map.get(val).equals(stack.peek())){
                        stack.pop();
                    }else{
                        return false;
                    }
            }
            a++;

        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        ValidParantheses v = new ValidParantheses();
        //  v.isValid("{{}[][[[]]]}");
        //v.isValid("{{({})}}");
        v.isValid("()");
    }
}
