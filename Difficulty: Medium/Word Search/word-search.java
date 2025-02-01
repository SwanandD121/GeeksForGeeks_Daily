//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt(); // Number of test cases
        while (tc-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            char[][] mat = new char[n][m];

            // Reading the matrix
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    mat[i][j] = sc.next().charAt(0);
                }
            }

            String word = sc.next();
            Solution obj = new Solution();
            boolean ans = obj.isWordExist(mat, word);
            if (ans)
                System.out.println("true");
            else
                System.out.println("false");

            System.out.println("~");
        }
        sc.close();
    }
}
// } Driver Code Ends


class Solution {
    static public boolean isWordExist(char[][] mat, String word) {
        int n = mat.length, m = mat[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (mat[i][j] == word.charAt(0) && dfs(mat, word, 0, i, j, new boolean[n][m]))
                    return true;
            }
        }
        return false;
    }
    
    static boolean dfs(char[][] mat, String word, int idx, int x, int y, boolean[][] vis) {
        if (idx == word.length()) return true;
        if (x < 0 || y < 0 || x >= mat.length || y >= mat[0].length || vis[x][y] || mat[x][y] != word.charAt(idx))
            return false;
        
        vis[x][y] = true;
        boolean found = dfs(mat, word, idx + 1, x + 1, y, vis) ||
                        dfs(mat, word, idx + 1, x - 1, y, vis) ||
                        dfs(mat, word, idx + 1, x, y + 1, vis) ||
                        dfs(mat, word, idx + 1, x, y - 1, vis);
        vis[x][y] = false;
        return found;
    }
}