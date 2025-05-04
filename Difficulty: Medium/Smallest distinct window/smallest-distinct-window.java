//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            String str = br.readLine();

            Solution obj = new Solution();
            System.out.println(obj.findSubString(str));

            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public int findSubString(String str) {
        // code here
        int n = str.length();
        Set<Character> set = new HashSet<>();
        for (char c : str.toCharArray()) set.add(c);
        int total = set.size();
        
        int[] freq = new int[128];
        int count = 0, minLen = n + 1;
        int start = 0;
        
        for (int end = 0; end < n; end++) {
            char c = str.charAt(end);
            freq[c]++;
            if (freq[c] == 1) count++;
            
            while (count == total) {
                minLen = Math.min(minLen, end - start + 1);
                char sc = str.charAt(start);
                freq[sc]--;
                if (freq[sc] == 0) count--;
                start++;
            }
        }
        
        return minLen;
    }
}