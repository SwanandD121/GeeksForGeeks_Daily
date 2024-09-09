//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine().trim());
        while (t-- > 0) {
            String A[] = in.readLine().trim().split(" ");
            int N = Integer.parseInt(A[0]);
            A = in.readLine().trim().split(" ");

            Solution ob = new Solution();
            System.out.println(ob.isCircle(A));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    private void dfs(int node, boolean[] visited, List<List<Integer>> graph) {
        visited[node] = true;
        for (int neighbor : graph.get(node)) {
            if (!visited[neighbor]) {
                dfs(neighbor, visited, graph);
            }
        }
    }

    // Function to check if all non-zero degree vertices are strongly connected
    private boolean isStronglyConnected(int[] inDegree, int[] outDegree, List<List<Integer>> graph, int start) {
        boolean[] visited = new boolean[26];
        dfs(start, visited, graph);

        // Check if all vertices with non-zero degree were visited
        for (int i = 0; i < 26; i++) {
            if ((inDegree[i] > 0 || outDegree[i] > 0) && !visited[i]) {
                return false;
            }
        }

        return true;
    }

    public int isCircle(String arr[]) {
        int[] inDegree = new int[26];  // In-degree for each character
        int[] outDegree = new int[26]; // Out-degree for each character
        List<List<Integer>> graph = new ArrayList<>();

        // Initialize adjacency list
        for (int i = 0; i < 26; i++) {
            graph.add(new ArrayList<>());
        }

        // Build the graph
        for (String str : arr) {
            int firstChar = str.charAt(0) - 'a';
            int lastChar = str.charAt(str.length() - 1) - 'a';

            // Increase in-degree and out-degree counts
            outDegree[firstChar]++;
            inDegree[lastChar]++;
            
            // Add edge to the graph
            graph.get(firstChar).add(lastChar);
        }

        // Check if in-degree and out-degree match for every character
        for (int i = 0; i < 26; i++) {
            if (inDegree[i] != outDegree[i]) {
                return 0;
            }
        }

        // Find the first character that has an edge to start DFS
        int start = -1;
        for (int i = 0; i < 26; i++) {
            if (outDegree[i] > 0) {
                start = i;
                break;
            }
        }

        // If there's no starting point, no edges exist, return 0
        if (start == -1) return 0;

        // Check if all vertices with non-zero degree are strongly connected
        return isStronglyConnected(inDegree, outDegree, graph, start) ? 1 : 0;
    }
}