//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
import java.lang.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int n = Integer.parseInt(in.readLine());
            String s = in.readLine();
            
            Solution ob = new Solution();
            System.out.println(ob.binaryAdd(n, s));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static String binaryAdd(int n, String s){
        // code here
        StringBuilder result = new StringBuilder();
        int carry = 1;
        
        for (int i = n - 1; i >= 0; i--) {
            if (s.charAt(i) == '0' && carry == 1) {
                result.insert(0, '1');
                carry = 0;
            } else if (s.charAt(i) == '1' && carry == 1) {
                result.insert(0, '0');
                carry = 1;
            } else {
                result.insert(0, s.charAt(i));
            }
        }
        
        if (carry == 1) {
            result.insert(0, '1');
        }
        
        return result.toString();

    }
}