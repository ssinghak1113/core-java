package com.kkd.leetcode.linkedlist;

public class RemoveNthNodeFromEndOfList {

    static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

        @Override
        public String toString() {
            return "ListNode{" +
                    "val=" + val +
                    ", next=" + next +
                    '}';
        }
    }

    public static void main(String... args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        /*head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);*/

        RemoveNthNodeFromEndOfList r = new RemoveNthNodeFromEndOfList();
        ListNode n = r.removeNthFromEnd(head, 2);
        System.out.println(n);
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode slow = dummy;
        ListNode fast = head;

        while(n != 0){
            fast = fast.next;
            n--;
        }

        while(fast != null){
            slow = slow.next;
            fast = fast.next;
        }

        slow.next = slow.next.next;

        return dummy.next;
    }
}
