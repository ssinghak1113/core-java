package com.kkd.ds;

import java.util.Scanner;
import java.util.Stack;

public class QueueUsingTwoStacks {

    private static Stack<Integer> stack = new Stack<>();
    private static Stack<Integer> tempStack = new Stack<>();

    public static void main(String[] args) {

        try (Scanner sc = new Scanner(System.in)) {

            int n = sc.nextInt();
            while (n != 0) {
                n--;

                int q = sc.nextInt();
                if (q == 1) {
                    enque(sc.nextInt());
                } else if (q == 2) {
                    deque();
                } else if (q == 3) {
                    print();
                }
            }
        }
    }

    private static void enque(int num) {
        
        int size = stack.size();
        tempStack.clear();
        while (size != 0) {
            tempStack.push(stack.pop());
            size--;
        }
        
        stack.push(num);
        
        size = tempStack.size();
        while (size != 0) {
            stack.push(tempStack.pop());
            size--;
        }
    }

    private static void deque() {
        if(stack.isEmpty()){
            return;
        }
        stack.pop();
    }

    private static void print() {
        if(stack.isEmpty()){
            return;
        }
        System.out.println(stack.peek());
    }
}
