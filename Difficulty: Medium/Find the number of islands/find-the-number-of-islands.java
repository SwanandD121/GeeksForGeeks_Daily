//{ Driver Code Starts
import java.util.*;

class GFG {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int tc = scanner.nextInt(); // Number of test cases
        while (tc-- > 0) {
            int n = scanner.nextInt(); // Number of rows
            int m = scanner.nextInt(); // Number of columns
            char[][] grid = new char[n][m];

            // Read the grid input
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    grid[i][j] = scanner.next().charAt(0);
                }
            }
            Solution obj = new Solution();
            int ans = obj.numIslands(grid);
            System.out.println(ans);
        }
        scanner.close();
    }
}

// } Driver Code Ends


class Solution {
    private final int[][] dir = {{1, 0}, {-1, 0}, {0, -1}, {0, 1}, {1, 1}, {-1, -1}, {1, -1}, {-1, 1}};
    private int n, m;
    
    private void solve(char[][] grid, int i, int j) {
        Stack<int[]> stack = new Stack<>();
        stack.push(new int[]{i, j});
        
        while (!stack.isEmpty()) {
            int[] cell = stack.pop();
            int x = cell[0], y = cell[1];
            
            // Check if the cell is within bounds and is land
            if (x < 0 || y < 0 || x >= n || y >= m || grid[x][y] == '0') {
                continue;
            }
            
            // Mark the cell as visited
            grid[x][y] = '0';
            
            // Push all valid neighbors into the stack
            for (int[] d : dir) {
                int newX = x + d[0];
                int newY = y + d[1];
                stack.push(new int[]{newX, newY});
            }
        }
    }
    
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        
        n = grid.length;
        m = grid[0].length;
        int count = 0;
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == '1') {
                    solve(grid, i, j);
                    count++;
                }
            }
        }
        
        return count;
    }
}