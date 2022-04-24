package com.kkd.leetcode.array;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class TwoSum {

    public static void main(String... args) {
        int nums[];
        int target;
        try (Scanner sc = new Scanner(System.in)) {
            nums = new int[sc.nextInt()];
            for (int i = 0; i < nums.length; i++) {
                nums[i] = sc.nextInt();
            }
            target = sc.nextInt();
        }
        TwoSum twoSum = new TwoSum();
        twoSum.twoSum(nums, target);
    }


    /**
     * o(n2) time complexity
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum1(int[] nums, int target) {
        int idx[] = null;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == target - nums[j]) {
                    idx = new int[]{i, j};
                    break;
                }
            }
            if (null != idx) {
                break;
            }
        }
        return idx;
    }

    /**
     * hashmap impl
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> indexMap = new HashMap<>();

        int idx[] = null;
        for (int i = 0; i < nums.length; i++) {
            int reqdNum = target - nums[i];
            if (indexMap.containsKey(reqdNum)) {
                return new int[]{indexMap.get(reqdNum), i};
            }
            indexMap.put(nums[i], i);
        }
        return idx;
    }
}
