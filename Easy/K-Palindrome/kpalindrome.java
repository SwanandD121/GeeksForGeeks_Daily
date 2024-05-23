//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while (t-- > 0) {
            String input_line[] = in.readLine().trim().split("\\s+");
            int n = Integer.parseInt(input_line[0]);
            int k = Integer.parseInt(input_line[1]);
            String str = in.readLine();

            Solution ob = new Solution();
            System.out.println(ob.kPalindrome(str, n, k));
        }
    }
}
// } Driver Code Ends


class Solution {
    public int kPalindrome(String str, int n, int k) {
        // code here
        int[][] dp = new int[n + 1][n + 1];

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0 || j == 0)
                    dp[i][j] = i + j;
                else if (str.charAt(i - 1) == str.charAt(n - j))
                    dp[i][j] = dp[i - 1][j - 1];
                else
                    dp[i][j] = 1 + Math.min(dp[i - 1][j], dp[i][j - 1]);
            }
        }

        if(dp[n][n] <= k * 2) return 1;
        else return 0;
    }
}