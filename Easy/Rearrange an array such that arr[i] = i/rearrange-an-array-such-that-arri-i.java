//{ Driver Code Starts
//Initial Template for Java


import java.io.*;
import java.util.*;


class GFG {
    
    // Driver code
	public static void main (String[] args) throws IOException{
		// Taking input using buffered reader
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int testcases = Integer.parseInt(br.readLine());
		
		// looping through all testcases
		while(testcases-- > 0){
		    int sizeOfArray = Integer.parseInt(br.readLine());
		    int arr [] = new int[sizeOfArray];
		    
		    String line = br.readLine();
		    String[] elements = line.trim().split("\\s+");
		    for(int i = 0;i<sizeOfArray;i++){
		        arr[i] = Integer.parseInt(elements[i]);
		    }
		    
		    Solution obj = new Solution();
		    arr = obj.modifyArray(arr, sizeOfArray);
		    for(int i=0; i< sizeOfArray;i++){
		        System.out.print(arr[i] + " ");
		    }
		    System.out.println();
		}
	}
}



// } Driver Code Ends


//User function Template for Java

class Solution{
    // Function for finding maximum and value pair
    public static int[] modifyArray (int arr[], int n) {
        // Complete the function
        Map<Integer, Integer> map = new HashMap<>();
        
        for(int i = 0; i < n; i++){
            if(arr[i] != -1){
                map.put(arr[i], i);
            }
        }
        
        for(int i = 0; i < n; i++){
            if(map.containsKey(i)) arr[i] = i;
            else arr[i] = -1;
        }
        return arr;
    }
}


