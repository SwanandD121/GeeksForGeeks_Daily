//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    
	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0){
		    System.out.println(new Solution().evaluatePostFix(br.readLine().trim()));
		}
	}
}
// } Driver Code Ends


class Solution
{
    //Function to evaluate a postfix expression.
    public static int evaluatePostFix(String s)
    {
        // Your code here
        Stack<Integer> st = new Stack<>(); // There are no characters/symbols so stack is integer type

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            
            if (Character.isDigit(ch)) {
                st.push(Character.getNumericValue(ch)); //Push numbers only
            } else {
                // Pop two operands from the stack for the operation
                int val2 = st.pop();
                int val1 = st.pop();
                int res = 0;

                // Perform the operation and push the result 
                if (ch == '+') {
                    res = val1 + val2;
                } else if (ch == '-') {
                    res = val1 - val2;
                } else if (ch == '*') {
                    res = val1 * val2;
                } else if (ch == '/') {
                    res = val1 / val2;
                }
                st.push(res);
            }
        }
        
        int res = st.pop();
        return res;

    }
}