//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main(String[] args) throws IOException
	{
	        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t =
            Integer.parseInt(br.readLine().trim()); // Inputting the testcases
        while(t-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            long a[] = new long[(int)(n)];
            // long getAnswer[] = new long[(int)(n)];
            String inputLine[] = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                a[i] = Long.parseLong(inputLine[i]);
            }
            
            Compute obj = new Compute();
            System.out.println(obj.longestSubarry(a, n));
            
        }
	}
}


// } Driver Code Ends


//User function Template for Java


class Compute {
    
    public long longestSubarry(long A[], int N)
    {
        int max = 0;
        int curr = 0;
        
        for(int i = 0; i < N; i++){
            if(A[i] >= 0){
                curr++;
            } else{
                max = Math.max(max, curr);
                curr = 0;
            }
        } 
        max = Math.max(max, curr);
        return max;
    }
}