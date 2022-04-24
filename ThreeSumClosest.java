package com.kkd.leetcode.array;

import java.util.Arrays;

public class ThreeSumClosest {

    public static void main(String... args) {
        ThreeSumClosest threeSumClosest = new ThreeSumClosest();
        /*System.out.println(threeSumClosest.threeSumClosest(new int[]{-1, 2, 1, - 4}, 2));
        System.out.println(threeSumClosest.threeSumClosest(new int[]{1,1,1,0}, -100));
        System.out.println(threeSumClosest.threeSumClosest(new int[]{0,2,1,-3}, 0));
        System.out.println(threeSumClosest.threeSumClosest(new int[]{0, 2, 1, -3}, 1));*/

        System.out.println(threeSumClosest.threeSumClosest(new int[]{1, 2, 4, 8, 16, 32, 64, 128}, 82));
    }

    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int closestSum = target;
        int minRange = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int j = i + 1;
            int k = nums.length - 1;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (target > sum) {
                    if (target - sum < minRange) {
                        minRange = target - sum;
                        closestSum = sum;
                    }
                    j++;
                } else {
                    if (sum - target < minRange) {
                        minRange = sum - target;
                        closestSum = sum;
                    }
                    k--;
                }
            }

            if (closestSum == target) {
                break;
            }
        }
        return closestSum;
    }
}
