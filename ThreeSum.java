package com.kkd.leetcode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class ThreeSum {

    public static void main(String... args) {
        ThreeSum twoSum = new ThreeSum();
        System.out.println(twoSum.threeSum(new int[]{3, 0, -2, -1, 1, 2}));
    }

    public List<List<Integer>> threeSum(int[] nums) {
        HashSet<List<Integer>> res = new HashSet<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            int j = i + 1;
            int k = nums.length - 1;
            while (j < k) {
                if (nums[i] + nums[j] + nums[k] == 0) {
                    List<Integer> temp = new ArrayList<>(Arrays.asList(nums[i], nums[j], nums[k]));
                    res.add(temp);
                    j++;
                    k--;
                } else if (nums[i] + nums[j] + nums[k] > 0)
                    k--;
                else
                    j++;
            }
        }
        return new ArrayList<>(res);
    }
}
