import java.util.* ;
import java.io.*; 
 
public class Solution {

	public static int[][] transpose(int m, int n, int[][] mat) {
		// Write your code 
		int a=mat.length;
		int b=mat[0].length;

		int [][] output=new int[b][a];
		int row=0;
		int col=0;


		for(int i=0;i<m;i++)
		{
			for(int j=0;j<n;j++)
			{
				int val=mat[i][j];
				output[row][col]=val;
				row++;
			}
			col++;
			row=0;
		}
		return output;
	}

}
