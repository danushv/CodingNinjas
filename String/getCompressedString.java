Write a program to do basic string compression. For a character which is consecutively repeated more than once,
 replace consecutive duplicate occurrences with the count of repetitions.


Sample Input 2:
aaabbcddeeeee
Sample Output 2:
a3b2cd2e5


public class Solution {
	public static String getCompressedString(String str) {
		// Write your code here.
		String result="";
		int count=1;
		int i=0;

		for( i=0;i<str.length()-1;i++)
		{

			if(str.charAt(i)==str.charAt(i+1))
			{
				count ++;
			}
			else if(str.charAt(i)!=str.charAt(i+1))
			{
				if(count>1)
				{
					result=result+str.charAt(i);
					result=result+count;
					count=1;
				}
				else 
				{
					result=result+str.charAt(i);
					count=1;
				}
			}

		}

			if(count>1)
			{
				result=result+str.charAt(i);
				result=result+count;
			}
			else //if( count==1 && str.charAt(str.length())!=str.charAt(str.length()-1))
			{
				result=result+str.charAt(i);
			}
		
		return result;
	}

}
