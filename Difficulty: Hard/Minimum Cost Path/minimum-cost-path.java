//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String[] s = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int[][] grid = new int[n][n];
            for(int i = 0; i < n; i++){
                String[] S = br.readLine().trim().split(" ");
                for(int j = 0; j < n; j++){
                    grid[i][j] = Integer.parseInt(S[j]);
                }
            }
            Solution obj = new Solution();
            int ans = obj.minimumCostPath(grid);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


class Solution
{
    //Function to return the minimum cost to react at bottom
	//right cell from top left cell.
    private static final int[] ROWS = {0, 0, -1, 1};
    private static final int[] COLS = {-1, 1, 0, 0};

    public int minimumCostPath(int[][] grid)
    {
        int n = grid.length;
        int[][] dist = new int[n][n];  
        
        for (int[] row : dist) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        
        PriorityQueue<Cell> pq = new PriorityQueue<>((a, b) -> a.cost - b.cost);
        
        pq.offer(new Cell(0, 0, grid[0][0]));
        dist[0][0] = grid[0][0];
        
        while (!pq.isEmpty()) {
            Cell current = pq.poll();
            int x = current.x;
            int y = current.y;
            int currentCost = current.cost;
            
            if (x == n - 1 && y == n - 1) {
                return currentCost;
            }
            
            for (int i = 0; i < 4; i++) {
                int newRow = x + ROWS[i];
                int newCol = y + COLS[i];
                
                if (isValid(newRow, newCol, n)) {
                    int newCost = currentCost + grid[newRow][newCol];
                    
                    if (newCost < dist[newRow][newCol]) {
                        dist[newRow][newCol] = newCost;
                        pq.offer(new Cell(newRow, newCol, newCost));
                    }
                }
            }
        }
        
        return -1;  
        
    }
    
    private boolean isValid(int row, int col, int n) {
        return row >= 0 && row < n && col >= 0 && col < n;
    }
    
    private static class Cell {
        int x, y, cost;
        
        Cell(int x, int y, int cost) {
            this.x = x;
            this.y = y;
            this.cost = cost;
        }
    }
}