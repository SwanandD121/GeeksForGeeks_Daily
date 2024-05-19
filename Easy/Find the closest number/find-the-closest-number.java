//{ Driver Code Starts
import java.io.*;
import java.util.*;


class IntArray
{
    public static int[] input(BufferedReader br, int n) throws IOException
    {
        String[] s = br.readLine().trim().split(" ");
        int[] a = new int[n];
        for(int i = 0; i < n; i++)
            a[i] = Integer.parseInt(s[i]);

        return a;
    }

    public static void print(int[] a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }

    public static void print(ArrayList<Integer> a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            
            int n;
            n = Integer.parseInt(br.readLine());
            
            
            int k;
            k = Integer.parseInt(br.readLine());
            
            
            int[] arr = IntArray.input(br, n);
            
            Solution obj = new Solution();
            int res = obj.findClosest(n, k, arr);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends



class Solution {
    public static int findClosest(int n, int k, int[] arr) {
        // code here
        int i = 0;
        int j = n-1;
        int min = 0;
        while(i <= j){
            int mid = i + (j-i)/2;
            if(arr[mid] == k) return arr[mid];
            else if(arr[mid] < k) i = mid + 1;
            else j = mid - 1;
        }
        
        if(i == 0){
            return arr[0];
        } else if(i == n) {
            return arr[n-1];
        } else {
            int bef = arr[i-1];
            int aft = arr[i];
            if(Math.abs(bef - k) < Math.abs(aft - k)) return bef;
            else if(Math.abs(bef - k) > Math.abs(aft - k)) return aft;
            else return Math.max(bef, aft);
        }
    }
}
        
