
public class Solution {

	public static void wavePrint(int mat[][]){
		//Your code goes here
		if(mat.length>0)
		{
		for(int i=0;i<mat[0].length;i++)
		{
			if(i%2==0)
			{
				for(int j=0;j<mat.length;j++)
				{
					System.out.print(mat[j][i]+" ");
				}
			}
			else if(i%2!=0)
			{
				for(int j=mat.length-1;j>=0;j--)
				{
					System.out.print(mat[j][i]+" ");
				}
			}
		}
		}


	}

}
