import java.util.HashMap;

public class Solution {

    public static int maxFrequencyNumber(int[] arr){ 
		/* Your class should be named Solution
		 * Don't write main().
		 * Don't read input, it is passed as function argument.
		 * Return output and don't print it.
	 	 * Taking input and printing output is handled automatically.
		*/
		HashMap<Integer,Integer> map=new HashMap<Integer,Integer>();
		for(int i=0;i<arr.length;i++)
		{
			if(map.containsKey(arr[i]))
			{
					map.put(arr[i],map.get(arr[i])+1);
			}
			else
			{
				map.put(arr[i],1);
			}
		}
		int max=Integer.MIN_VALUE;
		int result=Integer.MAX_VALUE;
		for(HashMap.Entry<Integer,Integer> entry:map.entrySet())
		{
			if(map.size()<=0)
			return 0;
			if(entry.getValue()>max|| (entry.getValue() == max && entry.getKey() < result))
			{
			result=entry.getKey();
			max=entry.getValue();
			}
		}
		return result;
    }
}

