package com.kkd.leetcode.array;

import java.util.HashMap;

public class ValidSudoku {

    public static void main(String[] args) {
        ValidSudoku validSudoku = new ValidSudoku();
        char[][] c = new char[9][9];
        c[0][0] = '8';
        c[0][1] = '3';
        c[0][4] = '7';
        c[1][0] = '6';
        c[1][3] = '1';
        c[1][4] = '9';
        c[1][5] = '5';
        c[2][1] = '9';
        c[2][2] = '8';
        c[2][7] = '6';
        //[["8","3",".",".","7",".",".",".","."],
        // ["6",".",".","1","9","5",".",".","."],
        // [".","9","8",".",".",".",".","6","."],
        // ["8",".",".",".","6",".",".",".","3"],
        // ["4",".",".","8",".","3",".",".","1"],
        // ["7",".",".",".","2",".",".",".","6"],
        // [".","6",".",".",".",".","2","8","."],
        // [".",".",".","4","1","9",".",".","5"],
        // [".",".",".",".","8",".",".","7","9"]]

        validSudoku.isValidSudoku(c);
    }

    // box index = (row/3)*3 + (col/3) || integer division
    public boolean isValidSudoku(char[][] board) {
        HashMap<Integer, Integer>[] row = new HashMap[9];
        HashMap<Integer, Integer>[] col = new HashMap[9];
        HashMap<Integer, Integer>[] box = new HashMap[9];

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    continue;
                }
                char c = board[i][j];
                int num = (int) c;
                int boxIndex = (i / 3) * 3 + (j / 3);

                if (row[i] == null) {
                    row[i] = new HashMap<>();
                }
                if (col[j] == null) {
                    col[j] = new HashMap<>();
                }

                if (box[boxIndex] == null) {
                    box[boxIndex] = new HashMap<>();
                }

                if (null != row[i].put(num, 1)) {
                    return false;
                }
                if (null != col[j].put(num, 1)) {
                    return false;
                }
                if (null != box[boxIndex].put(num, 1)) {
                    return false;
                }
            }
        }

        return true;
    }
}
