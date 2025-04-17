//{ Driver Code Starts
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = Integer.parseInt(sc.nextLine());

        while (t-- > 0) {
            int V = Integer.parseInt(sc.nextLine());
            int E = Integer.parseInt(sc.nextLine());

            List<int[]> edgeList = new ArrayList<>();

            for (int i = 0; i < E; i++) {
                String[] parts = sc.nextLine().split(" ");
                int u = Integer.parseInt(parts[0]);
                int v = Integer.parseInt(parts[1]);
                int w = Integer.parseInt(parts[2]);
                edgeList.add(new int[] {u, v, w});
                edgeList.add(new int[] {v, u, w});
            }

            int[][] edges = new int[edgeList.size()][3];
            for (int i = 0; i < edgeList.size(); i++) {
                edges[i] = edgeList.get(i);
            }

            Solution obj = new Solution();
            int res = obj.findMinCycle(V, edges);

            System.out.println(res);
        }

        sc.close();
    }
}

// } Driver Code Ends


class Solution {
    public int findMinCycle(int V, int[][] edges) {
        // code here
        int[][] dist = new int[V][V];
        for (int i = 0; i < V; i++) Arrays.fill(dist[i], Integer.MAX_VALUE);
        
        for (int[] edge : edges) {
            int u = edge[0], v = edge[1], w = edge[2];
            dist[u][v] = Math.min(dist[u][v], w);
            dist[v][u] = Math.min(dist[v][u], w);
        }

        int ans = Integer.MAX_VALUE;

        for (int i = 0; i < V; i++) {
            int[] d = new int[V];
            Arrays.fill(d, Integer.MAX_VALUE);
            d[i] = 0;

            PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
            pq.offer(new int[]{i, 0});

            boolean[] visited = new boolean[V];
            int[] parent = new int[V];
            Arrays.fill(parent, -1);

            while (!pq.isEmpty()) {
                int[] curr = pq.poll();
                int u = curr[0], distU = curr[1];
                if (visited[u]) continue;
                visited[u] = true;

                for (int v = 0; v < V; v++) {
                    if (dist[u][v] != Integer.MAX_VALUE) {
                        if (!visited[v] && d[v] > distU + dist[u][v]) {
                            d[v] = distU + dist[u][v];
                            pq.offer(new int[]{v, d[v]});
                            parent[v] = u;
                        } else if (parent[u] != v && parent[v] != u) {
                            ans = Math.min(ans, d[u] + d[v] + dist[u][v]);
                        }
                    }
                }
            }
        }

        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
};