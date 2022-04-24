package com.kkd.leetcode.array;

import java.util.Arrays;

public class RemoveElem {

    public static void main(String[] args) {
        RemoveElem removeElem = new RemoveElem();
        /*int[] nums = new int[]{3, 2, 2, 3};
        int val = 3;*/
        int[] nums = new int[]{0,1,2,2,3,0,4,2};
        int val = 2;
        /*int[] nums = new int[]{3,3};
        int val = 5;*/
        System.out.println(removeElem.removeElement(nums, val));
        System.out.println(Arrays.toString(nums));
    }

    /*public int removeElement(int[] nums, int val) {
        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            if (nums[nums.length - 1] == val) {
                return 0;
            } else {
                return 1;
            }
        }
        Arrays.sort(nums);
        int result = 0;
        int startIdx = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == val) {
                startIdx = i;
                break;
            }
        }

        result = startIdx;
        for (int i = startIdx; i < nums.length; i++) {
            if (nums[i] == val) {
                continue;
            } else {
                nums[result] = nums[i];
                result++;
            }
        }
        return result;
    }*/


    public int removeElement(int[] nums, int val) {
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != val) {
                nums[i] = nums[j];
                i++;
            }
        }
        return i;
    }
}
