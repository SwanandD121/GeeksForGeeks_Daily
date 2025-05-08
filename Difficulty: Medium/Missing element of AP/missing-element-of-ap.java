//{ Driver Code Starts
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(reader.readLine().trim());

        Solution solution = new Solution();
        while (t-- > 0) {
            String input = reader.readLine().trim();
            String[] parts = input.split("\\s+");
            int[] arr = Arrays.stream(parts).mapToInt(Integer::parseInt).toArray();

            System.out.println(solution.findMissing(arr));

            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public int findMissing(int[] arr) {
        // code here
        int n = arr.length + 1;

        // Find common difference using the smallest consistent value
        int diff1 = arr[1] - arr[0];
        int diff2 = arr[2] - arr[1];
        int diff3 = arr[3] - arr[2];
        int diff = (diff1 == diff2 || diff1 == diff3) ? diff1 : diff2;

        // Use long to prevent overflow
        long first = arr[0];
        long expectedSum = (n * (2L * first + (n - 1L) * diff)) / 2;

        long actualSum = 0;
        for (int num : arr) {
            actualSum += num;
        }

        return (int)(expectedSum - actualSum);
    }
}
