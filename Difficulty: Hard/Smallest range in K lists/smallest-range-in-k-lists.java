//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

public class DriverClass {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            int arr[][] = new int[k][n];
            for (int i = 0; i < k; i++) {
                for (int j = 0; j < n; j++) arr[i][j] = sc.nextInt();
            }
            ArrayList<Integer> range = new Solution().findSmallestRange(arr);
            System.out.println(range.get(0) + " " + range.get(1));
            System.out.println("~");
        }
    }
}

// } Driver Code Ends


class Solution {
    class Node {
        int val, row, idx;
        Node(int val, int row, int idx) {
            this.val = val;
            this.row = row;
            this.idx = idx;
        }
    }

    public ArrayList<Integer> findSmallestRange(int[][] arr) {
        int k = arr.length;
        int n = arr[0].length;
        PriorityQueue<Node> minHeap = new PriorityQueue<>((a, b) -> a.val - b.val);
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < k; i++) {
            minHeap.offer(new Node(arr[i][0], i, 0));
            max = Math.max(max, arr[i][0]);
        }

        int start = 0, end = Integer.MAX_VALUE;

        while (minHeap.size() == k) {
            Node cur = minHeap.poll();
            int min = cur.val;

            if (max - min < end - start) {
                start = min;
                end = max;
            }

            if (cur.idx + 1 < n) {
                cur.idx++;
                cur.val = arr[cur.row][cur.idx];
                max = Math.max(max, cur.val);
                minHeap.offer(cur);
            } else {
                break;
            }
        }

        ArrayList<Integer> res = new ArrayList<>();
        res.add(start);
        res.add(end);
        return res;
    }
}