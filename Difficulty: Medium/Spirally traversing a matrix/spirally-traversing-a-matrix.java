//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int r = sc.nextInt();
            int c = sc.nextInt();

            int matrix[][] = new int[r][c];

            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) matrix[i][j] = sc.nextInt();
            }
            Solution ob = new Solution();
            ArrayList<Integer> ans = ob.spirallyTraverse(matrix);
            for (Integer val : ans) System.out.print(val + " ");
            System.out.println();

            System.out.println("~");
        }
    }
}
// } Driver Code Ends


class Solution {
    // Function to return a list of integers denoting spiral traversal of matrix.
    public ArrayList<Integer> spirallyTraverse(int mat[][]) {
        // code here
        int rs = 0, cs = 0, re = mat.length - 1, ce = mat[0].length - 1;
        ArrayList<Integer> res = new ArrayList<>();
        
        while(rs <= re && cs <= ce) {
            // top
            for(int i = cs; i <= ce; i++) {
                res.add(mat[rs][i]);
            }
            rs++;
            
            //right
            for(int i = rs; i <= re; i++) {
                res.add(mat[i][ce]);
            }
            ce--;
            
            //bottom
            if(rs <= re) {
                for(int i = ce; i >= cs; i--) {
                    res.add(mat[re][i]);
                }
                re--;
            }
            
            //left
            if(cs <= ce) {
                for(int i = re; i >= rs; i--) {
                    res.add(mat[i][cs]);
                }
                cs++;
            }
            
        }
        return res;
        
        
        
    }
}
