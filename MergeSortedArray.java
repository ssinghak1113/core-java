package com.kkd.leetcode.array;

public class MergeSortedArray {

    public static void main(String[] args){
        MergeSortedArray mergeSortedArray = new MergeSortedArray();
       // mergeSortedArray.sort(new int[]{0,-1,3,2,1});
        mergeSortedArray.merge(new int[]{0,0,3,0,0,0,0,0,0}, 3, new int[]{-1,1,1,1,3,2} , 6);
    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {

        if(n > 0){
            for(int i = 0; i<m; i++){

                while(nums2[0] < nums1[i]){
                    int temp = nums1[i];
                    nums1[i] = nums2[0];
                    nums2[0] = temp;
                    sort(nums2);
                }
            }
        }
        for(int i = m, j = 0; i<m+n && j<n; i++, j++){
            nums1[i] = nums2[j];
        }
    }
    // insertion sort
    private void sort(int[] nums2) {
        for(int i = 1; i< nums2.length; i++){
            int key = nums2[i];
            int j = i-1;

            while(j>=0 && nums2[j] > key){
                nums2[j+1] = nums2[j];
                j--;
            }
            nums2[j+1] = key;

        }
    }
}
