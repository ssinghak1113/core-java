package com.kkd.leetcode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class FourSum {

    public static void main(String... args) {
        FourSum fourSum = new FourSum();
        //System.out.println(fourSum.fourSum(new int[]{1, 0, -1, 0, -2, 2}, 0));
        //System.out.println(fourSum.fourSum(new int[]{2,2,2,2,2}, 8));
        System.out.println(fourSum.fourSum(new int[]{-3,-2,-1,0,0,1,2,3}, 0));
    }

    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);

        HashSet<List<Integer>> op = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            int j = i + 1;
            while (j <= nums.length - 3) {
                int k = j + 1;
                int l = nums.length - 1;
                while (k < l) {
                    int one = nums[i];
                    int two = nums[j];
                    int three = nums[k];
                    int four = nums[l];

                    int sum = one + two + three + four;

                    if (sum == target) {
                        op.add(new ArrayList<>(Arrays.asList(one, two, three, four)));
                        k++;
                        l--;
                    } else if (sum < target) {
                        k++;
                    } else {
                        l--;
                    }
                }
                j++;
            }
        }

        return new ArrayList<>(op);
    }
}
