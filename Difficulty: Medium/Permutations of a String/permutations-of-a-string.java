//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            String S = br.readLine().trim();
            Solution obj = new Solution();
            ArrayList<String> ans = obj.findPermutation(S);
            Collections.sort(ans);
            for (int i = 0; i < ans.size(); i++) {
                out.print(ans.get(i) + " ");
            }
            out.println();

            out.println("~");
        }
        out.close();
    }
}

// } Driver Code Ends


class Solution {
    public ArrayList<String> findPermutation(String s) {
        // Code here
        Set<String> set = new HashSet<>();
        findperms(s, "", set);
        ArrayList<String> res = new ArrayList<>(set);
        Collections.sort(res);
        return res;
    }
    public void findperms(String s, String ans, Set<String> res){
        // base case
        if(s.length() == 0){
            res.add(ans);
            return;
        }
        
        // recursive
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            String newStr = s.substring(0, i) + s.substring(i+1);
            findperms(newStr, ans+c, res);
        }
    }
}