package com.kkd.leetcode.linkedlist;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Test {

    public static void main(String[] args) {
        ListNode m = new ListNode();
        m.addAtTail(1);
        m.addAtTail(2);
        m.addAtTail(3);
        m.addAtTail(4);
        m.addAtTail(5);
        m.rotateRight(m, 2);

    }

    private static Object[] solution() {
        try (Scanner sc = new Scanner(System.in)) {
            int q = sc.nextInt();

            int[] type = new int[q];
            int[] queries1 = new int[q];
            int[] queries2 = new int[q];

            insertIntoArr(sc, q, type);
            insertIntoArr(sc, q, queries1);
            insertIntoArr(sc, q, queries2);

            return getInts(q, type, queries1, queries2);

        }
    }

    private static Object[] getInts(int q, int[] type, int[] queries1, int[] queries2) {
        int[] A = new int[q];

        for (int i = 0; i < q; i++) {
            if (type[i] == 1) {
                A[i] = queries1[i];
            } else if (type[i] == 2) {
                for (int j = 0; j < q; j++) {
                    if (A[j] == queries1[i]) {
                        A[j] = queries2[i];
                    }
                }
            }
        }
        List<Integer> result = new ArrayList<>();
        int counter = 0;
        while (A[counter] > 0) {
            result.add(A[counter]);
            counter++;
        }

        return result.toArray();
    }

    private static void insertIntoArr(Scanner sc, int q, int[] type) {
        int counter = 0;
        while (counter < q) {
            type[counter] = sc.nextInt();
            counter++;
        }
    }
}
