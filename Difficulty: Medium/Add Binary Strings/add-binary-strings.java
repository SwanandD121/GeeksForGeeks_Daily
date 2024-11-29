//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            String a, b;
            a = sc.next();
            b = sc.next();
            Solution ob = new Solution();
            System.out.println(ob.addBinary(a, b));

            System.out.println("~");
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public String addBinary(String s1, String s2) {
        // code here
        StringBuilder sb1 = new StringBuilder(s1);
        StringBuilder sb2 = new StringBuilder(s2);
        String revs1 = sb1.reverse().toString();
        String revs2 = sb2.reverse().toString();
        
        StringBuilder newsb = new StringBuilder();
        int carry = 0;
        
        int i = 0;
        for (; i < Math.min(s1.length(), s2.length()); i++) {
            int a = revs1.charAt(i) - '0';
            int b = revs2.charAt(i) - '0';
            int sum = a + b + carry;
            newsb.append(sum % 2);
            carry = sum / 2;
        }
        
        while (i < s1.length()) {
            int a = revs1.charAt(i) - '0';
            int sum = a + carry;
            newsb.append(sum % 2);
            carry = sum / 2;
            i++;
        }
        
        while (i < s2.length()) {
            int b = revs2.charAt(i) - '0';
            int sum = b + carry;
            newsb.append(sum % 2);
            carry = sum / 2;
            i++;
        }
        
        if (carry > 0) newsb.append(carry);
        
        String res = newsb.reverse().toString().replaceFirst("^0+", "");
        
        return res.isEmpty() ? "0" : res;
    }
}