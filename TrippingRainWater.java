package com.kkd.leetcode.array;

public class TrippingRainWater {

    public static void main(String[] args){
        TrippingRainWater trippingRainWater = new TrippingRainWater();
        System.out.println(trippingRainWater.trap(new int[]{0,1,0,2,1,0,1,3,2,1,2,1}));
    }

    public int trap(int[] height) {
        int n = height.length;
        int totalWater = 0;
        int maxIndex = 0;
        int max = 0;

        for(int i = 0; i< n ; i++){
            if(height[i] > max){
                max = height[i];
                maxIndex = i;
            }
        }

        int leftMax = 0;
        int rightMax = height[maxIndex];
        for(int i = 0; i< maxIndex ; i++){
            leftMax = Math.max(leftMax, height[i]);
            int water = Math.min(leftMax, rightMax) - height[i];
            totalWater += water;
        }

        leftMax = 0;
        for(int i = n-1; i>maxIndex ; i--){
            leftMax = Math.max(leftMax, height[i]);
            int water = Math.min(leftMax, rightMax) - height[i];
            totalWater += water;
        }


        return totalWater;
    }
}
