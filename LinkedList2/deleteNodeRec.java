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


	public static Node<Integer> deleteNodeRec(Node<Integer> head, int pos) {
    	//Your code goes here

        int count=0;
        Node<Integer> temp=head;
        while(temp!=null)
        {
            count++;
            temp=temp.next;
        }
        if(pos>=count)
        {
            return head;
        }
        if(pos==0)
        {
            return head.next;
        }

        Node<Integer> newhead=deleteNodeRec(head.next,pos-1);
        head.next=newhead;
        return head;
	}

}
