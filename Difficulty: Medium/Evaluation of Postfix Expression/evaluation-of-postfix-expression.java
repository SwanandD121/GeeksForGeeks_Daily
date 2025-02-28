//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.util.*;


// } Driver Code Ends


class Solution {
    public int evaluate(String[] arr) {
        // code here
        Stack<Integer> s = new Stack<>();
        for (String x : arr) {
            if ("+-*/".contains(x)) {
                int b = s.pop(), a = s.pop();
                s.push(x.equals("+") ? a + b : x.equals("-") ? a - b : x.equals("*") ? a * b : a / b);
            } else s.push(Integer.parseInt(x));
        }
        return s.pop();
    }
}


//{ Driver Code Starts.

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line = reader.readLine();
        int t = Integer.parseInt(line);
        while (t-- > 0) {
            line = reader.readLine();
            String[] arr = line.split(" ");
            Solution solution = new Solution();
            System.out.println(solution.evaluate(arr));
            System.out.println("~");
        }
    }
}

// } Driver Code Ends