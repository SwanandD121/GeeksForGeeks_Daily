//{ Driver Code Starts
import java.util.*;

class GFG {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();

        while (tc-- > 0) {
            int s = sc.nextInt();
            int d = sc.nextInt();

            Solution obj = new Solution();
            String res = obj.smallestNumber(s, d);

            System.out.println(res);
        }
    }
}
// } Driver Code Ends



class Solution {
    public String smallestNumber(int s, int d) {
        // code here
        if((9*d) < s) return "-1";
        String ans = "";
        for(int i = d-1; i >= 0; i--){
            if(s>9){
                ans = "9" + ans;
                s -= 9;
            } else {
                if(i == 0){
                    ans = Integer.toString(s) + ans;
                } else {
                    ans = Integer.toString(s-1) + ans;
                    i--;
                    while(i > 0){
                        ans = "0" + ans;
                        i--;
                    }
                    ans = "1" + ans;
                    break;
                }
            }
        }
        return ans;
    }
}
