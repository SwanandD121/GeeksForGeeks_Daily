//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GfG {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int k = sc.nextInt();
            String str = sc.next();
            Solution obj = new Solution();
            System.out.println(obj.findMaximumNum(str, k));

            System.out.println("~");
        }
    }
}
// } Driver Code Ends




class Solution {
    // Function to find the largest number after k swaps.
    String max = "";

    public String findMaximumNum(String s, int k) {
        max = s;
        char[] arr = s.toCharArray();
        solve(arr, k, 0);
        return max;
    }

    private void solve(char[] arr, int k, int idx) {
        if (k == 0 || idx == arr.length) return;

        char maxDigit = arr[idx];
        for (int i = idx + 1; i < arr.length; i++) {
            if (arr[i] > maxDigit) {
                maxDigit = arr[i];
            }
        }

        if (maxDigit != arr[idx]) k--;

        for (int i = arr.length - 1; i >= idx; i--) {
            if (arr[i] == maxDigit) {
                swap(arr, idx, i);
                String curr = new String(arr);
                if (curr.compareTo(max) > 0) max = curr;
                solve(arr, k, idx + 1);
                swap(arr, idx, i);
            }
        }
    }

    private void swap(char[] arr, int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}