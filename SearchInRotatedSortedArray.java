package com.kkd.leetcode.array;

public class SearchInRotatedSortedArray {

    public static void main(String[] args) {
        SearchInRotatedSortedArray search = new SearchInRotatedSortedArray();
        //int[] nums = new int[]{4, 5, 6, 7, 0, 1, 2};
        //int val = 0;
        int[] nums = new int[]{1,3};
        int val = 3;
        System.out.println(search.search(nums, val));
        //System.out.println(Arrays.toString(nums));
    }

    public int search(int[] nums, int target) {
        int index = -1;
        int i = 0;
        int pivotIndx = 0;
        while (i < nums.length - 1) {
            if (nums[i] > nums[i + 1]) {
                pivotIndx = i;
                break;
            }
            i++;
        }

        if (nums[pivotIndx] == target) {
            return pivotIndx;
        } else if (nums[0] <= target && nums[pivotIndx] >= target) {
            index = binarySearch(nums, 0, pivotIndx, target);
        } else {
            index = binarySearch(nums, pivotIndx + 1, nums.length - 1, target);
        }
        return index;
    }

    private int binarySearch(int[] nums, int low, int high, int target) {
        while (low <= high) {
            int mid = (low + high) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return -1;
    }

}
