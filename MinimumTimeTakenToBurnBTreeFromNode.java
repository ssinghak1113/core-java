package com.kkd.leetcode.tree;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class MinimumTimeTakenToBurnBTreeFromNode {
    TreeNode targetNode = null;
    public static void main(String... args) {
        int d = (int) Math.pow(2, 3);
        TreeNode root = new TreeNode(1, new TreeNode(2), new TreeNode(3));
        root.left.left = new TreeNode(4);
        root.left.left.right = new TreeNode(7);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(6);

        MinimumTimeTakenToBurnBTreeFromNode min = new MinimumTimeTakenToBurnBTreeFromNode();
        System.out.println(min.time(root, 2));
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

    public int time(TreeNode root, int target) {
        HashMap<TreeNode, TreeNode> nodeToParentMap = new HashMap<>();
        prepareNodeToParentMap(root, target, nodeToParentMap);
        return bfs(targetNode, nodeToParentMap);
    }

    private int bfs(TreeNode targetNode, HashMap<TreeNode, TreeNode> nodeToParentMap) {
        Queue<TreeNode> queue = new LinkedList<>();
        HashSet<TreeNode> burntNodes = new HashSet<>();

        queue.add(targetNode);
        burntNodes.add(targetNode);

        int min = 0;
        while (true) {
            if (queue.isEmpty()) {
                return min;
            }
            boolean burnt = false;
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                TreeNode node = queue.poll();

                if(null != node.left){
                    if(!burntNodes.contains(node.left)){
                        burntNodes.add(node.left); // maintain a visited hashing
                        burnt = true;
                        queue.add(node.left); // add only to q if not already visited
                    }
                }
                if(null != node.right){
                    if(!burntNodes.contains(node.right)){
                        burntNodes.add(node.right);
                        burnt = true;
                        queue.add(node.right);
                    }
                }
                if(null != nodeToParentMap.get(node)){
                    if(!burntNodes.contains(nodeToParentMap.get(node))){
                        burntNodes.add(nodeToParentMap.get(node));
                        burnt = true;
                        queue.add(nodeToParentMap.get(node));
                    }
                }
            }
            if(burnt){
                min++;
            }
        }
    }

    private void prepareNodeToParentMap(TreeNode root, int target, HashMap<TreeNode, TreeNode> nodeToParentMap) {
        if(root.val == target){
            targetNode = root;
        }
        if(root.left != null){
            nodeToParentMap.put(root.left, root);
            prepareNodeToParentMap(root.left, target, nodeToParentMap);
        }
        if(root.right != null){
            nodeToParentMap.put(root.right, root);
            prepareNodeToParentMap(root.right, target, nodeToParentMap);
        }
    }
}
