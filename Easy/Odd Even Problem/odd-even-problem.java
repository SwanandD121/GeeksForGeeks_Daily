//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            String s;
            s = br.readLine();

            Solution obj = new Solution();
            String res = obj.oddEven(s);

            System.out.println(res);
        }
    }
}

// } Driver Code Ends



class Solution {
    public static String oddEven(String s) {
        // code here
        int temp[] = new int[26];
        for(int i = 0; i < s.length(); i++){
            temp[s.charAt(i)-'a']++;
        }
        int x=0;
        int y=0;
        for(int i = 0; i < 26; i++){
            if((i+1)%2==1){
                if(temp[i]%2==1) y++;
            } else {
                if(temp[i]%2==0 && temp[i]!=0)x++;
            }
        }
        return (x+y)%2==1?"ODD":"EVEN";
    }
}
