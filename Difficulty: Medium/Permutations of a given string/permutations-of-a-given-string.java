//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
	public static void main(String[] args) throws IOException
	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int t = Integer.parseInt(br.readLine().trim());
        while(t-->0)
        {
            String S = br.readLine().trim();
            Solution obj = new Solution();
            List<String> ans = obj.find_permutation(S);
            for( int i = 0; i < ans.size(); i++)
            {
                out.print(ans.get(i)+" ");
            }
            out.println();
                        
        }
        out.close();
	}
}


// } Driver Code Ends


class Solution {
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
    public List<String> find_permutation(String S) {
        // Code here
        Set<String> set = new HashSet<>();
        findperms(S, "", set);
        List<String> res = new ArrayList<>(set);
        Collections.sort(res);
        return res;
    }
}