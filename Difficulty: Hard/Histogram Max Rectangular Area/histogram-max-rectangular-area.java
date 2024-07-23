//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    
    
	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0){
		    long n = Long.parseLong(br.readLine().trim());
		    String inputLine[] = br.readLine().trim().split(" ");
		    long[] arr = new long[(int)n];
		    for(int i=0; i<n; i++)arr[i]=Long.parseLong(inputLine[i]);
		    System.out.println(new Solution().getMaxArea(arr, n));
		}
	}
}




// } Driver Code Ends


class Solution
{
    //Function to find largest rectangular area possible in a given histogram.
    public static long getMaxArea(long hist[], long n) {
        // your code here
        long maxArea = 0;
        
        // Arrays to store the indices of the next smaller elements on the right and left
        long[] nsr = new long[(int)n];
        long[] nsl = new long[(int)n];
        
        // Stack to find the next smaller element to the right
        Stack<Integer> s = new Stack<>();
        
        // Find next smaller elements on the right
        for (int i = (int)n - 1; i >= 0; i--) {
            while (!s.isEmpty() && hist[s.peek()] >= hist[i]) s.pop();
            if (s.isEmpty()) nsr[i] = n;
            else nsr[i] = s.peek();
            s.push(i);
        }
        
        // Clear the stack to be reused for finding the next smaller elements on the left
        s = new Stack<>();
        
        // Find next smaller elements on the left
        for (int i = 0; i < n; i++) {
            while (!s.isEmpty() && hist[s.peek()] >= hist[i]) s.pop();
            if (s.isEmpty()) nsl[i] = -1;
            else nsl[i] = s.peek();
            s.push(i);
        }
        
        // Calculate the maximum area using the widths determined by nsr and nsl
        for (int i = 0; i < n; i++) {
            long height = hist[i];
            long width = nsr[i] - nsl[i] - 1;
            long currArea = height * width;
            maxArea = Math.max(currArea, maxArea);
        }
        
        return maxArea;
        
    }
        
}



