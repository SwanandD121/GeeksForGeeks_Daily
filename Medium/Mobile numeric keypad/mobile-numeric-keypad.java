//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GfG {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            Solution ob = new Solution();
            System.out.println(ob.getCount(n));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    static long help(int i,int j,int n,long dp[][][]){
        if(i>3 || j>2 || i<0 || j<0)return 0;
        if(i==3 && (j==0 || j==2))return 0;
        if(n==1)return 1;
        if(dp[i][j][n]!=-1)return dp[i][j][n];
        n--;
        return dp[i][j][n+1] = help(i-1,j,n,dp)+help(i,j-1,n,dp)+
                            help(i+1,j,n,dp)+help(i,j+1,n,dp)+help(i,j,n,dp);
    }
    public long getCount(int n) {
        // Your code goes here
        long ans=0;
        long dp[][][] = new long[4][3][n+1];
        for(long temp[][]:dp){
            for(long temp2[]:temp){
                Arrays.fill(temp2,-1);
            }
        }
        for(int i=0;i<4;i++){
            for(int j=0;j<3;j++){
                if(i==3 && (j==0 || j==2))continue;
                ans+=help(i,j,n,dp);
            }
        }
        return ans;
    }
}