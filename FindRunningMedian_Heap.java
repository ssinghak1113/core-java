package com.kkd.hackerrank;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/find-the-running-median/problem
 */
public class FindRunningMedian_Heap {

    public static void main(String... args) {
        try (Scanner sc = new Scanner(System.in)) {
            int nArr = sc.nextInt();
            PriorityQueue<Integer> lowers = new PriorityQueue<>(new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return o2.compareTo(o1);
                }
            }); // maxHeap

            PriorityQueue<Integer> highers = new PriorityQueue<>(); // minHeap


            for (int i = 0; i < nArr; i++) {
                int num = sc.nextInt();
                addNumbersToHeap(num, lowers, highers);
                rebalanceHeap(lowers, highers);
                System.out.println(getMedian(lowers, highers));
            }

        }
    }

    private static double getMedian(PriorityQueue<Integer> lowers, PriorityQueue<Integer> highers) {
        if (lowers.size() == highers.size()) {
            return ((double)lowers.peek() + (double)highers.peek()) / 2;
        } else if (lowers.size() > highers.size())
            return lowers.peek();
        else return highers.peek();
    }

    private static void rebalanceHeap(PriorityQueue<Integer> lowers, PriorityQueue<Integer> highers) {

        PriorityQueue<Integer> smallerHeap = lowers.size() > highers.size() ? highers : lowers;
        PriorityQueue<Integer> biggerHeap = lowers.size() > highers.size() ? lowers : highers;

        if (biggerHeap.size() - smallerHeap.size() >= 2) {
            smallerHeap.add(biggerHeap.poll());
        }

    }

    private static void addNumbersToHeap(int num, PriorityQueue<Integer> lowers, PriorityQueue<Integer> highers) {
        if (lowers.size() == 0 || num < lowers.peek()) {
            lowers.add(num);
        } else {
            highers.add(num);
        }
    }
}
