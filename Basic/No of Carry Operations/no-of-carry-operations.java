//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
import java.lang.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            
            String S[] = read.readLine().split(" ");
            
            Long A = Long.parseLong(S[0]);
            Long B = Long.parseLong(S[1]);

            Solution ob = new Solution();

            System.out.println(ob.countCarry(A,B));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    static int countCarry(Long A , Long B){
        // code here
        int carry = 0; 
        int carryCount = 0; 

        while (A > 0 || B > 0) {
            int digitA = (int)(A % 10);
            int digitB = (int)(B % 10);

            int sum = digitA + digitB + carry;

            carry = sum / 10;

            if (carry > 0) {
                carryCount++;
            }

            A /= 10;
            B /= 10;
        }

        return carryCount;
    }
};