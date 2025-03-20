//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Sorting {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int g = 0; g < t; g++) {
            String[] str = (br.readLine()).trim().split(" ");
            int arr[] = new int[str.length];
            for (int i = 0; i < str.length; i++) arr[i] = Integer.parseInt(str[i]);
            System.out.println(new Solution().maxProfit(arr));
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


class Solution {
    public static int maxProfit(int[] prices) {
        // code here
        int t1b = Integer.MIN_VALUE, t1s = 0, t2b = Integer.MIN_VALUE, t2s = 0;
        for (int price : prices) {
            t1b = Math.max(t1b, -price);
            t1s = Math.max(t1s, t1b + price);
            t2b = Math.max(t2b, t1s - price);
            t2s = Math.max(t2s, t2b + price);
        }
        return t2s;
    }
}
