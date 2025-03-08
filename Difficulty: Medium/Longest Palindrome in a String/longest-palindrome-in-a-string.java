//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String S = read.readLine();

            Solution ob = new Solution();
            System.out.println(ob.longestPalindrome(S));
            System.out.println("~");
        }
    }
}

// } Driver Code Ends



class Solution {
    static String longestPalindrome(String s) {
        // code here
        int n = s.length(), st = 0, maxLen = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 2; j++) {
                int l = i, r = i + j;
                while (l >= 0 && r < n && s.charAt(l) == s.charAt(r)) {
                    l--; r++;
                }
                if (r - l - 1 > maxLen) {
                    maxLen = r - l - 1;
                    st = l + 1;
                }
            }
        }
        return s.substring(st, st + maxLen);
    }
}