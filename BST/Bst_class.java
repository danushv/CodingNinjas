

/*
 * Binary Tree Node class
 * 
 * class BinaryTreeNode<T> { 
 * 		T data; 
 * 		BinaryTreeNode<T> left; 
 * 		BinaryTreeNode<T> right;
 * 		public BinaryTreeNode(T data) 
 * 		{ 
 * 			this.data = data; 
 * 		}
 * }
 */

 /* 
 * Main Method being used internally
 *	public static void main(String[] args) throws IOException {
 *		BinarySearchTree bst = new BinarySearchTree();
 *		int choice, input;
 *		int q = Integer.parseInt(br.readLine());
 *		while (q-- > 0) {
 *			st = new StringTokenizer(br.readLine());
 *			choice = Integer.parseInt(st.nextToken());
 *			switch (choice) {
 *			case 1:
 *				input = Integer.parseInt(st.nextToken());
 *				bst.insert(input);
 *				break;
 *				case 2:
 *				input = Integer.parseInt(st.nextToken());
 *				bst.remove(input);
 *				break;
 *			case 3:
 *				input = Integer.parseInt(st.nextToken());
 *				System.out.println(bst.search(input));
 *				break;
 *			default:
 *				bst.printTree();
 *				break;
 *			}
 *		}
 *	}
 */

public class BinarySearchTree {
	private BinaryTreeNode<Integer> root;
	private int size;
		public void insert(int data) {
		//Implement the insert() function
		root=inserthelp(root, data);
		size++;
		
	}
	public static BinaryTreeNode<Integer> inserthelp(BinaryTreeNode<Integer> root,int data)
	{
		if(root==null)
		{
			BinaryTreeNode<Integer> newroot=new BinaryTreeNode<Integer>(data);
			return newroot;
		}
		if(root.data>data)
		{
			BinaryTreeNode<Integer>nleft=inserthelp(root.left,data);
			root.left=nleft;
		}
		else{
			BinaryTreeNode<Integer>nright=inserthelp(root.right,data);
			root.right=nright;
		}
		return root;
	}
	
	public void remove(int data) {
		//Implement the remove() function
	}
	
	public void printTree() {
		//Implement the printTree() function
		 print_Tree_Helper(root);
	}
	public void print_Tree_Helper(BinaryTreeNode<Integer>root)
	{
		if(root==null)
		return;
	
		System.out.print(root.data + ":");
		if(root.left!=null)
		System.out.print("L:" +root.left.data+ ",");
		if(root.right!=null)
		System.out.print("R:" +root.right.data);
		System.out.println();
		print_Tree_Helper(root.left);
		print_Tree_Helper(root.right);
		

	}
	
	public boolean search(int data) {
		//Implement the search() function
		return search_helper(root,data);
	}
	public boolean search_helper(BinaryTreeNode<Integer> root,int data)
	{
		if(root==null)
		{
			return false;
		}
		if(root.data==data)
		return true;

			if(data<root.data)
			{
				return search_helper( root.left, data);
			}
			else
			{
				return search_helper( root.right, data);
			}
	}

}
