import java.util.* ;
import java.io.*; 
public class Solution 
{
	public static boolean findPairSum(int[] arr, int target) 
	{
		// Write your code here
		int n=arr.length;
		int i=0;
		for( i=0;i<n-1;i++)
		{
			if(arr[i]>arr[i+1])
			break;
		}

		int right=i;
		int left=(i+1)%n;

		while(left!=right)
		{
			if(arr[right]+arr[left]==target)
			return true;
			else if(arr[right]+arr[left]<target)
			{
				left=(left+1)%n;
			}
			else if(arr[right]+arr[left]>target)
			{
				right=(n+right-1)%n;
			}
		}
		return false;
	}
}
