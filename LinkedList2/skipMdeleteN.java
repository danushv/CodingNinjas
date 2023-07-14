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
	
	public static Node<Integer> skipMdeleteN(Node<Integer> head, int M, int N) {
		//Your code goes here
        if(head==null)
            return head;
        if(M==0)
            return null;
        if(N==0)
            return head;
        Node<Integer> curr=head;
        head=curr;
        Node<Integer>t;
        int count=0;

        while(curr!=null)
        {
                for(count=1;count<M&&curr!=null;count++)
                {
                    curr=curr.next;
                }

                if(curr==null)
                {
                   return head;
                }
                t=curr.next;
                for( count=1;count<=N&&t!=null;count++)
                {
                    t=t.next;
                }

                curr.next=t;
                curr=t;

                

        }
        return head;
	}
}
