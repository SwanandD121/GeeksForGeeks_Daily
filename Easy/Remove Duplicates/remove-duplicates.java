//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String s = read.readLine();
            
            Solution ob = new Solution();
            String result = ob.removeDups(s);
            
            System.out.println(result);
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    String removeDups(String S) {
        // code here
        StringBuilder ans = new StringBuilder();
        HashMap<Character, Integer> map = new HashMap<>();
        
        for(int i = 0; i < S.length(); i++){
            if(map.get(S.charAt(i)) == null){
                ans.append(S.charAt(i));
                map.put(S.charAt(i), 1);
            }
        }
        return ans.toString();
    }
}