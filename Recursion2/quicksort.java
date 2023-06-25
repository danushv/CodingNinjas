


public class Solution {

	public static int quickSorthelper(int[] input,int startIndex, int endInedx) {

		int pivot=input[startIndex];

		int smallerNumberCount=0;

		for(int i=startIndex+1;i<=endInedx;i++)
		{
			if(input[i]<=pivot)
			{
				smallerNumberCount++;
			}
		}
		int temp=input[startIndex+smallerNumberCount];
		input[startIndex+smallerNumberCount]=pivot;
		input[startIndex]=temp;

		int i=startIndex;
		int j=endInedx;

		while(i<j)
		{
			if(input[i]<pivot)
			i++;
			else if(input[j]>=pivot)
			{
				j--;
			}
			else
			{
				 temp=input[i];
				input[i]=input[j];
				input[j]=temp;
				i++;
				j--;
			}
		}
		return startIndex+smallerNumberCount;

	}
	
	public static void quickSort(int[] input,int startIndex, int endInedx) {
		/* Your class should be named Solution
		 * Don't write main().
		 * Don't read input, it is passed as function argument.
		 * No need to print or return the output.
		 * Taking input and printing output is handled automatically.
		 */
		if(startIndex>=endInedx)
		{
			return;
		}
		int pivot=quickSorthelper(input, startIndex, endInedx);
		quickSort(input, startIndex, pivot-1);
		quickSort(input, pivot+1, endInedx);



	}
	
}
