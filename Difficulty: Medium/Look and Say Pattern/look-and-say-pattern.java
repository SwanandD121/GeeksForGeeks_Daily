//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());

        while (t-- > 0) {
            int n = Integer.parseInt(read.readLine());

            Solution ob = new Solution();

            System.out.println(ob.countAndSay(n));

            System.out.println("~");
        }
    }
}
// } Driver Code Ends


class Solution {
    public String countAndSay(int n) {
        // code here
        String s = "1";
        for (int i = 1; i < n; i++) {
            StringBuilder temp = new StringBuilder();
            int count = 1;
            for (int j = 1; j < s.length(); j++) {
                if (s.charAt(j) == s.charAt(j - 1)) {
                    count++;
                } else {
                    temp.append(count).append(s.charAt(j - 1));
                    count = 1;
                }
            }
            temp.append(count).append(s.charAt(s.length() - 1));
            s = temp.toString();
        }
        return s;
    }
}
