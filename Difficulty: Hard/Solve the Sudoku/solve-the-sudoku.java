//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = 9;
            int matrix[][] = new int[n][n];
            // String st[] = read.readLine().trim().split("\\s+");
            int k = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) matrix[i][j] = sc.nextInt();
            }
            Solution ob = new Solution();
            ob.solveSudoku(matrix);
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) System.out.print(matrix[i][j] + " ");
                System.out.println();
            }
            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    // Function to find a solved Sudoku.
    static void solveSudoku(int[][] mat) {
        solve(mat);
    }

    static boolean solve(int[][] mat) {
        int[] cell = findEmptyCell(mat);
        if (cell == null) return true; // Sudoku solved
        int r = cell[0], c = cell[1];

        for (int num = 1; num <= 9; num++) {
            if (isValid(mat, r, c, num)) {
                mat[r][c] = num;
                if (solve(mat)) return true;
                mat[r][c] = 0; // backtrack
            }
        }
        return false; // no valid number found
    }

    static int[] findEmptyCell(int[][] mat) {
        for (int i = 0; i < 9; i++) for (int j = 0; j < 9; j++) if (mat[i][j] == 0) return new int[]{i, j}; // return the first empty cell
        return null; // no empty cell found
    }

    static boolean isValid(int[][] mat, int r, int c, int num) {
        for (int i = 0; i < 9; i++) if (mat[r][i] == num || mat[i][c] == num) return false;
        int startRow = 3 * (r / 3);
        int startCol = 3 * (c / 3);
        for (int i = 0; i < 3; i++) for (int j = 0; j < 3; j++) if (mat[startRow + i][startCol + j] == num) return false;
        return true;
    }
}