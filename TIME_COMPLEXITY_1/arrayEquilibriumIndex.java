public class Solution {

	public static int arrayEquilibriumIndex(int[] arr){  
		//Your code goes here
		if(arr.length<2)
		{
			return -1;
		}

		int equib=arr[0];
		int leftsum=0;
		int rightsum=0;
		int output=-1;

		for(int i=1;i<arr.length;i++)
		{
			rightsum=rightsum+arr[i];
		}

		for(int i=0;i<arr.length-1;i++)
		{

			equib=i;

		if(leftsum==rightsum)
		{
			output=equib;
			break;

		}
		else
		{
			leftsum=leftsum+arr[equib];
			rightsum=rightsum-arr[equib+1];
		}
		}

		return output;
	}
}
