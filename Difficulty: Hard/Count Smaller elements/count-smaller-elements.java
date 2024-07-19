//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] s = br.readLine().trim().split(" ");
            int arr[] = new int[s.length];
            for (int i = 0; i < s.length; i++) {
                arr[i] = Integer.parseInt(s[i]);
            }

            int[] ans = new Solution().constructLowerArray(arr);
            for (int i = 0; i < arr.length; i++) {
                System.out.print(ans[i] + " ");
            }
            System.out.println();
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    int binSearch(ArrayList<Integer> temp, int n){
        int idx = -1;
        int i = 0, j = temp.size() - 1;
        while(i<=j){
            int mid = i + (j-i)/2;
            if(temp.get(mid) == n){
                idx = mid;
                j = mid-1;
            }
            else if(temp.get(mid) > n) j = mid-1;
            else i = mid+1;
        }
        return idx;
    }
    int[] constructLowerArray(int[] arr) {
        // code here
        int[] res = new int[arr.length];
        ArrayList<Integer> temp = new ArrayList<>();
        for(int i = 0; i < arr.length; i++) temp.add(arr[i]);
        Collections.sort(temp);
        for(int i = 0; i < arr.length; i++){
            int idx = binSearch(temp, arr[i]);
            res[i] = idx;
            temp.remove(idx);
        }
        return res;
    }
}