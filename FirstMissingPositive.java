package com.kkd.leetcode.array;

//https://www.youtube.com/watch?v=-lfHWWMmXXM&t=562s
public class FirstMissingPositive {

    public static void main(String[] args) {
        FirstMissingPositive f = new FirstMissingPositive();
        int n = f.firstMissingPositive(new int[]{1, 1});
        System.out.println(n);
    }

    public int firstMissingPositive(int[] nums) { // the min +ve int will be b/w range of 1 to nums len
        int i = 0;
        while (i < nums.length) {
            int corrPosn = nums[i] - 1;
            if (nums[i] > 0 && nums[i] <= nums.length && nums[i] != nums[corrPosn]) { // swap every elem so that index 1 has elem i like index 1 = 1, index 2 = 2, ignore num <1 and > num len coz array isn't large enough to hold it
                swap(i, corrPosn, nums);
            } else {
                i++;
            }
        }

        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != j + 1) {// first index to not match it's elem is next +ve int
                return j + 1;
            }
        }
        return nums.length + 1; // else return num len + 1
    }

    private void swap(int currIndx, int corrPosn, int[] nums) {
        int temp = nums[corrPosn];
        nums[corrPosn] = nums[currIndx];
        nums[currIndx] = temp;
    }

}
