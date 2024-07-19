//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;


// } Driver Code Ends

class Solution {
    // Function to calculate the span of stockâ€™s price for all n days.
    public static int[] calculateSpan(int price[], int n) {
        // Your code here
        int[] res = new int[n];
        
        Stack<Integer> s = new Stack<>();
        res[0] = 1;
        s.push(0);
        
        for(int i = 1; i < n; i++){
            while(!s.isEmpty() && price[i] >= price[s.peek()]){
                s.pop();
            }
            if(s.isEmpty()) res[i] = i+1;
            else {
                int prevHigh = s.peek();
                res[i] = i - prevHigh;
            }
            s.push(i);
        }
        return res;
    }
}

//{ Driver Code Starts.

class gfg {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int a[] = new int[n];

            int i = 0;
            for (i = 0; i < n; i++) a[i] = sc.nextInt();

            int[] s = new Solution().calculateSpan(a, n);

            for (i = 0; i < n; i++) {
                System.out.print(s[i] + " ");
            }

            System.out.println();
        }
    }
}
// } Driver Code Ends