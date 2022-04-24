package com.kkd.leetcode.linkedlist;

public class AddTwoNumbers {

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
        ListNode head = new ListNode(2);
        head.next = new ListNode(4);
        head.next.next = new ListNode(3);

        ListNode head1 = new ListNode(5);
        head1.next = new ListNode(6);
        head1.next.next = new ListNode(4);

        AddTwoNumbers addTwoNumbers = new AddTwoNumbers();
        ListNode n = addTwoNumbers.addTwoNumbers(head, head1);
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int sum;
        int carryover = 0;

        ListNode temp = new ListNode();
        ListNode current = temp;

        while (l1 != null || l2 != null || carryover != 0) {
            sum = 0;
            if (l1 != null) {
                sum += l1.val;
            }
            if (l2 != null) {
                sum += l2.val;
            }

            sum  += carryover;
            carryover = sum / 10;
            current.next = new ListNode(sum % 10);
            current = current.next;
            if (null != l1) {
                l1 = l1.next;
            }
            if (null != l2) {
                l2 = l2.next;
            }
        }
        return temp.next;
    }
}
