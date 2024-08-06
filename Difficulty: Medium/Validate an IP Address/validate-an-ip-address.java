//{ Driver Code Starts
// Initial Template for Java

// Initial Template for Java

import java.io.*;
import java.util.*;

public class validip {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            String s = sc.next();
            Solution obj = new Solution();

            if (obj.isValid(s))
                System.out.println("true");
            else
                System.out.println("false");
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public boolean isValid(String s) {
        int n = s.length();
        if (n < 7) return false; 

        int dots = 0;
        for (int i = 0; i < n; i++) {
            if (i > 0 && s.charAt(i) == s.charAt(i - 1) && s.charAt(i) == '.') return false; // 2 continuous dots - invalid
            if (s.charAt(i) == '.') dots++;
        }
        if (dots != 3) return false; 


        String num = ""; 
        for (int i = 0; i <= n; i++) { 
            if (i == n || s.charAt(i) == '.') {
                if (num.length() == 0 || (num.charAt(0) == '0' && num.length() > 1) || num.length() > 3) return false;
                int number = Integer.parseInt(num);
                if (number > 255) return false;
                num = "";
            } else {
                num += s.charAt(i);
            }
        }
        return true;
    }

}