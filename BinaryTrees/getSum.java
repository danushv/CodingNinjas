For a given Binary Tree of integers, find and return the sum of all the nodes data.


2 3 4 6 -1 -1 -1 -1 -1
Sample Output 1:
 15

public class Solution {

	public static int getSum(BinaryTreeNode<Integer> root) {
		//Your code goes here.
		int output=0;
		if(root==null)
		return 0;

		output=output+root.data;
		int leftnode=getSum(root.left);

		int rightnode=getSum(root.right);
		return output+leftnode+rightnode;

	}

}
