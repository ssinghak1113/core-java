package com.kkd.leetcode.array;

import java.util.Arrays;

public class ParkingDilemma_SlidingWindow {
    public static void main(String[] args){
        ParkingDilemma_SlidingWindow p = new ParkingDilemma_SlidingWindow();
        p.minRoofLength(new int[]{2,10,8,17}, 3);
    }

    public int minRoofLength(int[] arr, int k){
        Arrays.sort(arr);
        int start = 0;
        int minRoofLength = Integer.MAX_VALUE;
        for(int end=0;end<arr.length;end++){
            if(end < k-1) continue;
            int currentRoofLength = arr[end]-arr[start++]+1;
            minRoofLength = Math.min(minRoofLength, currentRoofLength);
        }
        return minRoofLength;
    }
}
