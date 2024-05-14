//{ Driver Code Starts
//Initial Template for Java



import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            inputLine = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine[0]);
            int x = Integer.parseInt(inputLine[1]);
            int[] arr = new int[n];
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            int ans = new Solution().count(arr, n, x);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


//User function Template for Java



class Solution {
    public static int findFirst(int[] arr, int x){
        int n = arr.length;
        int start = 0;
        int last = n-1;
        int res = -1;
        while(start <= last){
            int mid = start + (last - start)/2;
            if(arr[mid] == x){
                res = mid;
                last = mid - 1;
            } else if(arr[mid] > x){
                last = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return res;
    }
    public static int findLast(int[] arr, int x){
        int n = arr.length;
        int start = 0;
        int last = n-1;
        int res = -1;
        while(start <= last){
            int mid = start + (last - start)/2;
            if(arr[mid] == x){
                res = mid;
                start = mid + 1;
            } else if(arr[mid] > x){
                last = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return res;
    }
    int count(int[] arr, int n, int x) {
        // code here
        if(findFirst(arr, x) == -1) return 0;
        
        return findLast(arr, x) - findFirst(arr, x) + 1;
        
    }
}