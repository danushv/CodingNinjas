public class Solution {

	public static boolean checknumberhelper(int input [],int x,int index)
	{
		if(index==input.length)
		{
			return false;
		}
		boolean check=checknumberhelper(input,x,index+1);

		if(check==true)
		{
			return true;
		}
		if(input[index]==x)
		{
			return true;
		}

		return false;

	}
	
	public static boolean checkNumber(int input[], int x) {
		/* Your class should be named Solution
		 * Don't write main().
		 * Don't read input, it is passed as function argument.
		 * Return output and don't print it.
	 	 * Taking input and printing output is handled automatically.
		*/
		

		return checknumberhelper(input,x,0);
		
	}
}
