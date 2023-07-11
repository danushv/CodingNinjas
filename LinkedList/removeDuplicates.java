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

	public static Node<Integer> removeDuplicates(Node<Integer> head) {
		//Your code goes here

		if(head==null)
		{
			return null;
		}

		Node<Integer> curr=head;
		{
			while(curr.next!=null)
			{
				if(curr.data.equals(curr.next.data))
				{
					curr.next=curr.next.next;
				}
				else
				curr=curr.next;
			}
		}
		return head;
	}

}
