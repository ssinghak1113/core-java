package com.kkd.leetcode.linkedlist;

public class MergeTwoSortedLists {

    public static void main(String[] args){

        int one = 4;
        int two = 5;
        System.out.println(one/two);
        ListNode list1 = new ListNode();
        list1.addAtTail(1);
        list1.addAtTail(2);
        list1.addAtTail(4);

        ListNode list2 = new ListNode();
        list2.addAtTail(1);
        list2.addAtTail(3);
        list2.addAtTail(4);
        MergeTwoSortedLists m = new MergeTwoSortedLists();
        m.mergeTwoLists(list1, list2 );
    }
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (null == list1) {
            return list2;
        }

        if (null == list2) {
            return list1;
        }

        ListNode dummy = new ListNode();

        return dummy.next;
    }


}
