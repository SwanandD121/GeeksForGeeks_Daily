//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class pair  {  
    long first, second;  
    public pair(long first, long second)  
    {  
        this.first = first;  
        this.second = second;  
    }  
}

class GFG {
	public static void main(String[] args) throws IOException
	{
	        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t =
            Integer.parseInt(br.readLine().trim()); // Inputting the testcases
        while(t-->0)
        {
            long n = Long.parseLong(br.readLine().trim());
            long a[] = new long[(int)(n)];
            // long getAnswer[] = new long[(int)(n)];
            String inputLine[] = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                a[i] = Long.parseLong(inputLine[i]);
            }
            long k = Long.parseLong(br.readLine().trim());
            
            Solution obj = new Solution();
            pair ans = obj.indexes(a, k);
            if (ans.first == -1 && ans.second == -1)
                System.out.println(-1);
            else
                System.out.println(ans.first+" "+ans.second);
            
        }
	}
}


// } Driver Code Ends


//User function Template for Java

/*
class pair  {  
    long first, second;  
    public pair(long first, long second)  
    {  
        this.first = first;  
        this.second = second;  
    }  
}
*/

class Solution {
    public long lastoccur(long arr[], long x){
        long i = 0;
        long j = arr.length - 1;
        long last = -1;
        while(i <= j){
            long mid = i + (j-i)/2;
            if(arr[(int) mid] == x){
                last = mid;
                i = mid+1;
            } else if (arr[(int) mid] > x){
                j = mid-1;
            } else {
                i = mid+1;
            }
        }
        return last;
    }
    
    public long firstoccur(long arr[], long x){
        long i = 0;
        long j = arr.length - 1;
        long first = -1;
        while(i <= j){
            long mid = i + (j-i)/2;
            if(arr[(int) mid] == x){
                first = mid;
                j = mid-1;
            } else if(arr[(int) mid] > x){
                j = mid-1;
            } else {
                i = mid+1;
            }
        }
        return first;
        
    }
    
    public pair indexes(long v[], long x)
    {
        // Your code goes here
        return new pair(firstoccur(v, x), lastoccur(v, x));
    }
}