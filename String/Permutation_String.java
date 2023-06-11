Permutation of string 
For a given two strings, 'str1' and 'str2', check whether they are a permutation of each other or not.

Sample Input 1:
abcde
baedc
Sample Output 1:
true
Sample Input 2:
abc
cbd
Sample Output 2:
false

public class Solution {

	public static boolean isPermutation(String str1, String str2) {
		//Your code goes here
		boolean flag=true;
		
		if(str1.length()!=str2.length())
		return false;


		int [] freq=new int [256];
		int []freqq=new int[256];
		for(int i=0;i<str1.length();i++)
		{
			char the=str1.charAt(i);
			int ascii=(int)the;
			freq[ascii]++;
		}

		for(int i=0;i<str2.length();i++)
		{
			char the=str2.charAt(i);
			int ascii=(int)the;
			freqq[ascii]++;
		}
		for(int i=0;i<freq.length;i++)
		{
			if(freq[i]!=freqq[i])
			{
				flag=false;
				break;
			}
		}
		return flag;

	}

}
