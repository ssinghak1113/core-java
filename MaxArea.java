package com.kkd.leetcode.array;

import java.util.Scanner;

public class MaxArea {

    public static void main(String... args) {
        int nums1[];

        try (Scanner sc = new Scanner(System.in)) {
            nums1 = new int[sc.nextInt()];
            for (int i = 0; i < nums1.length; i++) {
                nums1[i] = sc.nextInt();
            }
            MaxArea maxArea = new MaxArea();
            maxArea.maxArea(nums1);
        }

    }

    public int maxArea(int[] height) {
        int i = 0;
        int j = height.length -1;
        int max = 0;
        while(i<j){
            if(height[i]>height[j]){
                max = Math.max(max,(j-i)*height[j]);
                j--;
            }else{
                max = Math.max(max,(j-i)*height[i]);
                i++;
            }
        }
        return max;
    }
}
