//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class Job {
    int id, profit, deadline;
    Job(int x, int y, int z){
        this.id = x;
        this.deadline = y;
        this.profit = z; 
    }
}

class GfG {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        //testcases
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0){
            String inputLine[] = br.readLine().trim().split(" ");
            
            //size of array
            int n = Integer.parseInt(inputLine[0]);
            Job[] arr = new Job[n];
            inputLine = br.readLine().trim().split(" ");
            
            //adding id, deadline, profit
            for(int i=0, k=0; i<n; i++){
                arr[i] = new Job(Integer.parseInt(inputLine[k++]), Integer.parseInt(inputLine[k++]), Integer.parseInt(inputLine[k++]));
            }
            
            Solution ob = new Solution();
            
            //function call
            int[] res = ob.JobScheduling(arr, n);
            System.out.println (res[0] + " " + res[1]);
        }
    }
}
// } Driver Code Ends


class Solution
{
    //Function to find the maximum profit and the number of jobs done.
    int[] JobScheduling(Job arr[], int n)
    {
        // Your code here
        Arrays.sort(arr, (a, b) -> b.profit - a.profit);
        
        int maxDeadline = 0;
        for(int i = 0; i < n; i++){
            if(arr[i].deadline > maxDeadline) maxDeadline = arr[i].deadline;
        }
        
        boolean slots[] = new boolean[maxDeadline];
        int c = 0, profit = 0;
        
        for(int i = 0; i < n; i++){
            for(int j = arr[i].deadline - 1; j >= 0; j--){
                if(!slots[j]){
                    slots[j] = true;
                    profit += arr[i].profit;
                    c++;
                    break;
                }
            }
        }
        
        int res[] = new int[2];
        res[0] = c;
        res[1] = profit;
        return res; 
    }
}

/*
class Job {
    int id, profit, deadline;
    Job(int x, int y, int z){
        this.id = x;
        this.deadline = y;
        this.profit = z; 
    }
}
*/