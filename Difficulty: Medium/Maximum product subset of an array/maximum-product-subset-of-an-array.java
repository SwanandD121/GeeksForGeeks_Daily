//{ Driver Code Starts
import java.util.*;

public class GFG {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();

        while (tc-- > 0) {
            int n = sc.nextInt();
            List<Integer> list = new ArrayList<>();

            for (int i = 0; i < n; i++) list.add(sc.nextInt());

            Solution obj = new Solution();
            long ans = obj.findMaxProduct(list);

            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


class Solution {
    public long findMaxProduct(List<Integer> arr) {
        // code here
        if(arr.size()==1)return arr.get(0);
        long pos=1,neg=1,negLar=Long.MIN_VALUE,mod=1000000007,c1=0,c2=0;
        for(Integer x:arr){
            if(x<0){
                neg=(neg*(long)x)%mod;;
                negLar=Math.max((long)x,negLar);
                c1++;
            }
            if(x>0){
                pos=(pos*(long)x)%mod;
                c2++;
            }
        }
        if(c1<=1 && c2==0)return 0;
        if(neg<0)neg/=negLar;
        return (pos*neg)%mod;
    }
}