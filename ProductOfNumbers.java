package com.kkd.leetcode.queuesnstacks;

import java.util.ArrayList;

public class ProductOfNumbers {
    ArrayList<Integer> prefixProducts ;
    int count=0;

    public ProductOfNumbers() {
        prefixProducts = new ArrayList<>();
        prefixProducts.add(1);
    }

    public void add(int num) {
        count++;

        if(num == 0){
            prefixProducts = new ArrayList<>();
            prefixProducts.add(1);
            count = 0;
        }else{
            prefixProducts.add(prefixProducts.get(count-1)*num);
        }
    }

    public int getProduct(int k) {
        if(prefixProducts.size()-k-1 < 0){
            return 0;
        }
        return prefixProducts.get(prefixProducts.size()-1)/prefixProducts.get(prefixProducts.size()-k-1);
    }
    

}
