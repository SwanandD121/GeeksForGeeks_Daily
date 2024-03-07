//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            inputLine = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine[0]);
            int[] arr = new int[n];
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            int ans = new Solution().countZeroes(arr, n);
            System.out.println(ans);
        }
    }
}


// } Driver Code Ends


//User function Template for Java

class Solution {
    int countZeroes(int[] arr, int n) {
        // code here
        if(arr[0] == 0){
            return n;
        }
        int start = 0;
        int end = n-1;
        int count = 0;
        while(start <= end){
            int mid = start + (end - start)/2;
            if(arr[mid] == 0){
                count = n - mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return count;
    }

}
