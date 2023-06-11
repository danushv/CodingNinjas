For a given string(str), remove all the consecutive duplicate characters.
Example:
Input String: "aaaa"
Expected Output: "a"

Input String: "aabbbcc"
Expected Output: "abc"

public class Solution {

	public static String removeConsecutiveDuplicates(String str) {
		//Your code goes here
		// int n=65;
		// char ch=(char) n;
		// System.out.println(ch);
		// return str;
		String result="";

		for(int i=0;i<str.length()-1;i++)
		{
				if(str.charAt(i)!=str.charAt(i+1))
				{
					result=result+str.charAt(i);
				}
		}
		result=result+str.charAt(str.length()-1);
		return result;
	}

}
