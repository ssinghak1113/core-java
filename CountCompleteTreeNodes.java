package com.kkd.leetcode.tree;

public class CountCompleteTreeNodes {

    public static void main(String... args) {
        TreeNode root = new TreeNode(1, new TreeNode(2), new TreeNode(3));
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        CountCompleteTreeNodes t = new CountCompleteTreeNodes();
        System.out.println(t.countNodes(root));

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
    public int countNodes(TreeNode root) {
        if(null == root){
            return 0;
        }
        int leftHt = findLeftHt(root);
        int rightHt = findRightHt(root);

        if(leftHt == rightHt){
            return (int)(Math.pow(2, leftHt)) - 1;
        }else{
            return 1 + countNodes(root.left) + countNodes(root.right);
        }
    }

    private int findLeftHt(TreeNode node){
        int count = 0;
        while(node != null){
            node = node.left;
            count++;
        }
        return count;

    }
    private int findRightHt(TreeNode node){
        int count = 0;
        while(node != null){
            node = node.right;
            count++;
        }
        return count;

    }
}
