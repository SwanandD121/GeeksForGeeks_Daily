//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String arr[] = read.readLine().trim().split(" ");

            Solution ob = new Solution();
            System.out.println(ob.longestCommonPrefix(arr));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public String longestCommonPrefix(String arr[]) {
        // code here
        String ans = "";
        int minLen = Integer.MAX_VALUE;
        int count = 0;
        for(int i = 0; i < arr.length; i++){
            if(arr[i].length() < minLen){
                minLen = arr[i].length();
                ans = arr[i];
            }
        }
        
        for(int i = 0; i < minLen; i++){
            for(int j = 0; j < arr.length; j++){
                if(arr[j].charAt(i) != ans.charAt(i)){
                    if(i == 0) return "-1";
                    return ans.substring(0, i);
                }
            }   
        }
        return ans;
    }
}