//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int m=sc.nextInt();
            int[][] edge = new int[m][2];
            for(int i=0;i<m;i++){
                edge[i][0]=sc.nextInt();
                edge[i][1]=sc.nextInt();
            }
            int src=sc.nextInt();
            Solution obj = new Solution();
            int res[] = obj.shortestPath(edge,n,m,src);
            for(int i=0;i<n;i++){
                System.out.print(res[i]+" ");
            }
            System.out.println();
        }
    }
}

// } Driver Code Ends


class Solution {
    
    public int[] shortestPath(int[][] edges, int n, int m, int src) {
        // Create the adjacency list
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        int[] distance = new int[n];
        Arrays.fill(distance, -1);
        distance[src] = 0;

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(src);

        while (!queue.isEmpty()) {
            int node = queue.poll();
            int dist = distance[node];

            for (int adjNode : adj.get(node)) {
                if (distance[adjNode] == -1) {  
                    distance[adjNode] = dist + 1;
                    queue.offer(adjNode);
                }
            }
        }

        return distance;
    }
}