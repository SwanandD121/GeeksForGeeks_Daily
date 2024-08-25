//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int g = 0; g < t; g++) {
            String[] str = (br.readLine()).trim().split(" ");
            int x[] = new int[str.length];
            for (int i = 0; i < str.length; i++) x[i] = Integer.parseInt(str[i]);
            str = (br.readLine()).trim().split(" ");
            int[] y = new int[str.length];
            for (int i = 0; i < str.length; i++) {
                y[i] = Integer.parseInt(str[i]);
            }
            System.out.println(new Solution().countPairs(x, y, x.length, y.length));
        }
    }
}

// } Driver Code Ends


//Back-end complete function Template for Java
class Solution {
    int binarySearch(int key,int brr[]){
        int low = 0, high = brr.length-1, idx = -1;
        while(low <= high){
            int mid = low + (high-low)/2;
            if(brr[mid] <= key){
                idx = mid;
                low = mid + 1;
            }
            else high = mid - 1;
        }
        return idx;
    }
    // Function to count number of pairs such that x^y is greater than y^x.
    public long countPairs(int arr[], int brr[], int M, int N) {
        // code here
        long ans = 0, one = 0, two = 0, threeFour = 0;
        Arrays.sort(brr);
        
        for(int x : brr){
            if(x == 1) one++;
            else if(x == 2) two++;
            else if(x == 3 || x == 4) threeFour++;
        }
        
        for(int x : arr){
            if(x != 1){
                ans += one;
                if(x == 2) ans -= threeFour;
                if(x == 3) ans += two;
                int index = binarySearch(x, brr);
                ans+=(brr.length-index - 1);
            }
        }
        return ans;
    }
}