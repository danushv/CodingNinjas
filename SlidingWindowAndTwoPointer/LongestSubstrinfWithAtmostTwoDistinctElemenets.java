import java.util.HashMap;
import java.util.Map;

public class Solution {
	public static int lengthOfLongestSubstring(String s) {
		// Write your code here.
		// base case

		char []arr=s.toCharArray();
		int n=arr.length;
		if(n<3)
		return n;

		// table;
		Map<Character,Integer> hm=new HashMap<>();

		// maxLength;

		int maxLength=0;
		//int curr=Integer.MIN_VALUE;

		//indexes??
		int l=0;
		int r=0;

		while(r<arr.length)
		{
			hm.put(arr[r],hm.getOrDefault(arr[r], 0)+1);

			if(hm.size()>2)
			{
// if there are 3 , we reduce  the left pointer by one and when it becomes zero we remove it 
// Only when there are only 2 we increment right 
			hm.put(arr[l],hm.get(arr[l])-1);
			if(hm.get(arr[l])==0)
			hm.remove(arr[l]);
			l++;
			}
			maxLength=Math.max(maxLength,r-l+1);
			r++;
		}

		return maxLength;

		
	}
}
