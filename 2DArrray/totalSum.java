
public class Solution {

	public static void totalSum(int[][] mat) {
		//Your code goes here
		int totalsum=0;
		int removesum=0;
		int rowfirst=0;
		int	 rowlast=0;
		int midd=0;
		int colfirst=0;
		int collast=0;
		if(mat.length>=2)
		{
		//FIRST ROW
		for(int j=0;j<mat.length;j++)
		{
				 rowfirst=rowfirst+mat[0][j];

		}
		//System.out.print(rowfirst);
		for(int j=0;j<mat.length;j++)
		{
				 rowlast=rowlast+mat[mat.length-1][j];
		}
		//System.out.print(rowlast);
		for(int j=0;j<mat[0].length;j++)
		{
				 colfirst=colfirst+mat[j][0];
		}
		//System.out.	print(colfirst);
		for(int j=0;j<mat[0].length;j++)
		{
				 collast=collast+mat[j][mat.length-1];
		}
		//System.out.print(collast);

		for(int i=0;i<mat.length;i++)
		{
			for(int j=0;j<mat[0].length;j++)
			{
				if(i==j)
				{
					midd=midd+mat[i][j];
				}
			}
		}
		//System.out.print(midd);
		//System.out.println(totalsum);

		int a=0;
		int b=mat.length-1;
		for(b=mat.length-1;b>=0&&a<mat.length;b--)
		{
			totalsum=totalsum+mat[a][b];
			//System.out.println(mat[a][b]);
			a++;
		}
		totalsum=totalsum+midd+collast+rowfirst+colfirst+rowlast;
		if(mat.length%2!=0)
		{
		int half=mat.length/2;
		removesum=2*(mat[0][0])+2*(mat[0][mat.length-1])+2*(mat[mat.length-1][mat.length-1])+2*(mat[mat.length-1][0])+mat[half][half];
		System.out.print(totalsum-removesum);
		}
		else if(mat.length%2==0)
		{
			removesum=2*(mat[0][0])+2*(mat[0][mat.length-1])+2*(mat[mat.length-1][mat.length-1])+2*(mat[mat.length-1][0]);
		System.out.print(totalsum-removesum);
		}
		}
		else if(mat.length==1)
		{
			System.out.print("1");
		}
		else if(mat.length==0)
		{
			System.out.print("0");
		}





	}

}
