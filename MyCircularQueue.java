package com.kkd.leetcode.queuesnstacks;

public class MyCircularQueue {

    int[] arr;
    int head = -1;
    int tail = -1;
    int dataCounter = 0;
    int maxSize;

    public MyCircularQueue(int k) {
        arr = new int[k];
        maxSize = k;
    }

    public boolean enQueue(int value) {
        if (isFull()) {
            return false;
        }
        if (isEmpty()) {
            head++;
        }
        tail++;
        dataCounter++;

        if (tail >= maxSize) {
            tail = 0;
        }
        arr[tail] = value;
        return true;
    }

    public boolean deQueue() {
        if (isEmpty()) {
            return false;
        }

        dataCounter--;
        if (isEmpty()){
            head = -1;
            tail = -1;
        }else {
            head++;
            if (head >= maxSize) {
                head = 0;
            }
        }
        return true;
    }

    public int Front() {
        if(head == -1){
            return -1;
        }
        return arr[head];
    }

    public int Rear() {
        if(tail == -1){
            return -1;
        }
        return arr[tail];
    }

    public boolean isEmpty() {
        return dataCounter == 0;
    }

    public boolean isFull() {
        return dataCounter == maxSize;
    }
}
