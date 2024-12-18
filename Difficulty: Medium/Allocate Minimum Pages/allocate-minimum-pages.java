//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());

        while (tc-- > 0) {

            String[] str = br.readLine().trim().split(" ");
            int[] a = new int[str.length];
            for (int i = 0; i < str.length; i++) {
                a[i] = Integer.parseInt(str[i]);
            }
            String[] nk = br.readLine().trim().split(" ");
            int k = Integer.parseInt(nk[0]);
            Solution sln = new Solution();
            int ans = sln.findPages(a, k);

            System.out.println(ans);
            System.out.println("~");
        }
    }
}
// } Driver Code Ends



//Back-end complete function Template for Java

class Solution {
    static boolean isPossible(int arr[],int k,int mid){
        int sum=0,student=1;
        for(int x:arr){
            sum+=x;
            if(sum>mid){
                student++;
                sum=x;
            }
        }
        return student<=k;
    }
    public static int findPages(int[] arr, int k) {
        // code here
        if(k>arr.length)return -1;
        int sum = 0,mx=Integer.MIN_VALUE;
        for(int x:arr){
            sum+=x;
            mx=Math.max(mx,x);
        }
        int low=mx,high=sum,mid,ans=Integer.MAX_VALUE;
        while(low<=high){
            mid=(low+high)/2;
            if(isPossible(arr,k,mid)){
                high=mid-1;
                ans=Math.min(ans,mid);
            }
            else low=mid+1;
        }
        return ans;
    }
}