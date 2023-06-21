Explanation For Sample Input 1 :
For test case 1 :
    The first subarray is ‘1,0’ starting at index 0, and the second is ‘0,1’ starting at index 1.
Sample Input 2 :
1
2
0 0
2
1 1
Sample Output 2 :
0
0


import java.util.* ;
import java.io.*; 

public class Solution {
    static int numberOfSubarrays(int n, int arr[]) {
        // Write your code here.
        int output=0;


         for(int i=0;i<arr.length-1;i++)
         {

            if(arr[i]==0&&arr[i+1]==1)
             {
                 output++;
             }
            else if(arr[i]==1&&arr[i+1]==0)
             {
                 output++;
             }

         }
         return output;
        
    }
}
