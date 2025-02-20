//{ Driver Code Starts
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine(); // Consume the newline character

        while (t-- > 0) {
            String s = sc.nextLine();
            String[] parts = s.split(" ");
            int[] nums = new int[parts.length];
            for (int i = 0; i < parts.length; i++) {
                nums[i] = Integer.parseInt(parts[i]);
            }
            Solution ob = new Solution();
            ArrayList<Double> ans = ob.getMedian(nums);
            for (double i : ans) {
                System.out.printf("%.1f ", i);
            }
            System.out.println();
            System.out.println("~");
        }
        sc.close();
    }
}

// } Driver Code Ends


class Solution {
    public ArrayList<Double> getMedian(int[] arr) {
        ArrayList<Double> res = new ArrayList<>();
        PriorityQueue<Integer> maxH = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> minH = new PriorityQueue<>();
        
        for (int x : arr) {
            if (maxH.isEmpty() || x <= maxH.peek()) maxH.add(x);
            else minH.add(x);
            
            if (maxH.size() > minH.size() + 1) minH.add(maxH.poll());
            else if (minH.size() > maxH.size()) maxH.add(minH.poll());
            
            res.add(maxH.size() > minH.size() ? (double) maxH.peek() : (maxH.peek() + minH.peek()) / 2.0);
        }
        return res;
    }
}