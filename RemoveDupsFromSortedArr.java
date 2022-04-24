package com.kkd.leetcode.array;

public class RemoveDupsFromSortedArr {

    public static void main(String... args) {
        RemoveDupsFromSortedArr removeDupsFromSortedArr = new RemoveDupsFromSortedArr();

        int[] nums = new int[]{0, 0, 0,0,1, 1, 1, 1, 2, 2, 3, 3, 4};
        //int[] nums = new int[]{1,1,2};
        //int[] nums = new int[]{1, 1};
        //int[] nums = new int[]{1, 2};
        //int[] nums = new int[]{1, 1, 1};
        //int[] nums = new int[]{-1,0,0,0,0,3,3};
        int u = removeDupsFromSortedArr.removeDuplicates(nums);
        System.out.println(u);
    }

    /*public int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return 1;
        }
        for (int i = 0; i < nums.length; i++) {
            int j = i + 1;
            while (j < nums.length) {
                if (nums[i] == nums[j]) {
                    nums[j] = 101;
                } else {
                    break;
                }
                j++;
            }
        }

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != 101) {
                continue;
            }
            int j = i + 1;
            while (j < nums.length) {
                if (nums[j] == 101) {
                    j++;
                } else {
                    nums[i] = nums[j];
                    nums[j] = 101;
                    break;
                }
            }
        }

        int unqNum = 1;
        for(int i = 1; i < nums.length; i++){
            if(nums[i] != 101){
                unqNum++;
            }else{
                break;
            }
        }
        return unqNum;

    }
*/

    public int removeDuplicates(int[] nums) {
        int i = 1;
        for(int j = 1; j < nums.length; j++) {
            if(nums[j] == nums[j-1]) {
                continue;
            } else {
                nums[i] = nums[j];
                i++;
            }
        }
        return i;
    }
}
