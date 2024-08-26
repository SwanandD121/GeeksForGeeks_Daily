//{ Driver Code Starts
import java.util.*;

class WildcardPattern {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        while (t > 0) {
            String pat = sc.nextLine();
            String text = sc.nextLine();
            Solution g = new Solution();
            System.out.println(g.wildCard(pat, text));
            t--;
        }
    }
}
// } Driver Code Ends


class Solution {
    private boolean stars(String p, int a) {
        for (int i = 0; i <= a; i++) {
            if (p.charAt(i) != '*') return false;
        }
        return true;
    }

    private int check(int i, int j, String pattern, String str, int[][] dp) {
        // Base cases
        if (i < 0 && j < 0) return 1;
        if (i < 0 && j >= 0) return 0;
        if (i >= 0 && j < 0) return stars(pattern, i) ? 1 : 0;
        
        // Memoization check
        if (dp[i][j] != -1) return dp[i][j];
        
        if (pattern.charAt(i) == str.charAt(j) || pattern.charAt(i) == '?') {
            return dp[i][j] = check(i - 1, j - 1, pattern, str, dp);
        } else if (pattern.charAt(i) == '*') {
            return dp[i][j] = Math.max(check(i, j - 1, pattern, str, dp), check(i - 1, j, pattern, str, dp));
        } else {
            return dp[i][j] = 0;
        }
    }

    public int wildCard(String pattern, String str) {
        int n = pattern.length();
        int m = str.length();
        int[][] dp = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                dp[i][j] = -1;
            }
        }
        return check(n - 1, m - 1, pattern, str, dp);
    }
}

