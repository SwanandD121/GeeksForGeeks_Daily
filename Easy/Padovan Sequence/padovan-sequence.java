//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
class GfG
{
    public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    int n = sc.nextInt();
                    Solution ob = new Solution();
                    System.out.println(ob.padovanSequence(n));
                }
        }
}    
// } Driver Code Ends


//User function Template for Java

class Solution
{
    public static final int mod = 1000000007;
    public int padovanSequence(int n)
    {
        //code here.
        if(n==0 || n == 1 || n == 2) return 1;
        
        int padovan[] = new int[n+1];
        padovan[0] = 1;
        padovan[1] = 1;
        padovan[2] = 1;
        
        for(int i = 3; i <=n; i++){
            padovan[i] = (padovan[i-2] + padovan[i-3]) % mod;
        }
        return padovan[n];
    }
    
}
