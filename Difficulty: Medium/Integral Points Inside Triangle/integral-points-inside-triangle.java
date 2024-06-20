//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String S[] = read.readLine().split(" ");
            long p[] = new long[2];
            long q[] = new long[2];
            long r[] = new long[2];
            p[0] = Long.parseLong(S[0]);
            p[1] = Long.parseLong(S[1]);
            q[0] = Long.parseLong(S[2]);
            q[1] = Long.parseLong(S[3]);
            r[0] = Long.parseLong(S[4]);
            r[1] = Long.parseLong(S[5]);
            Solution ob = new Solution();
            long ans = ob.InternalCount(p, q, r);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public long gcd(long a, long b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }
    public long boundaryCount(long[] p, long[] q) {
        if (p[0] == q[0]) return Math.abs(p[1] - q[1]) - 1;
        if (p[1] == q[1]) return Math.abs(p[0] - q[0]) - 1;
        return gcd(Math.abs(p[0] - q[0]), Math.abs(p[1] - q[1])) - 1;
    }
    long InternalCount(long p[], long q[], long r[]) {
        // code here
        long boundary = boundaryCount(p, q) + boundaryCount(p, r) + boundaryCount(q, r) + 3;
        long area = Math.abs(
            p[0] * (q[1] - r[1]) + q[0] * (r[1] - p[1]) + r[0] * (p[1] - q[1])
        );
        return (area - boundary + 2) / 2;
    }
};