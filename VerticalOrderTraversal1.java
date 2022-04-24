package com.kkd.leetcode.tree;

import java.util.*;

public class VerticalOrderTraversal1 {

    public static void main(String... args) {
        TreeNode root = new TreeNode(3, new TreeNode(1), new TreeNode(4));
        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(2);
        root.right.left = new TreeNode(2);
        VerticalOrderTraversal1 t = new VerticalOrderTraversal1();
        System.out.println(t.verticalTraversal(root));

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

    public class Tuple {
        int row;
        int col;
        TreeNode node;

        public Tuple(int row, int col, TreeNode node) {
            this.row = row;
            this.col = col;
            this.node = node;
        }
    }

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> op = new ArrayList<>();
        Queue<Tuple> queue = new LinkedList<>();
        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> dataMap = new TreeMap<>();

        queue.add(new Tuple(0, 0, root));

        while (!queue.isEmpty()) {
            Tuple tuple = queue.poll();
            int row = tuple.row;
            int col = tuple.col;
            TreeNode node = tuple.node;

            if (!dataMap.containsKey(col)) {
                dataMap.put(col, new TreeMap<>());
            }
            if (!dataMap.get(col).containsKey(row)) {
                dataMap.get(col).put(row, new PriorityQueue<>());
            }
            dataMap.get(col).get(row).add(node.val);

            if (node.left != null) {
                queue.add(new Tuple(row + 1, col - 1, node.left));
            }
            if (node.right != null) {
                queue.add(new Tuple(row + 1, col + 1, node.right));
            }
        }

        for (TreeMap<Integer, PriorityQueue<Integer>> ys : dataMap.values()) {
            op.add(new ArrayList<>());
            for (PriorityQueue<Integer> nodes : ys.values()) {
                while (!nodes.isEmpty()) {
                    op.get(op.size() - 1).add(nodes.poll());
                }
            }
        }
        return op;
    }
}
