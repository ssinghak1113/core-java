package com.kkd.leetcode.tree;

import java.util.ArrayList;

public class BoundryTraversal {

    class TreeNode {
        int data;
        TreeNode left;
        TreeNode right;

        TreeNode(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }

    }

    public static ArrayList<Integer> traverseBoundary(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        if(isLeaf(root)){
            return list;
        }
        list.add(root.data);
        addLeftBoundary(root.left, list);
        addBottomBoundry(root, list);
        addRightBoundary(root.right, list);
        return list;
    }

    static void addLeftBoundary(TreeNode root, ArrayList<Integer> res) {
        TreeNode cur = root.left;
        while (cur != null) {
            if (isLeaf(cur) == false) res.add(cur.data);
            if (cur.left != null) cur = cur.left;
            else cur = cur.right;
        }
    }

    static void addBottomBoundry(TreeNode root, ArrayList<Integer> res) {
        if (isLeaf(root)) {
            res.add(root.data);
            return;
        }
        if (root.left != null) addBottomBoundry(root.left, res);
        if (root.right != null) addBottomBoundry(root.right, res);
    }

    static void addRightBoundary(TreeNode root, ArrayList<Integer> res) {
        TreeNode cur = root.right;
        ArrayList<Integer> tmp = new ArrayList<Integer>();
        while (cur != null) {
            if (isLeaf(cur) == false) tmp.add(cur.data);
            if (cur.right != null) cur = cur.right;
            else cur = cur.left;
        }
        int i;
        for (i = tmp.size()-1; i >= 0; --i) {
            res.add(tmp.get(i));
        }
    }

    private static boolean isLeaf(TreeNode node) {
        return node.left == null && node.right == null;
    }
}
