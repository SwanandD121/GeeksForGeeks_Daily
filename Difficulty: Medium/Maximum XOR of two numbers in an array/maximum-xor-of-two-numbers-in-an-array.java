//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            String s = br.readLine();
            String[] S = s.split(" ");
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(S[i]);
            }
            Solution ob = new Solution();
            System.out.println(ob.maxXor(arr));

            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    static class TrieNode {
        TrieNode[] child = new TrieNode[2];
    }

    public int maxXor(int[] arr) {
        TrieNode root = new TrieNode();
        for (int num : arr) {
            TrieNode node = root;
            for (int i = 31; i >= 0; i--) {
                int bit = (num >> i) & 1;
                if (node.child[bit] == null)
                    node.child[bit] = new TrieNode();
                node = node.child[bit];
            }
        }

        int max = 0;
        for (int num : arr) {
            TrieNode node = root;
            int currXor = 0;
            for (int i = 31; i >= 0; i--) {
                int bit = (num >> i) & 1;
                if (node.child[1 - bit] != null) {
                    currXor |= (1 << i);
                    node = node.child[1 - bit];
                } else {
                    node = node.child[bit];
                }
            }
            max = Math.max(max, currXor);
        }
        return max;
    }
}