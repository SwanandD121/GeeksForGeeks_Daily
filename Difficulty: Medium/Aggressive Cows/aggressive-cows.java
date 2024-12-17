//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());

        while (tc-- > 0) {

            String[] str = br.readLine().trim().split(" ");
            int[] a = new int[str.length];
            for (int i = 0; i < str.length; i++) {
                a[i] = Integer.parseInt(str[i]);
            }
            String[] nk = br.readLine().trim().split(" ");
            int k = Integer.parseInt(nk[0]);
            Solution sln = new Solution();
            int ans = sln.aggressiveCows(a, k);

            System.out.println(ans);
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


// User function Template for Java
class Solution {
    public static boolean isPossible(int[] arr, int mid, int k){
        Arrays.sort(arr);
        int lastpos = arr[0];
        int c = 1;
        for(int i = 1; i < arr.length; i++) {
            if(arr[i] - lastpos >= mid) {
                c++;
                lastpos = arr[i];
            }
            if(c == k) return true;
        }
        return false;
    }
    public static int aggressiveCows(int[] stalls, int k) {
        // code here
        int i = 1;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(int a : stalls) {
            if(a > max) max = a;
            if(a < min) min = a;
        }
        int j = max - min;
        int ans = 0;
        
        while(i <= j) {
            int mid = i + (j-i)/2;
            if(isPossible(stalls, mid, k)) {
                ans = mid;
                i = mid + 1;
            } else {
                j = mid - 1;
            }
        }
        return ans;
    }
}