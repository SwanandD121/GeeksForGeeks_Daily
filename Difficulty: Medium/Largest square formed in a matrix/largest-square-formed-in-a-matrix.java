//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int mat[][] = new int[n][m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    mat[i][j] = sc.nextInt();
                }
            }
            Solution ob = new Solution();
            System.out.println(ob.maxSquare(n, m, mat));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public static int solve(int[][] mat, int i, int j, int[] maxi, int[][] dp) {
        // base case
        if (i >= mat.length || j >= mat[0].length) {
            return 0;
        }
        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        // recursive case
        int right = solve(mat, i, j + 1, maxi, dp);
        int diagonal = solve(mat, i + 1, j + 1, maxi, dp);
        int down = solve(mat, i + 1, j, maxi, dp);

        if (mat[i][j] == 1) {
            dp[i][j] = 1 + Math.min(right, Math.min(diagonal, down));
            maxi[0] = Math.max(maxi[0], dp[i][j]);
            return dp[i][j];
        } else {
            return dp[i][j] = 0;
        }
    }
    static int maxSquare(int n, int m, int mat[][]) {
        // code here
        int[] maxi = new int[1];
        int[][] dp = new int[n][m];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        solve(mat, 0, 0, maxi, dp);
        return maxi[0];
    }
}