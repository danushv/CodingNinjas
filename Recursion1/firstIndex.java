
public class Solution {

	public static int firstindexhelper(int input[],int x,int index)
	{
		int n=input.length;
		if(index==n )
		{
			return -1;
		}
		if(input[index]==x)
		{
			return index;
		}
		int got = firstindexhelper(input,x,index+1);
			if(got>=0)
			{
				return got;
			}
			return -1;
		
		
	}

	public static int firstIndex(int input[], int x) {
		/* Your class should be named Solution
		 * Don't write main().
		 * Don't read input, it is passed as function argument.
		 * Return output and don't print it.
	 	 * Taking input and printing output is handled automatically.
		*/
		return firstindexhelper(input,x,0);
	}
	
}
