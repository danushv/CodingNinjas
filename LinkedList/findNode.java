/****************************************************************

	Following is the class structure of the Node class:

	class Node<T> {
    	T data;
    	Node<T> next;
    
    	public Node(T data) {
        	this.data = data;
    	}
	}

*****************************************************************/

public class Solution {
	public static int findNode(Node<Integer> head, int n) {
		// Write your code here.

		Node<Integer> temp=head;
		int output=0;
		boolean flag=false;

		while(temp!=null)
		{
			if(temp.data==n)
			{
				return output;
			}
			else{
				output++;
				temp=temp.next;
			}
		}
		return -1;

		
	}
}
