
public class Solution {

	public static boolean queenhelper(int [][]board,int col)
	{

		if(col==board.length)
		{
			print(board);
			return true;
		}
		int n=board.length;
		for(int row=0;row<n;row++)//i am going row by row for each column
		{
			// before placing i have to check if it is safe or not ?
			if(isSafe(row, col,board))
			{
			board[row][col]=1;
			queenhelper(board,col+1);// now i am calling the same for the next column recursively ! . what if the solution is false??
			board[row][col]=0; // if the solution is wrong then put those places as 0.
			}

		}
		return false;
	}
	public static boolean isSafe(int row , int col,int[][] board)
	{
		// horizontal
		int n=board.length;

		//int row=0,col=0;
		for(int j=0;j<n;j++)
		{
			if(board[row][j]==1)
			return false;
		}

		for(int a =0;a<n;a++)
		{
			if(board[a][col]==1)
			{
				return false;
			}
		}
		for(int i=row,j=col;i>=0&&j>=0;i--,j--)
		{
			if(board[i][j]==1)
			{
				return false;
			}
		}
		for(int i=row,j=col;i<n&&j<n;i++,j++)
		{
			if(board[i][j]==1)
			{
				return false;
			}
		}
		for(int i=row,j=col;i>=0&&j<n;i--,j++)
		{
			if(board[i][j]==1)
			{
				return false;
			}
		}
		for(int i=row,j=col;i<n&&j>=0;i++,j--)
		{
			if(board[i][j]==1)
			{
				return false;
			}
		}
		return true;
	}
	
		public static void print(int [][]board)
		{
			int n=board.length;

			for(int i=0;i<n;i++)
			{
				for(int j=0;j<n;j++)
				{
					System.out.print(board[i][j]+" ");
				}
			}
			System.out.println();
		}
public static void placeNQueens(int n){
		
	/* Your class should be named Solution.
	 * Don't write main() function.
	 * Don't read input, it is passed as function argument.
	 * Print output as specified in the question
	 */

			int [][] board =new int[n][n];

			queenhelper(board,0);
	}
	
}
