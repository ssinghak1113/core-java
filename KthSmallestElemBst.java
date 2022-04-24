package com.kkd.leetcode.tree;

import java.util.Arrays;

public class KthSmallestElemBst {

    int min = 0;
    int[] n = new int[1];
    public static void main(String... args) {
        TreeNode root = new TreeNode(3, new TreeNode(1), new TreeNode(4));
        root.left.right = new TreeNode(2);
        KthSmallestElemBst t = new KthSmallestElemBst();
        System.out.println(t.kthSmallest(root, 1));
    }

    public int kthSmallest(TreeNode root, int k) {
        n[0] = k;
        inorderTraverse(root);
        return min;
    }

    private int inorderTraverse(TreeNode root){
        int[] inorder = Arrays.copyOf(new int[]{1,2,3}, 3);
        if(null == root || n[0]  <= 0){
            return min;
        }
        min = inorderTraverse(root.left);
        if( n[0]  > 0) {
            min = root.val;
            n[0] = --n[0];
        }
        min = inorderTraverse(root.right);
        return min;
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }

        @Override
        public String toString() {
            return "TreeNode{" +
                    "val=" + val +
                    '}';
        }
    }
}
