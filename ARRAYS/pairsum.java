public class Solution {  

    public static int pairSum(int arr[], int x) {
    	//Your code goes here
        int count=0;
        int n=arr.length;
            for(int i=0;i<n;i++)
            {
                for(int j=i+1;j<n;j++)
                {
                    if(arr[i]+arr[j]==x)
                    {
                        count++;
                    }
                }
            }
            return count;
    }
}
