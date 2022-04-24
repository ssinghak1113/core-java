package com.kkd.leetcode.array;

import java.util.Arrays;

/**
 * https://www.youtube.com/watch?v=LuLCLgMElus
 */
public class NextPermutation {

    public static void main(String[] args) {
        NextPermutation n = new NextPermutation();
        //int[] nums = new int[]{1, 3, 5, 4, 2};
        //int[] nums = new int[]{3, 2, 1};
        int[] nums = new int[]{1, 2, 3};
        n.nextPermutation(nums);
        System.out.println(Arrays.toString(nums));
    }

    public void nextPermutation(int[] nums) {
        // reverse order -> find i where a[i] < a[i+1]
        // reverse order -> find j where a[j] > a[i]
        // swap a[i] & a[j]
        // reverse sort a[i+1] to last

        int swapIdxFrom = 0;
        int swapIdxTo = 0;

        if (nums == null || nums.length == 0 || nums.length == 1) {
            return;
        }
        swapIdxFrom = nums.length - 2; // start from 2nd last index
        while (swapIdxFrom >= 0 && nums[swapIdxFrom] >= nums[swapIdxFrom + 1]) {
            swapIdxFrom--;
        }

        if (swapIdxFrom >= 0) {
            swapIdxTo = nums.length - 1;

            while (swapIdxTo >= 0 && nums[swapIdxTo] <= nums[swapIdxFrom]) {
                swapIdxTo--;
            }
            swap(nums, swapIdxFrom, swapIdxTo);
        }
        int i = swapIdxFrom + 1;
        int j = nums.length - 1;
        // since i to j is ascending sorted
        while (i < j) {
            swap(nums, i++, j--);
        }
    }

    private void swap(int[] nums, int swapIdxFrom, int swapIdxTo) {
        int temp = nums[swapIdxFrom];
        nums[swapIdxFrom] = nums[swapIdxTo];
        nums[swapIdxTo] = temp;
    }
}
