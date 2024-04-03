//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String string1 = read.readLine();
            String string2 = read.readLine();

            Solution ob = new Solution();
            System.out.println(ob.removeChars(string1,string2) );
        }
    }
}


// } Driver Code Ends


//User function Template for Java
class Solution{
    static String removeChars(String string1, String string2){
        // code here
        boolean[] removeChar = new boolean[26]; 

        for (char c : string2.toCharArray()) {
            removeChar[c - 'a'] = true;
        }

        StringBuilder result = new StringBuilder();

        for (char c : string1.toCharArray()) {
            if (!removeChar[c - 'a']) {
                result.append(c);
            }
        }

        return result.toString();
    }
}