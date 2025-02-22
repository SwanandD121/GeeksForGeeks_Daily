//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while (t-- > 0) {
            String S = in.readLine();

            Solution ob = new Solution();
            System.out.println(ob.maxLength(S));

            System.out.println("~");
        }
    }
}
// } Driver Code Ends



class Solution {
    static int maxLength(String s) {
        int l = 0, r = 0, maxLen = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') l++;
            else r++;
            if (l == r) maxLen = Math.max(maxLen, 2 * r);
            else if (r > l) l = r = 0;
        }
        l = r = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == ')') r++;
            else l++;
            if (l == r) maxLen = Math.max(maxLen, 2 * l);
            else if (l > r) l = r = 0;
        }
        return maxLen;
    }
}