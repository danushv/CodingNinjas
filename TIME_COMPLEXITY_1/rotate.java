
public class Solution {  

    public static void rotate(int[] arr, int d) {
    	//Your code goes here
        if(arr.length>0)
         d=d%arr.length;
        
        reverse(arr,0,d-1);
        reverse(arr,d,arr.length-1);
        reverse(arr,0,arr.length-1);
        //reverse(arr,0,d-1);
        
    }

    public static void reverse(int[]arr,int start,int end)
    {
        while(start<end)
        {
            int temp=arr[start];
            arr[start]=arr[end];
            arr[end]=temp;
            start++;
            end--;
        }
    }

}
