package com.kkd.leetcode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum2 {

    public static void main(String[] args) {
        CombinationSum2 combinationSum2 = new CombinationSum2();
        System.out.println(combinationSum2.combinationSum2(new int[]{10,1,2,7,6,1,5}, 8));
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> result = new ArrayList<>();
        find(candidates, 0, target, new ArrayList<>(), result);
        return result;
    }

    private void find(int[] candidates, int index, int target, ArrayList<Integer> currList, List<List<Integer>> result) {
        if (target == 0) {
            result.add(new ArrayList<>(currList));
        }
        if (target < 0) {
            return;
        }

        for (int i = index; i < candidates.length; i++) {
            if(i > index && candidates[i] == candidates[i-1]){
                continue; // check for unique solutions, of consecutive nums are same then skip 'cause we already have all the combinations for that num
            }
            currList.add(candidates[i]);
            find(candidates, i + 1, target-candidates[i], currList, result);
            currList.remove(currList.size() - 1);
        }
    }
}
