public class Solution {

	public static int maxArea(int[] height) {
	    // Write your code here.

		int apointer=0;
		int n=height.length;
		int bpointer=height.length-1;
		int max=Integer.MIN_VALUE;

		while(apointer<bpointer)
		{
			if(height[apointer]<=height[bpointer])
			{
				max=Math.max(max,((height[apointer])*(bpointer-apointer)));
				apointer++;
			}
			else if(height[bpointer]<height[apointer])
			{
				max=Math.max(max,((height[bpointer])*(bpointer-apointer)));
				bpointer--;
			}
			

		}
		return max;
	}
}
