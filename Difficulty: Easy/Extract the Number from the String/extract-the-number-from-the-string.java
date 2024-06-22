//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;
import java.util.regex.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String S = read.readLine();
            Solution ob = new Solution();
            System.out.println(ob.ExtractNumber(S));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    long ExtractNumber(String sentence) {
        // code here
        Pattern pattern = Pattern.compile("\\b\\d+\\b");
        Matcher matcher = pattern.matcher(sentence);

        ArrayList<Long> numbers = new ArrayList<>();

        while (matcher.find()) {
            String numberStr = matcher.group();
            if (!numberStr.contains("9")) {
                numbers.add(Long.parseLong(numberStr));
            }
        }

        if (numbers.isEmpty()) {
            return -1;
        } else {
            return Collections.max(numbers);
        }
    }
}