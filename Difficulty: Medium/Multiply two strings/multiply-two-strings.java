//{ Driver Code Starts
// Initial Template for Java

import java.math.*;
import java.util.*;

class Multiply {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            String a = sc.next();
            String b = sc.next();
            Solution g = new Solution();
            System.out.println(g.multiplyStrings(a, b));

            System.out.println("~");
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public String multiplyStrings(String s1, String s2) {
        int sign = 1;
        if (s1.charAt(0) == '-') {
            sign *= -1;
            s1 = s1.substring(1);
        }
        if (s2.charAt(0) == '-') {
            sign *= -1;
            s2 = s2.substring(1);
        }
        
        int n = s1.length();
        int m = s2.length();
        int[] res = new int[n + m];
        
        for (int i = n - 1; i >= 0; i--) {
            if (s1.charAt(i) == '0' && res.length == 0) continue;
            for (int j = m - 1; j >= 0; j--) {
                int mul = (s1.charAt(i) - '0') * (s2.charAt(j) - '0');
                int sum = mul + res[i + j + 1];
                
                res[i + j + 1] = sum % 10;
                res[i + j] += sum / 10;
            }
        }
        
        StringBuilder ans = new StringBuilder();
        int idx = 0;
        while (idx < res.length && res[idx] == 0) idx++;
        for (; idx < res.length; idx++) {
            ans.append(res[idx]);
        }
        
        if (ans.length() == 0) return "0";
        
        if (sign == -1) ans.insert(0, '-');
        
        return ans.toString();
    }
}