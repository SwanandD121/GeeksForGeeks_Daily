//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {   
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0)
        {
            int a = sc.nextInt();
            long b = sc.nextLong();

            Solution ob = new Solution();
            System.out.println(ob.power(a, b));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static final int mod = 1000000007;
    static long power(int a, long b){
        //complete the function here
        if(b == 0){
            return 1;
        }
        long halfpow = power(a, b/2);
        long halfPowSq = (halfpow * halfpow) % mod;

        if(b % 2 == 1){
            halfPowSq = (a * halfPowSq) % mod;
        }
        return halfPowSq;
    }
}