//{ Driver Code Starts
//Initial template for JAVA

import java.lang.*;
import java.io.*;
import java.util.*;


// } Driver Code Ends
//User function template for JAVA

class Solution
{
    //Function to check if a string is Pangram or not.
    public static boolean checkPangram  (String s) {
        // your code here
        boolean[] m = new boolean[26];
        int index = 0;
        
        for(int i = 0; i < s.length(); i++){
            if('A' <= s.charAt(i) && s.charAt(i) <= 'Z') index = s.charAt(i) - 'A';
            else if('a' <= s.charAt(i) && s.charAt(i) <= 'z') index = s.charAt(i) - 'a';
            else continue;
            m[index] = true;
        }
        
        for(int i = 0; i < 26; i++){
            if(m[i] == false) return false;
        }
        return true;
    }
}

//{ Driver Code Starts.

class GFG
 {
	public static void main (String[] args) throws IOException
	 {
	  BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	  int t=Integer.parseInt(br.readLine());
	  while(t-->0)
	  {
	    String s=br.readLine().trim();
	    
	    System.out.println(new Solution().checkPangram (s)==true?1:0);
	  }
	  
	 }
}
// } Driver Code Ends