package com.kkd.leetcode.queuesnstacks;

import java.util.Stack;

public class MinStack {

    Stack<Long> stack = new Stack<>();
    Long min = Long.MAX_VALUE;

    public MinStack() {

    }

    public void push(int value) {
        Long val = (long) value;
        if(stack.isEmpty()){
            stack.push(val);
            min = val;
        }else{
            if(val < min)   {
                stack.push(2*val - min);
                min = val;
            }else{
                stack.push(val);
            }
        }
    }

    public void pop() {
        if(stack.isEmpty()){
            return;
        }
        Long topStack = stack.pop();
        if(topStack < min){
            min = (2*min - topStack);
        }
    }

    public int top() {
        if(stack.isEmpty()){
            return -1;
        }
        Long topStack = stack.peek();
        if(topStack < min){
            return min.intValue();
        }
        return topStack.intValue();
    }

    public int getMin() {
        return min.intValue();
    }
}
