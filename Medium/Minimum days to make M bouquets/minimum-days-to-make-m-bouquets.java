//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
       
        int t = sc.nextInt();
        while(t-- > 0){
            
            
           int M = sc.nextInt();
           int K = sc.nextInt();
            
            
            //int n = sc.nextInt();
            sc.nextLine();
            String s[]=sc.nextLine().split(" ");
            int n=s.length;
            int[] bloomDay = new int[n];
            for(int i=0;i<n;i++) bloomDay[i]=Integer.parseInt(s[i]);
            
            Solution obj = new Solution();
            int res = obj.solve(M, K, bloomDay);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution {
    public static boolean possible(int[] arr, int day, int m, int k){
        int count = 0;
        int noOB = 0;
        for(int i = 0; i < arr.length; i++){
            if(arr[i] <= day){
                count++;
            } else {
                noOB += (count/k);
                count = 0;
            }
        }
        noOB += (count/k);
        return noOB >= m;
    }
    public static int solve(int M, int K, int[] bloomDay) {
       if((long) M*K > bloomDay.length) return -1;
       
       // min and max of array
       int min = Integer.MAX_VALUE;
       int max = Integer.MIN_VALUE;
       for(int i = 0; i < bloomDay.length; i++){
           min = Math.min(min, bloomDay[i]);
           max = Math.max(max, bloomDay[i]);
       }
       
        // Binary Search from min to max
        int i = min;
        int j = max;
        while(i <= j){
            int mid = i + (j-i)/2;
            if(possible(bloomDay, mid, M, K)) j = mid-1;
            else i = mid+1;
        }
        return i;
    }
}