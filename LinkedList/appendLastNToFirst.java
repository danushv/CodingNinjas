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

	public static Node<Integer> appendLastNToFirst(Node<Integer> head, int n) {
		//Your code goes here
		if(n==0||head==null)
		{
			return head;
		}

	Node<Integer> temp=head;
	int count=0;
	while(temp!=null)
	{
		count++;
		temp=temp.next;
	}
	int m=count-n;

	int i=0;
	Node<Integer> newhead=head;
	Node<Integer> prev=head;
	while(i<m-1)
	{
			i++;
			prev=prev.next;
	}
	newhead=prev.next;
	prev.next=null;
	Node<Integer> tail=newhead;
	while(tail.next!=null)
	{
		tail=tail.next;
	}
	tail.next=head;
	//head.next=null;
	
	head=newhead;


return head;


	}

}
