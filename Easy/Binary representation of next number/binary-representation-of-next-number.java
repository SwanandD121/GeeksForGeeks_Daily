//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.util.*;

class GfG {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            String s = sc.next();
            Solution ob = new Solution();
            System.out.println(ob.binaryNextNumber(s));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    String binaryNextNumber(String s) {
        // code here.
        boolean indication=true;
        char[] temp = s.toCharArray();
        for(int i=s.length()-1;i>=0;i--){
            if(temp[i]=='0'){
                temp[i]='1';
                indication=false;
                break;
            } else temp[i]='0';
        }
        StringBuilder ans = new StringBuilder();
        if(indication==true){
            ans.append('1');
            ans.append(temp);
        } else{
            int index=0;
            while(index<s.length() && temp[index]=='0')index++;
            ans.append(temp,index,s.length()-index);
        }
        return ans.toString();
    }
}