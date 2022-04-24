package com.kkd.leetcode.array;

public class MissingNumber {

    public static void main(String[] args){
        MissingNumber m = new MissingNumber();
        m.missingNumber(new int[]{1,2});
    }
    public int missingNumber(int[] nums) {

        int n = nums.length;
        int i = 0;

        while (i < n) {
            int num = nums[i];
            if (num == n) {
                i++;
                continue;
            }
            if (num != i) {
                int temp = nums[num];
                nums[num] = num;
                nums[i] = temp;
            } else {
                i++;
            }
        }

        int op = n;
        for (i = 0; i < n; i++) {
            if (nums[i] != i) {
                op = i;
                break;
            }
        }

        return op;
    }

}
