package com.kkd.leetcode.array;

public class SearchInsertPosn {

    public static void main(String[] args) {
        SearchInsertPosn search = new SearchInsertPosn();
        int[] nums = new int[]{1, 3, 5, 6};
        int val = 5;
        System.out.println(search.searchInsert(nums, val));
        //System.out.println(Arrays.toString(nums));
    }

    public int searchInsert(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (mid == nums.length - 1 && target > nums[mid]) {
                return mid + 1;
            } else if (mid == 0 && target < nums[mid]) {
                return mid;
            } else if (mid + 1 < nums.length && target > nums[mid] && target < nums[mid + 1]) {
                return mid + 1;
            } else if (mid - 1 >= 0 && target < nums[mid] && target > nums[mid - 1]) {
                return mid;
            }
            if (nums[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return 0;
    }
}
