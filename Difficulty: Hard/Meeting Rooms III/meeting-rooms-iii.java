//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt(); // Number of test cases
        while (t-- > 0) {
            int n = sc.nextInt(); // Number of rooms
            int m = sc.nextInt(); // Number of meetings
            int[][] meetings = new int[m][2];
            for (int i = 0; i < m; i++) {
                meetings[i][0] = sc.nextInt(); // Start time
                meetings[i][1] = sc.nextInt(); // End time
            }
            Solution ob = new Solution();
            System.out.println(ob.mostBooked(n, meetings));
            System.out.println("~");
        }
        sc.close();
    }
}


// } Driver Code Ends

// User function Template for Java
class Solution {
    public int mostBooked(int n, int[][] meetings) {
        Arrays.sort(meetings, (a, b) -> Integer.compare(a[0], b[0]));
        int[] count = new int[n];
        PriorityQueue<Integer> available = new PriorityQueue<>();
        PriorityQueue<long[]> busy = new PriorityQueue<>(
            (a, b) -> a[0] != b[0] ? Long.compare(a[0], b[0]) : Long.compare(a[1], b[1])
        );

        for (int i = 0; i < n; i++) available.offer(i);

        for (int[] meeting : meetings) {
            int start = meeting[0], end = meeting[1];
            while (!busy.isEmpty() && busy.peek()[0] <= start) {
                available.offer((int) busy.poll()[1]);
            }
            if (!available.isEmpty()) {
                int room = available.poll();
                count[room]++;
                busy.offer(new long[] {end, room});
            } else {
                long[] earliest = busy.poll();
                long newEnd = earliest[0] + (end - start);
                count[(int) earliest[1]]++;
                busy.offer(new long[] {newEnd, earliest[1]});
            }
        }

        int max = 0, res = 0;
        for (int i = 0; i < n; i++) {
            if (count[i] > max) {
                max = count[i];
                res = i;
            }
        }
        return res;
    }
}


//{ Driver Code Starts.
// } Driver Code Ends