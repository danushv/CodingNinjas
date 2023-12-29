public class Solution 
{
	public static String reverseString(String str) 
	{
		//Write your code here
		String result="";
		String smalloutput="";
		int l=0;
		int r=0;
		str=str.trim();
		for(int i=1;i<str.length();i++)
		{
			if(str.charAt(i)==' ')
			{
			 smalloutput=str.substring(l,i)+" ";

				l=i+1;
				result=smalloutput+result;
			}
		}
		result=str.substring(l)+" "+result;
		result=result.trim();
		return result;
	}
}
