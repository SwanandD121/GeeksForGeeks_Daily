//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Node {
    int data;
    Node left, right;

    Node(int key) {
        data = key;
        left = right = null;
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            Node root = null;

            // Read inorder array
            String[] inorderStr = (br.readLine()).trim().split(" ");
            int inorder[] = new int[inorderStr.length];
            for (int i = 0; i < inorderStr.length; i++) {
                inorder[i] = Integer.parseInt(inorderStr[i]);
            }

            // Read preorder array
            String[] preorderStr = (br.readLine()).trim().split(" ");
            int preorder[] = new int[preorderStr.length];
            for (int i = 0; i < preorderStr.length; i++) {
                preorder[i] = Integer.parseInt(preorderStr[i]);
            }

            Solution ob = new Solution();
            root = ob.buildTree(inorder, preorder);
            postOrder(root);
            System.out.println();
        }
    }

    // Function to print postorder traversal of the tree
    public static void postOrder(Node root) {
        if (root == null) return;

        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.data + " ");
    }
}

// } Driver Code Ends


/*
class Node {
    int data;
    Node left, right;

    Node(int key) {
        data = key;
        left = right = null;
    }
}
*/

class Solution {
    static int preIndex = 0; // Global variable to track the current index in preorder

    public static Node buildTree(int inorder[], int preorder[]) {
        preIndex = 0; // Reset preIndex for multiple test cases
        Map<Integer, Integer> inorderMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i); // Store inorder values with their indices for O(1) lookup
        }
        return constructTree(preorder, inorderMap, 0, inorder.length - 1);
    }

    private static Node constructTree(int[] preorder, Map<Integer, Integer> inorderMap, int inStart, int inEnd) {
        if (inStart > inEnd) return null; // Base case

        int rootVal = preorder[preIndex++]; // Pick current node from preorder
        Node root = new Node(rootVal);

        int inIndex = inorderMap.get(rootVal); // Get the inorder index of the root

        // Recursively build left and right subtrees
        root.left = constructTree(preorder, inorderMap, inStart, inIndex - 1);
        root.right = constructTree(preorder, inorderMap, inIndex + 1, inEnd);

        return root;
    }

    // Postorder traversal of the constructed tree
    public static void postorderTraversal(Node root, List<Integer> result) {
        if (root == null) return;
        postorderTraversal(root.left, result);
        postorderTraversal(root.right, result);
        result.add(root.data);
    }

    public static List<Integer> getPostorder(int inorder[], int preorder[]) {
        Node root = buildTree(inorder, preorder);
        List<Integer> result = new ArrayList<>();
        postorderTraversal(root, result);
        return result;
    }
}
