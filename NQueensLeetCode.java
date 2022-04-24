package com.kkd.leetcode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NQueensLeetCode {

    public static void main(String[] args) {
        NQueensLeetCode n = new NQueensLeetCode();
        System.out.println(n.solveNQueens(4));
    }

    public List<List<String>> solveNQueens(int n) {
        String[][] board = getBlankBoard(n);
        return solveNQueens(board);
    }

    private String[][] getBlankBoard(int n) {
        String[][] board = new String[n][n];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                board[i][j] = ".";
            }
        }
        return board;
    }

    private List<List<String>> solveNQueens(String[][] board) {
        List<List<String>> op = new ArrayList<>();
        solve(board, 0, op, new ArrayList<>());
        return op;
    }

    // recursive method
    private void solve(String[][] board, int rowIdx, List<List<String>> op, List<String> rowList) {
        if (rowIdx == board.length) {
            op.add(new ArrayList<>(rowList)); // if any of the recursive calls end in row == n, then copy the row list to output, create new array list here
            return;
        }
        for (int colIdx = 0; colIdx < board.length; colIdx++) {
            if (isBoardCorrect(board, rowIdx, colIdx)) { // check if board[rowIdx][colIdx] is safe posn
                board[rowIdx][colIdx] = "Q";    // if yes place "Q"
                String row = String.join("", Arrays.asList(board[rowIdx])); // add current row as string to row list
                rowList.add(row);
                solve(board, rowIdx + 1, op, rowList); // solve n queen with current board structure
                board[rowIdx][colIdx] = "."; // perform backtracking
                rowList.remove(rowList.size() - 1); // remove last row from row list
            }
        }

    }

    private boolean isBoardCorrect(String[][] board, int rowIdx, int colIdx) {
        for (int i = 0; i < rowIdx; i++) {
            if ("Q".equals(board[i][colIdx])) {
                return false;
            }
        }
        for (int i = rowIdx, j = colIdx; i >= 0 && j >= 0; i--, j--) {
            if ("Q".equals(board[i][j])) {
                return false;
            }
        }

        for (int i = rowIdx, j = colIdx; i >= 0 && j < board.length; i--, j++) {
            if ("Q".equals(board[i][j])) {
                return false;
            }
        }
        return true;
    }
}
