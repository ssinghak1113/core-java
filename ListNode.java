package com.kkd.leetcode.linkedlist;

class ListNode {

    int val;
    ListNode next;
    ListNode head;

    public ListNode() {

    }

    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val +
                ", next=" + next +
                '}';
    }

    public int get(int index) {
        ListNode node = head;
        while (index != 0) {
            if (node == null) {
                return -1;
            }
            node = node.next;
            index--;
        }

        if (null != node) {
            return node.val;
        }

        return -1;
    }

    public void addAtHead(int val) {
        ListNode node = new ListNode();
        node.val = val;
        node.next = head;
        head = node; // assign head to new node
    }

    public void addAtTail(int val) {
        ListNode newNode = new ListNode();
        newNode.val = val;

        if (null == head) {
            head = newNode;
            return;
        }
        ListNode currNode = head;

        while (currNode.next != null) {
            currNode = currNode.next;
        }

        currNode.next = newNode;
    }

    public void addAtIndex(int index, int val) {
        ListNode newNode = new ListNode();
        newNode.val = val;

        if (index == 0) {
            newNode.next = head;
            head = newNode;
            return;
        }

        ListNode currNode = head;
        for (int i = 0; i < index - 1 && currNode != null; i++) {
            currNode = currNode.next;
        }

        if (currNode == null) {
            return;
        }

        if (currNode.next == null) {
            currNode.next = newNode;
        } else {
            newNode.next = currNode.next;
            currNode.next = newNode;
        }
    }

    public void deleteAtIndex(int index) {
        if (null == head) {
            return;
        }
        if (index == 0) {
            head = head.next;
            return;
        }
        ListNode prevNode = head;
        for (int i = 0; i < index - 1 && prevNode != null; i++) {
            prevNode = prevNode.next;
        }

        if (prevNode == null || prevNode.next == null) {
            return;
        }
        prevNode.next = prevNode.next.next;
    }

    public ListNode reverse(ListNode head) {
        ListNode curr = head;
        ListNode prev = null;

        while (curr != null) {
            ListNode temp = curr.next;

            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        this.head = prev;
        return prev;
    }

    public ListNode oddEvenList(ListNode head) {

        if (null == head || null == head.next || null == head.next.next) {
            return head;
        }


        ListNode odd = head;
        ListNode even = head.next;
        ListNode dummyOdd = new ListNode();
        ListNode dummyEven = new ListNode();

        dummyOdd.next = odd;
        dummyEven.next = even;


        while ((even != null && even.next != null)) {
            if ((odd != null && odd.next != null)) {
                odd.next = odd.next.next;
                odd = odd.next;
            }

            if ((even != null && even.next != null)) {
                even.next = even.next.next;
                even = even.next;
            }
        }
        odd.next = dummyEven.next;

        return dummyOdd.next;
    }

    public boolean isPalindrome1(ListNode head) {

        ListNode curr1 = head;
        int len = 0;
        while(curr1 != null){
            curr1 = curr1.next;
            len++;
        }

        int mid = len/2;
        // 1-> 2-> 3<- 2<- 1

        int counter = 0;
        ListNode firstHalfEnd = null;
        ListNode secondHalfStart = head;
        while(counter != mid){
            counter++;
            firstHalfEnd = secondHalfStart;
            secondHalfStart = secondHalfStart.next;
        }

        // reverse
        ListNode prev = null;
        ListNode curr = secondHalfStart;

        while(curr != null){
            ListNode tempNext = curr.next;

            curr.next = prev;
            prev = curr;
            curr = tempNext;
        }

        firstHalfEnd.next = prev;
        counter = 0;
        while(counter != mid){
            if(head.val != prev.val){
                return false;
            }

            head = head.next;
            prev = prev.next;
            counter ++;
        }

        return true;
    }

    public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null){
            return true;
        }       //1->2->3->2->1

        ListNode mid = findMiddle(head); //3->2->1
        ListNode last = reverse(mid); //3<- 2<-1

        while(last != null){
            if(last.val != head.val){
                return false;
            }
            last = last.next;
            head = head.next;
        }
        return true;
    }

    private ListNode findMiddle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    public ListNode rotateRight(ListNode head, int k) {

        if(head == null || head.next == null || k == 0){
            return head;
        }

        ListNode tail = head;
        int len = 1;
        while(tail.next != null){
            len ++;
            tail = tail.next;
        }

        tail.next = head;

        k = k % len;
        k = len - k;

        while(k != 0){
            tail = tail.next;
            k--;
        }

        head = tail.next;
        tail.next = null;

        return head;
    }
}