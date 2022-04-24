package com.kkd.leetcode.tree;

import java.util.*;

public class VerticalOrderTraversal {

    public static void main(String... args) {
        TreeNode root = new TreeNode(3, new TreeNode(1), new TreeNode(4));
        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(2);
        root.right.left = new TreeNode(2);
        VerticalOrderTraversal t = new VerticalOrderTraversal();
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

    public class Coordinate implements Comparable {
        int row;
        int col;

        Coordinate(int row, int col) {
            this.row = row;
            this.col = col;
        }

        public int getRow() {
            return row;
        }

        public int getCol() {
            return col;
        }

        @Override
        public int compareTo(Object o) {
           Coordinate coordinate = (Coordinate)o;
           if(this.row == coordinate.row && this.col == coordinate.col){
               return 0;
           }
           if(this.col < coordinate.col){
               return -1;
           }else {
               return 1;
           }
        }

        @Override
        public String toString() {
            return "Coordinate{" +
                    "row=" + row +
                    ", col=" + col +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Coordinate that = (Coordinate) o;
            return row == that.row && col == that.col;
        }

        @Override
        public int hashCode() {
            return Objects.hash(row, col);
        }
    }

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        TreeMap<Coordinate, PriorityQueue<Integer>> dataMap = new TreeMap<>();
        HashMap<TreeNode, Coordinate> coordinateMap = new HashMap<>();
        queue.add(root);
        PriorityQueue<Integer> sortedQueue = new PriorityQueue();
        sortedQueue.add(root.val);
        Coordinate coordinate = new Coordinate(0, 0);
        dataMap.put(coordinate, sortedQueue);
        coordinateMap.put(root, coordinate);

        while (true) {
            int len = queue.size();
            if (queue.isEmpty()) {
                break;
            }
            for (int i = 0; i < len; i++) {
                TreeNode node = queue.poll();
                TreeNode left = node.left;
                TreeNode right = node.right;
                Coordinate rootCoordinate = coordinateMap.get(node);
                if (null != left) {
                    Coordinate leftCoordinate = new Coordinate(rootCoordinate.getRow() + 1, rootCoordinate.getCol() - 1);
                    PriorityQueue<Integer> leftSortedQueue = dataMap.get(leftCoordinate);
                    if (null == leftSortedQueue) {
                        leftSortedQueue = new PriorityQueue();
                    }
                    leftSortedQueue.add(left.val);

                    dataMap.put(leftCoordinate, leftSortedQueue);
                    coordinateMap.put(left, leftCoordinate);
                    queue.add(left);
                }
                if (null != right) {
                    Coordinate rightCoordinate = new Coordinate(rootCoordinate.getRow() + 1, rootCoordinate.getCol() + 1);
                    PriorityQueue<Integer> rightSortedQueue = dataMap.get(rightCoordinate);
                    if (null == rightSortedQueue) {
                        rightSortedQueue = new PriorityQueue();
                    }
                    rightSortedQueue.add(right.val);
                    dataMap.put(rightCoordinate, rightSortedQueue);
                    coordinateMap.put(right, rightCoordinate);
                    queue.add(right);
                }
            }
        }

        List<List<Integer>> op = new ArrayList<>();

        Map<Integer, List<Integer>> result = new HashMap<>();

        dataMap.forEach((coordinate1, priorityQueue) -> {
            List<Integer> list = result.get(coordinate1.getCol());
            if(list == null){
                list = new ArrayList<>();
                result.put(coordinate1.getCol(), list);
                op.add(list);
            }
            while (!priorityQueue.isEmpty()) {
                list.add(priorityQueue.poll());
            }

        });

        return op;
    }
}
