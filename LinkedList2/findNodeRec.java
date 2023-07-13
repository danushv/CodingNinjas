

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

public static int findNodeRechelpher(Node<Integer> head,int n,int count)
{

        if(head==null)
        {
            return -1;
        }
        
        if(head.data==n)
        {
            return count;
        }
     return   findNodeRechelpher(head.next,n,count+1);
}
	public static int findNodeRec(Node<Integer> head, int n) {
    	//Your code goes here
        
        return findNodeRechelpher(head,n,0);
	}

}
