package com.kkd.leetcode.array;

import java.util.Arrays;

// backtracking
public class NQueen {

    public static void main(String[] args) {
        int[][] board = {
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0}
        };

        System.out.println(solveNQueen(board, 0));
        System.out.println(Arrays.deepToString(board));
    }

    private static boolean solveNQueen(int[][] board, int row) {
        if (row == 4) {
            return true; // if all rows have been covered then return true since process is completed with or
            // without required back tracking
        }
        for (int col = 0; col < 4; col++) {
            if (isValidPosn(board, row, col)) {
                board[row][col] = 1;
                if (solveNQueen(board, row + 1)) {
                    return true;
                } else {
                    board[row][col] = 0; // back tracking step
                }
            }
        }
        return false;
    }

    private static boolean isValidPosn(int[][] board, int row, int col) {
        /**     |
         *  \       /
         *      Q
         */
        // since we are traversing downwards per row

        // check this col on upper side
        for (int i = 0; i < row; i++) {
            if (board[i][col] == 1) {
                return false;
            }
        }

        // check left upper diagonal (row and col both decreasing)
        for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 1) {
                return false;
            }
        }

        // check right upper diagonal (row decreasing and col increasing)
        for (int i = row, j = col; i >= 0 && j < 4; i--, j++) {
            if (board[i][j] == 1) {
                return false;
            }
        }

        return true;
    }

}
