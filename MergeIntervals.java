package com.kkd.leetcode.array;

import java.util.*;
//[-10,-10,-10,-10,-9,-9,-9,-9,-9,-9,-9,-8,-8,-8,-8,-8,-8,-8,-7,-7,-7,-7,-7,-7,-7,-7,-7,-7,-7,-6,-6,-6,-6,-6,-6,-6,-6,-6,-6,-6,-5,-5,-5,-5,-5,-5,-5,-5,-4,-4,-4,-4,-4,-4,-4,-4,-3,-3,-2,-2,-2,-2,-2,-1,-1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,1,1,1,1,2,2,2,2,2,2,2,2,2,2,2,3,3,3,3,3,3,3,4,4,4,4,4,4,4,4,5,5,5,5,5,5,5,5,6,6,6,6,6,6,6,6,6,7,7,7,7,7,7,7,7,7,7,7,8,8,8,8,8,9,9,9,9,9,9,9,9]
public class MergeIntervals {

    public static void main(String[] args) {
        MergeIntervals m = new MergeIntervals();
        int[][] nums = new int[][]{{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        //int[][] nums = new int[][]{{1, 4}, {1, 5}};
        //int[][] nums = new int[][]{{1, 4}, {0, 2}, {3, 5}};
        m.merge(nums);
    }


    public int[][] merge(int[][] nums) {
        Arrays.sort(nums, (a,b) -> a[0] - b[0]);

        ArrayList<int[]> op = new ArrayList<>();

        for(int[] interval : nums){
            // if list empty or does not overlap
            if(op.isEmpty() || op.get(op.size()-1)[1] < interval[0]) {
                op.add(interval);
            }  else{
                op.get(op.size()-1)[1] = Math.max(op.get(op.size()-1)[1], interval[1]);
            }
        }
        return op.toArray(new int[op.size()][]);
    }
}
