//{ Driver Code Starts
import java.io.*;
import java.text.DecimalFormat;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        while (t-- > 0) {
            double b = sc.nextDouble();
            int e = sc.nextInt();
            Solution ob = new Solution();
            System.out.printf("%.5f\n", ob.power(b, e));
            System.out.println("~");
        }
        sc.close();
    }
}


// } Driver Code Ends
// User function Template for Java
class Solution {
    double power(double b, int e) {
        // code here
        if (e == 0) return 1.0;
        double result = 1.0;
        long exp = e;
        if (exp < 0) {
            b = 1 / b;
            exp = -exp;
        }
        while (exp > 0) {
            if ((exp & 1) == 1) result *= b;
            b *= b; 
            exp >>= 1;
        }
        return result;
    }
}

//{ Driver Code Starts.
// } Driver Code Ends