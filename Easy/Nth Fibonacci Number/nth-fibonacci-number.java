//{ Driver Code Starts
//Initial Template for Java
import java.util.*;
import java.io.*;
class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(read.readLine());
            Solution ob = new Solution();

            System.out.println(ob.nthFibonacci(n));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

//User function Template for Java
class Solution {
    static final int mod = 1000000007;
    // static HashMap<Integer, Integer> map = new HashMap<>();
    // static int fibonum(int n){
    //     if(n == 0 || n == 1){
    //         return n;
    //     }
    //     if (map.containsKey(n)) {
    //         return map.get(n);
    //     }
    //     int fn = (fibonum(n-1) + fibonum(n-2)) % mod;
    //     map.put(n, fn);
    //     return fn;
    // }
    static int nthFibonacci(int n){
        // code here
        // return fibonum(n) % mod;
        if(n == 0 || n == 1){
            return n;
        }
        
        int a = 0;
        int b = 1;
        int sum;
        for(int i = 2; i <= n; i++){
            sum = (a+b) % mod;
            a = b;
            b = sum;
        }
        return b;
    }
}