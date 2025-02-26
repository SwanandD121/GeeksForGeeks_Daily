//{ Driver Code Starts
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        while (t-- > 0) {
            String line = sc.nextLine();
            String[] input = line.split(" ");
            int[] arr = Arrays.stream(input).mapToInt(Integer::parseInt).toArray();
            Solution solution = new Solution();
            ArrayList<Integer> result = solution.maxOfMins(arr);
            for (int val : result) {
                System.out.print(val + " ");
            }
            System.out.println();
            System.out.println("~");
        }
        sc.close();
    }
}
// } Driver Code Ends



class Solution {
    public ArrayList<Integer> maxOfMins(int[] arr) {
        // Your code here
        int n = arr.length;
        int[] left = new int[n], right = new int[n], res = new int[n + 1];
        Arrays.fill(right, n);
        Arrays.fill(left, -1);
        Deque<Integer> s = new ArrayDeque<>();
        
        for (int i = 0; i < n; i++) {
            while (!s.isEmpty() && arr[s.peek()] >= arr[i]) s.pop();
            if (!s.isEmpty()) left[i] = s.peek();
            s.push(i);
        }

        s.clear();

        for (int i = n - 1; i >= 0; i--) {
            while (!s.isEmpty() && arr[s.peek()] >= arr[i]) s.pop();
            if (!s.isEmpty()) right[i] = s.peek();
            s.push(i);
        }

        for (int i = 0; i < n; i++) {
            int len = right[i] - left[i] - 1;
            res[len] = Math.max(res[len], arr[i]);
        }

        for (int i = n - 1; i > 0; i--) res[i] = Math.max(res[i], res[i + 1]);

        ArrayList<Integer> ans = new ArrayList<>();
        for (int i = 1; i <= n; i++) ans.add(res[i]);
        return ans;
    }
}