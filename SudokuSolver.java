package com.kkd.leetcode.array;

// backtracking
public class SudokuSolver {
    public static void main(String[] args) {
        char[][] c = {
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };
        SudokuSolver s = new SudokuSolver();
        s.solveSudoku(c);
    }

    public boolean solveSudoku(char[][] board) {
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                if (board[row][col] != '.') {
                    continue;
                }

                for (int i = 1; i <= 9; i++) {
                    if (isValidEntry(board, i, row, col)) {
                        board[row][col] = Character.forDigit(i, 10);
                        if (solveSudoku(board)) {
                            return true;
                        } else {
                            board[row][col] = '.';
                        }
                    }
                }
                return false;
            }

        }
        return true;

    }


    private boolean isValidEntry(char[][] board, int num, int row, int col) {
        char c = Character.forDigit(num, 10);
        for (int i = 0; i < 9; i++) {
            if (board[i][col] == c) {
                return false;
            }
            if (board[row][i] == c) {
                return false;
            }
            if (board[(row / 3) * 3 + i / 3][(col / 3) * 3 + i % 3] == c) { // check box row start index and box col start index
                return false;
            }
        }
        return true;
    }
}
