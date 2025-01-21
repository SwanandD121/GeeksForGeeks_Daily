//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class Node {
    int data;
    Node next;

    Node(int key) {
        data = key;
        next = null;
    }
}

class ReverseInSize {
    static Node head;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);

        int t = Integer.parseInt(in.readLine().trim());

        while (t-- > 0) {

            String s[] = in.readLine().trim().split(" ");
            int a1 = Integer.parseInt(s[0]);
            Node head = new Node(a1);
            Node tail = head;
            for (int i = 1; i < s.length; i++) {
                int a = Integer.parseInt(s[i]);
                // addToTheLast(new Node(a));
                tail.next = new Node(a);
                tail = tail.next;
            }

            int k = Integer.parseInt(in.readLine().trim());
            Solution ob = new Solution();
            Node res = ob.reverseKGroup(head, k);
            printList(res, out);
            out.println();

            out.println("~");
        }
        out.close();
    }

    public static void printList(Node node, PrintWriter out) {
        while (node != null) {
            out.print(node.data + " ");
            node = node.next;
        }
    }
}

// } Driver Code Ends


/*node class of the linked list
class Node
{
    int data;
    Node next;
    Node(int key)
    {
        data = key;
        next = null;
    }
}

*/

class Solution {
    public static Node reverseKGroup(Node head, int k) {
        // code here
        int len = getLength(head);
        Node origH = null;
        Node origT = null, tmpH = null, tmpT=null;
        Node curr=head;
        while(len > 0){
            int j=k;
            j = Math.min(j, len);
            while(j>0){
                Node nex = curr.next;
                if(tmpH == null){
                    tmpH = curr;
                    tmpT = curr;
                }
                else {
                    curr.next = tmpH;
                    tmpH = curr;
                }
                curr=nex;
                j--;
                len--;
            }
            if(origH == null){
                origH = tmpH;
                origT = tmpT;
            }
            else {
                origT.next = tmpH;
                origT = tmpT;
            }
            tmpH = null;
            tmpT=null;
        }
        origT.next = null;
        return origH;
    }
    public static int getLength(Node head){
        int len =0;
        while(head!=null){
            len++;
            head=head.next;
        }
        return len;
    }
}
