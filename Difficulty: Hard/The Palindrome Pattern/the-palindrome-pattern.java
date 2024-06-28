//{ Driver Code Starts
// Initial Template for Java

// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {

        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

        Solution ob = new Solution();
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String input_line[] = read.readLine().trim().split("\\s+");
            int n = Integer.parseInt(input_line[0]);
            String input_line1[] = read.readLine().trim().split("\\s+");
            int[][] a = new int[n][n];
            int c = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    a[i][j] = Integer.parseInt(input_line1[c]);
                    c++;
                }
            }
            String ans = ob.pattern(a);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public boolean isPal(int[] arr){
        int i = 0;
        int j = arr.length - 1;
        while(i < j){
            if(arr[i] != arr[j]) return false;
            i++;
            j--;
        }
        return true;
    }
    public String pattern(int[][] arr) {
        // Code here
        int n = arr.length;
        
        // traversing each row
        for(int i = 0; i < n; i++){
            int cr[] = new int[n];
            for(int j = 0; j < n; j++){
                cr[j] = arr[i][j];
            }
            if(isPal(cr)){
                return Integer.toString(i) + " R";
            } 
        }
        
        // traversing each col
        for(int j = 0; j < n; j++){
            int cc[] = new int[n];
            for(int i = 0; i < n; i++){
                cc[i] = arr[i][j];
            }
            if(isPal(cc)){
                return Integer.toString(j) + " C";
            } 
        }
        
        return "-1";
        
    }
}
