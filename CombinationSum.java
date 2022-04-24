package com.kkd.leetcode.array;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {

    public static void main(String[] args) {

        combinationSum(new int[]{2,3,6,7}, 7);
    }

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        find(candidates, 0, target, new ArrayList<>(), result);
        return result;
    }

    private static void find(int[] candidates, int curr, int target, ArrayList<Integer> currSet, List<List<Integer>> result) {
        if (target == 0) {
            result.add(new ArrayList<>(currSet));
        }
        if (target < 0) {
            return;
        }

        for (int i = curr; i < candidates.length; i++) {
            currSet.add(candidates[i]);
            find(candidates, i, target-candidates[i], currSet, result);
            currSet.remove(currSet.size()-1);
        }
    }
}
