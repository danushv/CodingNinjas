

/*
    Following is the structure of the node class for a Singly Linked List

    class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }

    }

*/

public class Stack {

    //Define the data members
     private Node  head=null;
      private  int size=0;


    public Stack() {
        //Implement the Constructor

    }



    /*----------------- Public Functions of Stack -----------------*/


    public int getSize() { 
        //Implement the getSize() function
        return size;
    }

    public boolean isEmpty() {
        //Implement the isEmpty() function
        if(size==0)
        return true;
        else
        return false;
    }

    public void push(int element) {
        //Implement the push(element) function
        Node newnode=new Node(element);
        newnode.next=head;
        head=newnode;
        size++;
    }

    public int pop() {
        //Implement the pop() function
        if(size>0)
        {
        int poped=head.data;
        head=head.next;
        size--;
        return poped;
        }
        else
        return -1;

    }

    public int top() {
        //Implement the top() function
        if(size==0)
        return -1;
        else
        return head.data;
    }
}
