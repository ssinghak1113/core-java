package com.kkd.leetcode.array;

import java.util.Arrays;

public class FirstAndLastPosnSortedArr {
    public static void main(String[] args) {
        FirstAndLastPosnSortedArr search = new FirstAndLastPosnSortedArr();
        //int[] nums = new int[]{3};//5,7,7,8,8,10
        //int val = 3;
        int[] nums = new int[]{5,7,7,8,8,10};
        int val = 8;
        System.out.println(Arrays.toString(search.searchRange(nums, val)));

    }

    public int[] searchRange(int[] nums, int target) {
        // binary search
        int low = 0;
        int high = nums.length - 1;

        int[] result = new int[]{-1, -1};
        int startRange = -1;
        int endRange = -1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (nums[mid] == target) {
                startRange = mid;
                endRange = mid;
                while (startRange > 0 && nums[startRange - 1] == target) {
                    startRange--;
                }
                while (endRange < nums.length-1 && nums[endRange + 1] == target) {
                    endRange++;
                }
                break;
            } else if (nums[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        result[0] = startRange;
        result[1] = endRange;
        return result;
    }


}
