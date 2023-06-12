Sample Input 1:
abdefgbabfba
Sample Output 1:
b


public class Solution {

	public static char highestOccuringChar(String str) {
		//Your code goes here

		int [] freq=new int[256];
		char ans='a';
			int max=0;

		for(int i=0;i<str.length();i++)
		{
			freq[str.charAt(i)]++;
			if(freq[str.charAt(i)]>=max)
			{
				max=freq[str.charAt(i)];
				ans=str.charAt(i);
			}

		}
		return  ans;
	}

}
