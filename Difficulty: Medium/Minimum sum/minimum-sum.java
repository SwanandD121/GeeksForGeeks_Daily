//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            String arr[] = br.readLine().split(" ");
            int a[] = new int[arr.length];

            for (int i = 0; i < arr.length; i++) {
                a[i] = Integer.parseInt(arr[i]);
            }
            Solution obj = new Solution();
            int f = 0;
            String A = obj.minSum(a);
            System.out.println(A);
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    String minSum(int[] arr) {
        // code here
        StringBuilder n1 = new StringBuilder();
        StringBuilder n2 = new StringBuilder();
        
        Arrays.sort(arr);
        for (int i = 0; i < arr.length; i++) {
            if (i % 2 == 0) n1.append(arr[i]);
            else n2.append(arr[i]);
        }

        n1.reverse();
        n2.reverse();

        StringBuilder ans = new StringBuilder();
        int i = 0, j = 0, carry = 0;

        while (i < n1.length() || j < n2.length() || carry > 0) {
            int sum = carry;
            if (i < n1.length()) sum += n1.charAt(i++) - '0';
            if (j < n2.length()) sum += n2.charAt(j++) - '0';

            carry = sum / 10;
            ans.append(sum % 10);
        }

        while (ans.length() > 1 && ans.charAt(ans.length() - 1) == '0') {
            ans.deleteCharAt(ans.length() - 1);
        }

        return ans.reverse().toString();
    }
}
