package com.kkd.leetcode.queuesnstacks;

public class CustomStack {

    int[] arr;
    int len;
    int counter = 0;
    public CustomStack(int maxSize) {
        arr = new int[maxSize];
        len = maxSize;
    }

    public void push(int x) {
        if(counter >= len){
            return;
        }
        arr[counter++] = x;
    }

    public int pop() {
        if(counter == 0) {
            return -1;
        }
        return arr[--counter];
    }

    public void increment(int k, int val) {
        if(counter==0){
            return;
        }

        if(k > len){
            k = len;
        }
        for(int i = 0; i < k; i++){
            arr[i]  = arr[i] + val;
        }
    }
}

/**
 * Your CustomStack object will be instantiated and called as such:
 * CustomStack obj = new CustomStack(maxSize);
 * obj.push(x);
 * int param_2 = obj.pop();
 * obj.increment(k,val);
 */