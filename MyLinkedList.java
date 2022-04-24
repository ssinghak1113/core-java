package com.kkd.leetcode.linkedlist;

public class MyLinkedList {

    int val;
    private MyLinkedList next;
    private MyLinkedList prev;
    private MyLinkedList head;

    public MyLinkedList() {

    }

    public int get(int index) {
        MyLinkedList node = head;
        while(index != 0){
            if(node == null){
                return -1;
            }
            node= node.next;
            index--;
        }

        if(null != node){
            return node.val;
        }

        return -1;
    }

    public void addAtHead(int val) {
        MyLinkedList node = new MyLinkedList();
        node.val = val;
        node.next = head;
        if(head != null) {
            head.prev = node;
        }
        head = node; // assign head to new node
    }

    public void addAtTail(int val) {
        MyLinkedList newNode = new MyLinkedList();
        newNode.val = val;

        if(null == head){
            head = newNode;
            return;
        }
        MyLinkedList currNode = head;

        while(currNode.next != null){
            currNode = currNode.next;
        }

        currNode.next = newNode;
        newNode.prev = currNode;
    }

    public void addAtIndex(int index, int val) {
        MyLinkedList newNode = new MyLinkedList();
        newNode.val = val;

        if(index == 0){
            newNode.next = head;
            head = newNode;
            return;
        }

        MyLinkedList currNode = head;
        for(int i = 0; i < index-1 && currNode!=null ; i++ ){
            currNode = currNode.next;
        }

        if(currNode == null){
            return;
        }

        if(currNode.next == null){
            currNode.next = newNode;
        }else {
            MyLinkedList temp = currNode.next;
            temp.prev = newNode;
            newNode.next = currNode.next;
            currNode.next = newNode;
            newNode.prev = currNode;
        }
    }

    public void deleteAtIndex(int index) {
        if(null == head){
            return;
        }
        if(index == 0){
            head = head.next;
            if(null != head) {
                head.prev = null;
            }
            return;
        }
        MyLinkedList prevNode = head;
        for(int i = 0; i< index-1 && prevNode != null; i++){
            prevNode = prevNode.next;
        }

        if(prevNode == null || prevNode.next == null){
            return;
        }
        prevNode.next = prevNode.next.next;
        if(null !=  prevNode.next) {
            prevNode.next.prev = prevNode;
        }
    }
}

