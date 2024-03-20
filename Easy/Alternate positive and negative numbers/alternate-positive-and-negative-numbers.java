//{ Driver Code Starts
//Initial Template for Java



import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            int n = Integer.parseInt(br.readLine().trim());
            int[] arr = new int[n];
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            new Solution().rearrange(arr, n);
            for (int i = 0; i < n; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
        }
    }
}

// } Driver Code Ends


//User function Template for Java




class Solution {
    void rearrange(int arr[], int n) {
        // code here
        int newArr[] = new int[n];
        ArrayList<Integer> pos = new ArrayList<>();
        ArrayList<Integer> neg = new ArrayList<>();
        
        for(int a : arr){
            if(a < 0) neg.add(a);
            else pos.add(a);
        }
        
        int pi = 0; 
        int ni = 0; 
        int i = 0;

        while (pi < pos.size() && ni < neg.size()) {
            newArr[i++] = pos.get(pi++);
            newArr[i++] = neg.get(ni++);
        }

        while (pi < pos.size()) {
            newArr[i++] = pos.get(pi++);
        }

        while (ni < neg.size()) {
            newArr[i++] = neg.get(ni++);
        }
        
        for(int j = 0; j < n; j++){
            arr[j] = newArr[j];
        }
        
    }
}