package com.kkd.leetcode.array;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle {

    public static void main(String[] args){
        PascalsTriangle p = new PascalsTriangle();
        p.generate(5);
    }
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> op = new ArrayList<>();
        List<Integer> first = new ArrayList<>();
        List<Integer> second = new ArrayList<>();

        first.add(1);
        second.add(1);
        second.add(1);

        op.add(first);
        if(1 == numRows){
            return op;
        }

        op.add(second);
        if(2 == numRows){
            return op;
        }

        while(numRows != 2){
            numRows--;
            List<Integer> list = new ArrayList<>();
            List<Integer> prev = op.get(op.size()-1);
            list.add(1);
            for(int i = 0; i< prev.size()-1;){
                list.add(prev.get(i) + prev.get(++i));
            }
            list.add(1);
            op.add(list);
        }

        return op;
    }
}
