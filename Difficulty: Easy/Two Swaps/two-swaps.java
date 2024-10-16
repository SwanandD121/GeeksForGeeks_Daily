//{ Driver Code Starts
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = Integer.parseInt(scanner.nextLine()); // Read number of test cases

        // Loop through each test case
        while (t-- > 0) {
            String input = scanner.nextLine();
            String[] inputArr = input.split(" ");
            List<Integer> arr = new ArrayList<>();

            // Convert input to list of integers
            for (String str : inputArr) {
                arr.add(Integer.parseInt(str));
            }

            Solution ob = new Solution();
            boolean ans = ob.checkSorted(arr);

            // Output result
            if (ans)
                System.out.println("true");
            else
                System.out.println("false");
        }

        scanner.close();
    }
}

// } Driver Code Ends


class Solution {
    public boolean checkSorted(List<Integer> arr) {
        // code here
        int count=0;
        for(int i=0;i<arr.size();i++){
            if(arr.get(i)!=i+1){
                int temp = arr.get(i);
                arr.set(i,arr.get(arr.get(i)-1));
                arr.set(temp-1,temp);
                i--;
                count++;
            }
            if(count>2)return false;
        }
        return count==2|count==0;
    }
}