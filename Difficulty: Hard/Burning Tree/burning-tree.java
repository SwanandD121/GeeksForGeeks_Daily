//{ Driver Code Starts
//Initial Template for Java


import java.util.LinkedList;
import java.util.Queue;
import java.io.*;
import java.util.*;

class Node {
	int data;
	Node left;
	Node right;

	Node(int data) {
		this.data = data;
		left = null;
		right = null;
	}
}

class GfG {

	static Node buildTree(String str) {

		if (str.length() == 0 || str.charAt(0) == 'N') {
			return null;
		}

		String ip[] = str.split(" ");
		// Create the root of the tree
		Node root = new Node(Integer.parseInt(ip[0]));
		// Push the root to the queue

		Queue<Node> queue = new LinkedList<>();

		queue.add(root);
		// Starting from the second element

		int i = 1;
		while (queue.size() > 0 && i < ip.length) {

			// Get and remove the front of the queue
			Node currNode = queue.peek();
			queue.remove();

			// Get the current node's value from the string
			String currVal = ip[i];

			// If the left child is not null
			if (!currVal.equals("N")) {

				// Create the left child for the current node
				currNode.left = new Node(Integer.parseInt(currVal));
				// Push it to the queue
				queue.add(currNode.left);
			}

			// For the right child
			i++;
			if (i >= ip.length)
				break;

			currVal = ip[i];

			// If the right child is not null
			if (!currVal.equals("N")) {

				// Create the right child for the current node
				currNode.right = new Node(Integer.parseInt(currVal));

				// Push it to the queue
				queue.add(currNode.right);
			}
			i++;
		}

		return root;
	}

	static void printInorder(Node root) {
		if (root == null)
			return;

		printInorder(root.left);
		System.out.print(root.data + " ");

		printInorder(root.right);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(br.readLine());

		while (t > 0) {
			String s = br.readLine();
			int target = Integer.parseInt(br.readLine());
			Node root = buildTree(s);

			Solution g = new Solution();
			System.out.println(g.minTime(root, target));
			t--;

		}
	}
}



// } Driver Code Ends


//User function Template for Java

class Solution {
    static HashMap<Integer, Integer> map;

    public static int findNumberOfNodesInTree(Node root){      // Inorder traversal (iterative method)
        map = new HashMap<>();
        Stack<Node> stack = new Stack<>();
        Node ptr = root;
        int ans = 0;
        while (true) {
            if (ptr != null) {
                stack.push(ptr);
                ptr = ptr.left;
            } else {
                if (stack.isEmpty()) break;
                Node delNode = stack.pop();
                map.put(delNode.data, ans);
                ans++;
                ptr = delNode.right;
            }
        }
        return ans;
    }


    //Recusive function  // its t.c. -> O(n) -> total number of nodes
    public static void fillDepthArr(Node root, int[] depthArr, HashSet<Integer> set) {
        if (root.left != null) {
            fillDepthArr(root.left, depthArr, set);
            if (!set.contains(map.get(root.left.data)))
                depthArr[map.get(root.data)] = Math.max(depthArr[map.get(root.data)], depthArr[map.get(root.left.data)] + 1);
        }
        if (root.right != null) {
            fillDepthArr(root.right, depthArr, set);
            if (!set.contains(map.get(root.right.data)))
                depthArr[map.get(root.data)] = Math.max(depthArr[map.get(root.data)], depthArr[map.get(root.right.data)] + 1);
        }
    }

    public static int minTime(Node root, int target) {
        // Your code goes here
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        int numberOfNodes = findNumberOfNodesInTree(root);
        int[] parArr = new int[numberOfNodes];
        Arrays.fill(parArr, -1);
        
        
        //adj list building
        for (int i = 0; i < numberOfNodes; i++) adj.add(new ArrayList<>());
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);                      // level order traversal
        while (!queue.isEmpty()) {
            int sizeOfQueue = queue.size();
            while (sizeOfQueue-- > 0) {
                Node delNode = queue.poll();
                if (delNode.left != null) {
                    adj.get(map.get(delNode.data)).add(map.get(delNode.left.data));
                    parArr[map.get(delNode.left.data)] = map.get(delNode.data);
                    queue.offer(delNode.left);
                }
                if (delNode.right != null) {
                    adj.get(map.get(delNode.data)).add(map.get(delNode.right.data));
                    parArr[map.get(delNode.right.data)] = map.get(delNode.data);
                    queue.offer(delNode.right);
                }
            }
        } 
        ArrayList<Integer> targetToRootPath = new ArrayList<>();
        int ptr = map.get(target);
        while (ptr != -1) {
            targetToRootPath.add(ptr);
            ptr = parArr[ptr];
        }
        Collections.reverse(targetToRootPath);      
        
        HashSet<Integer> targetToRootPathNodesSet = new HashSet<>();
        for (int idx : targetToRootPath) targetToRootPathNodesSet.add(idx);
        
        
        
        int[] depthArr = new int[numberOfNodes];
        fillDepthArr(root, depthArr, targetToRootPathNodesSet);
        
        int ans = 0;
        int targetToRootPathSize = targetToRootPath.size();
        for (int i = 0; i < targetToRootPathSize; i++) {
            ans = Math.max(ans, targetToRootPathSize - i - 1 + depthArr[targetToRootPath.get(i)]);
        }
        return ans;
    }
}

// class Pair {
//     Node node;
//     int depth;
//     Pair() {}
//     Pair(Node n, int d) {
//         node = n;
//         depth = d;
//     }
// }