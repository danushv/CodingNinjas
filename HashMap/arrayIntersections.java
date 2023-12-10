import java.util.HashMap;


public class Solution {

	public static void printIntersection(int[] arr1,int[] arr2){
		/* Your class should be named Solution
		 * Don't write main().
		 * Don't read input, it is passed as a function argument.
		 * Return output and don't print it.
	 	 * Taking input and printing output is handled automatically.
        */
		// Algorithm
		//You put one array in hashmap and another, keep it in the array because ypu also want duplicate elements 
		// in case if you dont want duplicate elements use two hashmap and you can also create for each loops 
		// go thru the for loop of arr and check if it is present in hashmap and print
		// why you use hashmap -> it saves up some time because of faster lookup
		HashMap<Integer,Integer> map1=new HashMap<Integer,Integer> ();
		//HashMap<Integer,Integer> map2=new HashMap<Integer,Integer> ();
			for(int i=0;i<arr1.length;i++)
			{
				if(map1.containsKey(arr1[i]))
				{
					map1.put(arr1[i],map1.get(arr1[i])+1);
				}
				else{
					map1.put(arr1[i],1);
				}
			}
			for(int i=0;i<arr2.length;i++ )
			{
				if(map1.containsKey(arr2[i]) && map1.get(arr2[i])>0)
				{
						System.out.println(arr2[i]);
						map1.put(arr2[i],map1.get(arr2[i])-1);
				}
			}
	}
}
