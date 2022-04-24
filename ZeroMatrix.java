package com.kkd.leetcode.array;

public class ZeroMatrix {

    public static void main(String[] args) {
        ZeroMatrix m = new ZeroMatrix();
        int[][] n = new int[][]{{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        m.setZeroes(n);
    }

    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[] r = new int[m];
        int[] c = new int[n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    r[i] = 0;
                    c[j] = 0;
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (r[i] == 0 || c[j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }
    }
}
