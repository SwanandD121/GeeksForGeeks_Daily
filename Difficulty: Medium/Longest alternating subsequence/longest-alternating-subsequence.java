//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.util.*;


// } Driver Code Ends
// User function Template for Java
//Back-end complete function Template for Java
class Solution {
    public int alternatingMaxLength(int[] arr) {
        // code here
        if(arr.length < 2) return arr.length;
        
        int cb = 1;
        int bc = 1;
        
        for(int i = 1; i < arr.length; i++){
            if(arr[i] > arr[i-1]) cb = 1 + bc;
            else if(arr[i] < arr[i-1]) bc = 1 + cb;
        }
        return Math.max(cb, bc);
    }
}

//{ Driver Code Starts.

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        while (tc-- > 0) {
            String s[] = br.readLine().trim().split(" ");
            int[] nums = new int[s.length];
            for (int i = 0; i < s.length; i++) {
                nums[i] = Integer.parseInt(s[i]);
            }
            Solution obj = new Solution();
            int ans = obj.alternatingMaxLength(nums);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends