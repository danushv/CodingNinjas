/*

    Following is the Node class already written for the Linked List

    class Node<T> {
        T data;
        Node<T> next;
    
        public Node(T data) {
            this.data = data;
        }
    }

*/

public class Solution {

	public static Node<Integer> swapNodes(Node<Integer> head, int i, int j) {
		//Your code goes here

        if(head==null||i==j)
        {
            return head;
        }

        Node<Integer> p1=head;
        Node<Integer> c1=null;
        Node<Integer> p2=head;
        Node<Integer> c2=null;

                for(int count=1;count<i&&p1!=null;count++)
                {
                p1=p1.next;
                }

                for(int count=1;count<j&&p2!=null;count++)
                {
                p2=p2.next;
                }

                if (p1 == null || p2 == null) {
			return head; // Out of range indices
		}

                c1=p1.next;
                c2=p2.next;

                p1.next=c2;
                p2.next=c1;
                Node<Integer> temp=c1.next;
                c1.next=c2.next;
                c2.next=temp;

                return head;

	}

}
