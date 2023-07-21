
public class Solution {

	public static int[] stockSpan(int[] price) {
		//Your code goes here
		int []answer=new int[price.length];
		answer[0]=1;
		for(int i=1;i<price.length;i++)
		{
			int count=1;
			for(int j=i-1;j>=0&&price[i]>price[j];j--)
			{
				count++;
			}
			answer[i]=count;

		}

		return answer;
	}

}
