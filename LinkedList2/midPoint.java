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
    
    public static Node<Integer> midPoint(Node<Integer> head) {
        //Your code goes here
        if(head==null||head.next==null)
        return head;
        Node<Integer> slow=head;
        Node<Integer> fast=head;

        while(fast.next!=null&&fast.next.next!=null)
        {
            
            fast=fast.next.next;
            slow=slow.next;
            //System.out.println(fast.data+slow.data);
        }
        return slow;
                

    }

}
