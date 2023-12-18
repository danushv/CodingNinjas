public class Solution {

	public static String removeConsecutiveDuplicates(String s) {
		// Write your code here
		if(s.length()<=1)
		{
			return s;
		}
		if(s.charAt(0)==s.charAt(1))
		{
				String smalloutput=removeConsecutiveDuplicates(s.substring(1));
				return  smalloutput;
		}
		else
		{
						String smalloutput=removeConsecutiveDuplicates(s.substring(1));
						return s.charAt(0) + smalloutput;
		}
	}

}
