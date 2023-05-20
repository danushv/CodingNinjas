
public class Solution {
    
    public static int findTriplet(int[] arr, int x) {
    	//Your code goes here
        int res=0;
        int n=arr.length;

        for(int i=0;i<n;i++)
        {
            for(int j=i+1;j<n;j++)
            {
                for(int k=j+1;k<n;k++)
                {
                    if(arr[i]+arr[j]+arr[k]==x)
                    {
                        res++;
                    }
                }
            }
        }
        return res;
    }

}
