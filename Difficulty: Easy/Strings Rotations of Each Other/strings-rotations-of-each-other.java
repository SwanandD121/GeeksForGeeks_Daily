//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {

    public static void main(String[] args) throws IOException {

        // taking input using BufferedReader class
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // taking total count of testcases
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            // Reading the two Strings
            String s1 = br.readLine();
            String s2 = br.readLine();

            // Creating an object of class Rotate
            Solution obj = new Solution();

            // calling areRotations method
            // of class Rotate and printing
            //"1" if it returns true
            // else "0"
            if (obj.areRotations(s1, s2)) {
                System.out.println("true");
            } else {
                System.out.println("false");
            }
        }
    }
}
// } Driver Code Ends



class Solution {
    // Function to check if two strings are rotations of each other or not.
    public static boolean areRotations(String s1, String s2) {
    // If lengths of s1 and s2 are not equal, they can't be rotations
            if (s1.length() != s2.length()) return false;
            
            String concatenated = s1 + s1;
            return kmpSearch(concatenated, s2);
        }
        
        private static boolean kmpSearch(String text, String pattern) {
            int[] lps = computeLPSArray(pattern);
            int i = 0; 
            int j = 0; 
        
            while (i < text.length()) {
                if (text.charAt(i) == pattern.charAt(j)) {
                    i++;
                    j++;
                }
        
                if (j == pattern.length()) {
                    return true; 
                } else if (i < text.length() && text.charAt(i) != pattern.charAt(j)) {
                    if (j != 0) {
                        j = lps[j - 1];
                    } else {
                        i++;
                    }
                }
            }
            return false; 
        }
        
        private static int[] computeLPSArray(String pattern) {
            int[] lps = new int[pattern.length()];
            int length = 0;
            int i = 1;
        
            while (i < pattern.length()) {
                if (pattern.charAt(i) == pattern.charAt(length)) {
                    length++;
                    lps[i] = length;
                    i++;
                } else {
                    if (length != 0) {
                        length = lps[length - 1];
                    } else {
                        lps[i] = 0;
                        i++;
                    }
                }
            }
            return lps;
        }

}