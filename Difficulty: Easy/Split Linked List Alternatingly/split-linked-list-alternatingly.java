//{ Driver Code Starts
import java.util.*;

class Node {
    int data;
    Node next;

    Node(int x) {
        data = x;
        next = null;
    }
}

public class Main {
    public static void printList(Node node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();

        while (t-- > 0) {
            List<Integer> arr = new ArrayList<>();
            String input = sc.nextLine();
            Scanner ss = new Scanner(input);

            while (ss.hasNextInt()) {
                arr.add(ss.nextInt());
            }

            Node head = new Node(arr.get(0));
            Node tail = head;

            for (int i = 1; i < arr.size(); ++i) {
                tail.next = new Node(arr.get(i));
                tail = tail.next;
            }

            Solution ob = new Solution();
            Node[] result = ob.alternatingSplitList(head);
            printList(result[0]);
            printList(result[1]);
        }

        sc.close();
    }
}

// } Driver Code Ends


// User function Template for Java
/*
struct Node
{
    int data;
    struct Node* next;

    Node(int x){
        data = x;
        next = NULL;
    }

};
*/

class Solution {
    // Function to append a new node with newData at the end of a linked list
    Node[] alternatingSplitList(Node head) {
        // code here
        Node head1 = null;
        Node head2 = null;
        Node temp1 = null;
        Node temp2 = null;
        
        int c = 0;
        while(head != null){
            if(c % 2 == 1){
                if(head2 == null){
                    head2 = head;
                    temp2 = head;
                } else {
                    temp2.next = head;
                    temp2 = temp2.next;
                }
            } else {
                if(head1 == null){
                    head1 = head;
                    temp1 = head;
                } else {
                    temp1.next = head;
                    temp1 = temp1.next;
                }
            }
            head = head.next;
            c++;
        }
        temp1.next = null;
        temp2.next = null;
        Node[] arr = new Node[2];
        arr[0] = head1;
        arr[1] = head2;
        return arr;
    }
}
