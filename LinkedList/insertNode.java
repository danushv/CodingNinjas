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

	public static Node<Integer> insert(Node<Integer> head, int pos, int data){
		//Your code goes here
		int counter=0;
		Node<Integer>temp=head;
		while(temp!=null)
		{
			counter++;
			temp=temp.next;
		}

		if(pos>counter)
		{
			return head;
		}

	

		Node<Integer> prev =head;
		//Node<Integer> nextt=head;
		Node<Integer> Nodetobeinserted=new Node<Integer>(data);
			if(head==null)
		{
			head=Nodetobeinserted;
			return head;
		}

		if(pos==0)
		{
			Nodetobeinserted.next=head;
			head=Nodetobeinserted;
			return head;
		}
		int count=0;
		while(count<pos-1)
		{
			count++;
			prev=prev.next;
		}
		//prev.next=nextt;
		Nodetobeinserted.next=prev.next;
		prev.next=Nodetobeinserted;
		


	return head;
	}
}
