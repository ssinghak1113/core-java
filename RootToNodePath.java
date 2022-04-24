package com.kkd.leetcode.tree;

import java.util.ArrayList;
import java.util.List;

public class RootToNodePath {

    public static void main(String... args) {
        TreeNode root = new TreeNode(1, new TreeNode(2), new TreeNode(3));
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.left.right.left = new TreeNode(6);
        root.left.right.right = new TreeNode(7);
        RootToNodePath t = new RootToNodePath();
        System.out.println(t.solve(root, 7));
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

    public ArrayList<Integer> solve(TreeNode root, int num) {
        ArrayList<Integer> list = new ArrayList<>();
        inorderTraverse(root, num, list);
        return list;
    }

    private boolean inorderTraverse(TreeNode node, int num, List<Integer> list) {
        if (node == null) {
            return false;
        }
        list.add(node.val);
        if (node.val == num) {
            return true;
        }
        boolean onLeft = inorderTraverse(node.left, num, list);
        boolean onRight = inorderTraverse(node.right, num, list);
        if (onLeft || onRight) {
            return true;
        } else {
            list.remove(list.size() - 1);
            return false;
        }
       
    }
}
