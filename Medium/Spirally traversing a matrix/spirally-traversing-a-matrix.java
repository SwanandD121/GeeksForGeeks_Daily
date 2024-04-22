//{ Driver Code Starts
import java.io.*;
import java.util.*;
class GFG
{
    public static void main(String args[])throws IOException
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int r = sc.nextInt();
            int c = sc.nextInt();
            
            int matrix[][] = new int[r][c];
            
            for(int i = 0; i < r; i++)
            {
                for(int j = 0; j < c; j++)
                 matrix[i][j] = sc.nextInt();
            }
            Solution ob = new Solution();
            ArrayList<Integer> ans = ob.spirallyTraverse(matrix, r, c);
            for (Integer val: ans) 
                System.out.print(val+" "); 
            System.out.println();
        }
    }
}
// } Driver Code Ends


class Solution
{
    //Function to return a list of integers denoting spiral traversal of matrix.
    static ArrayList<Integer> spirallyTraverse(int matrix[][], int r, int c)
    {
        // code here 
        ArrayList<Integer> res = new ArrayList<>();
        if (matrix == null || r == 0 || c == 0) return res; // handle edge cases
        
        int sRow = 0;
        int eRow = r - 1;
        int sCol = 0;
        int eCol = c - 1;

        while (sRow <= eRow && sCol <= eCol) {
            // top
            for (int j = sCol; j <= eCol; j++) {
                res.add(matrix[sRow][j]);
            }
            sRow++;
            
            // right
            for (int i = sRow; i <= eRow; i++) {
                res.add(matrix[i][eCol]);
            }
            eCol--;
            
            // bottom
            if (sRow <= eRow) { 
                for (int j = eCol; j >= sCol; j--) {
                    res.add(matrix[eRow][j]);
                }
                eRow--;
            }
            
            // left
            if (sCol <= eCol) {
                for (int i = eRow; i >= sRow; i--) {
                    res.add(matrix[i][sCol]);
                }
                sCol++;
            }
        }
        return res;
    }
}
