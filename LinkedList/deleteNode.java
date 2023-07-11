/****************************************************************

	Following is the Node class already written for the Linked List

	class  Node<T> {
    	T data;
    	 Node<T> next;
    
    	public  Node(T data) {
        	this.data = data;
    	}
	}

*****************************************************************/

public class Solution {
	public static Node<Integer> deleteNode( Node<Integer> head, int pos) {
		// Write your code here.
		Node<Integer> temp=head;
		Node<Integer> prev=head;
		Node<Integer> nextt=head;
		Node<Integer> curr=head;

		int tot=0;

		while(temp!=null)
		{
			tot++;
			temp=temp.next;
		}

		if(head==null)
		{
			return head;
		}

		int count=0;

		if(pos==0)
		{
			head=head.next;
			return head;
		}

		if(tot==pos&&tot>0||tot==pos-1)
		{
			return head;
		}
		while(prev!=null&&count<pos-1)
		{
				count++;
				prev=prev.next;

		}	
		if(prev==null)
		return head;
		if(prev.next!=null)
		prev.next=prev.next.next;

		return head;

		





	}
}
