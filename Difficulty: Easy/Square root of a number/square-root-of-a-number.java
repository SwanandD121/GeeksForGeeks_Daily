//{ Driver Code Starts
import java.util.Scanner;

class SquartRoot {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0) {
            long a = sc.nextInt();
            Solution obj = new Solution();
            System.out.println(obj.floorSqrt(a));
            t--;
        }
    }
}
// } Driver Code Ends


/*You are required to complete
this function*/

// Function to find square root
// x: element to find square root
class Solution {
    long floorSqrt(long n) {
        // Your code here
        if(n == 1) return n;
        long i = 1;
        long j = n/2;
        // long root = 0;
        
        while(i <= j){
            long mid = i + (j-i)/2;
            if(mid*mid == n) return mid;
            else if(mid*mid < n){
                i = mid+1;
                // root = mid;
            } 
            else j = mid-1;
        }
        
        return j;
    }
}
