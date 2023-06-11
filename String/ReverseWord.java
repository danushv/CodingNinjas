Reverse the given string word wise. That is, 
the last word in given string should come at 1st place, last second word at 2nd place and so on. 
Individual words should remain as it is

Sample Output 1:
Ninjas Coding to Welcome
Sample Input 2:
Always indent your code

public class Solution {
	public static String reverseWordWise(String input) {
		// Write your code here

		// String result="";
		
		// int end=input.length()-1;
		
		// for(int i=input.length()-1;i>=0;i--)
		// {
		// 	//System.out.println(input.charAt(i));
		// 	if(input.charAt(i)==' ')
			

		// 	{
		// 		int start=i;
		// 		String temp="";
		// 		temp=input.substring(start+1,end);
		// 		//System.out.print(temp);
		// 		result=result+temp+" ";
		// 	}
		// 	end=i;
		// }
		// return result;
		String reversed=new String();
		for(int i=input.length()-1;i>=0;i--)
		{
			reversed=reversed+input.charAt(i);
		}
		int start=0;
		int j=0;
		String result="";
		for(j=0;j<reversed.length();j++)
		{
			if(reversed.charAt(j)==' ')
			{
				String back="";
				int end=j-1;
				for(int k=end;k>=start;k--)
				{
					back=back+reversed.charAt(k);
				}
				result=result+back+" ";
				start=j+1;
			}
		}
		String back="";
		int end=j-1;
		for(int k=end;k>=start;k--)
		{
			back=back+reversed.charAt(k);

		}
		result=result+back;

		return result;

	}
}
