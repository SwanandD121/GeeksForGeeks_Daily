//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0)
        {
            long N=sc.nextLong();
			
            Solution ob = new Solution();
            ArrayList<Long> ans = ob.factorialNumbers(N);
            for(long num : ans){
                System.out.print(num+" ");
            }
            System.out.println();
        }
    }
}

// } Driver Code Ends


//User function Template for Java
class Solution{
    static long findfact(long n){
        if(n == 1){
            return 1;
        }
        return n * findfact(n-1);
    }
    static ArrayList<Long> factorialNumbers(long N){
        // code here
        ArrayList<Long> ans = new ArrayList<>();
        
        long i = 1;
        while(true){
            long fact = findfact(i);
            if(fact > N){
                break;
            }
            ans.add(fact);
            i++;
        }
        return ans;
    }
}