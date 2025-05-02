//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] str = br.readLine().trim().split(" ");
            int[] arr = new int[str.length];
            for (int i = 0; i < str.length; i++) {
                arr[i] = Integer.parseInt(str[i]);
            }

            int ans = new Solution().findMaximum(arr);
            System.out.println(ans);
            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public int findMaximum(int[] arr) {
        // code here
        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if ((mid == 0 || arr[mid - 1] < arr[mid]) &&
                (mid == arr.length - 1 || arr[mid] > arr[mid + 1])) {
                return arr[mid];
            }
            else if (arr[mid] < arr[mid + 1]) low = mid + 1;
            else high = mid - 1;
        }

        return -1;
    }
}