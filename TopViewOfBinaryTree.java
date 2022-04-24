package com.kkd.leetcode.tree;

import java.util.*;

public class TopViewOfBinaryTree {

    public static void main(String... args) {
        TreeNode root = new TreeNode(1, new TreeNode(2), new TreeNode(3));
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.left.right.right = new TreeNode(6);
        root.right.right = new TreeNode(7);
        TopViewOfBinaryTree t = new TopViewOfBinaryTree();
        System.out.println(t.traverse(root));
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

    public class Pair{
        TreeNode node;
        int col;
        Pair(TreeNode node, int col){
            this.node = node;
            this.col = col;
        }
    }
    private List<Integer> traverse(TreeNode root){
        Queue<Pair> queue = new LinkedList<>();
        TreeMap<Integer, Integer> dataMap = new TreeMap<>();
        
        queue.add(new Pair(root, 0));
        
        while(!queue.isEmpty()){
            Pair pair = queue.poll();    
            TreeNode node = pair.node;
            int col = pair.col;
            
            if(!dataMap.containsKey(col)){
                dataMap.put(col, node.val);
            }
            if(null != node.left) {
                queue.add(new Pair(node.left, col-1));
            }
            if(null != node.right) {
                queue.add(new Pair(node.right, col+1));
            }
        }
        
        return new ArrayList<>(dataMap.values());
    }
}
