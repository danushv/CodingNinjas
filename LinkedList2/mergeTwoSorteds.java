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
    
    public static Node<Integer> mergeTwoSorteds(Node<Integer> head1, Node<Integer> head2) {
        //Your code goes here

        if(head1==null||head1.next==null)
        {
            return head2;
        }
        if(head2==null||head2.next==null)
        {
            return head1;
        }
         Node<Integer>  t1=head1;
        Node<Integer> t2=head2;
        Node<Integer> newhead;
        Node<Integer>  tail;


        if(t1.data<t2.data)
        {
             newhead=t1;
             tail=t1;
             t1=t1.next;
             
        }
        else{
            newhead=t2;
             tail=t2;
             t2=t2.next;
        }

        while(t1!=null &&t2!=null)
        {
                if(t1.data<t2.data)
                {
                    tail.next=t1;
                    tail=tail.next;
                    t1=t1.next;
                }
                else{
                    tail.next=t2;
                    tail=tail.next;
                    t2=t2.next;
                }
        }
        if(t1==null)
        {
            tail.next=t2;
        }
        else{
            tail.next=t1;
        }

        return newhead;
    }

}
