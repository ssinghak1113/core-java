package com.kkd.leetcode.array;

public class SortColors {

    public static void main(String[] args){
        SortColors c = new SortColors();
        c.sortColors(new int[]{2,0,2,1,1,0});
    }
    public void sortColors(int[] nums) {
        int n = nums.length;
        int mid = 0;
        int low = 0;
        int high = n-1;

        while(mid <= high){
            if(nums[mid] == 0){
                swap(nums, mid, low);
                mid++; low++;
                continue;
            }else if(nums[mid] == 1){
                mid++;
                continue;
            }else if(nums[mid] == 2){
                swap(nums, mid, high);
                high--;
                continue;
            }
        }
    }

    private void swap(int[] nums, int from, int to){
        int temp = nums[from];
        nums[from] = nums[to];
        nums[to] = temp;
    }
}
