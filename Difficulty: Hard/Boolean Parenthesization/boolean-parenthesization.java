//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;
import java.util.stream.*;

class GFG {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            String s = br.readLine();
            Solution obj = new Solution();
            System.out.println(obj.countWays(s));
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


// User function Template for Java
class Solution {
    static int countWays(String s) {
        return countWaysUtil(s, 0, s.length() - 1, true, new HashMap<>());
    }
    
    static int countWaysUtil(String s, int i, int j, boolean isTrue, HashMap<String, Integer> memo) {
        if (i > j) return 0;
        if (i == j) return isTrue ? (s.charAt(i) == 'T' ? 1 : 0) : (s.charAt(i) == 'F' ? 1 : 0);
        
        String key = i + "," + j + "," + isTrue;
        if (memo.containsKey(key)) return memo.get(key);
        
        int ways = 0;
        for (int k = i + 1; k < j; k += 2) {
            int leftTrue = countWaysUtil(s, i, k - 1, true, memo);
            int leftFalse = countWaysUtil(s, i, k - 1, false, memo);
            int rightTrue = countWaysUtil(s, k + 1, j, true, memo);
            int rightFalse = countWaysUtil(s, k + 1, j, false, memo);
            
            char op = s.charAt(k);
            if (op == '&') {
                ways += isTrue ? (leftTrue * rightTrue) : (leftTrue * rightFalse + leftFalse * rightTrue + leftFalse * rightFalse);
            } else if (op == '|') {
                ways += isTrue ? (leftTrue * rightTrue + leftTrue * rightFalse + leftFalse * rightTrue) : (leftFalse * rightFalse);
            } else if (op == '^') {
                ways += isTrue ? (leftTrue * rightFalse + leftFalse * rightTrue) : (leftTrue * rightTrue + leftFalse * rightFalse);
            }
        }
        
        memo.put(key, ways);
        return ways;
    }
}