package com.kkd.leetcode.array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Median {

    public static void main(String... args) {
        int nums1[];
        int nums2[];

        try (Scanner sc = new Scanner(System.in)) {
            nums1 = new int[sc.nextInt()];
            for (int i = 0; i < nums1.length; i++) {
                nums1[i] = sc.nextInt();
            }
            nums2 = new int[sc.nextInt()];
            for (int i = 0; i < nums2.length; i++) {
                nums2[i] = sc.nextInt();
            }

            Median median = new Median();
            median.findMedianSortedArrays(nums1, nums2);
        }

    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        List<Integer> mergedList = new ArrayList<>();

        int endIdx = nums1.length > nums2.length ? nums1.length : nums2.length;

        for (int i = 0; i < endIdx; i++) {
            if (nums1.length > i) {
                mergedList.add(nums1[i]);
            }
            if (nums2.length > i) {
                mergedList.add(nums2[i]);
            }
        }

        Collections.sort(mergedList);

        int len = mergedList.size();
        double median;
        if (len % 2 == 0) {
            median = ((double)(mergedList.get(len / 2 - 1) + mergedList.get(len / 2)) )/ 2;
        } else {
            median = mergedList.get(len / 2);
        }
        return median;
    }
}
