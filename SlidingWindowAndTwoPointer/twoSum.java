import java.util.* ;
import java.io.*; 
public class Solution {
    public static int[] twoSum(int numbers[], int target) {
        // Write your code here..


        int i=0;
        int j=numbers.length-1;
        int []result=new int[2];

        while(i<j)
        {
            if (numbers[i]+numbers[j]==target)
            {
                result[0]=i;
                result[1]=j;
                return result;
            }
            else if(numbers[i]+numbers[j]<target)
            {
                        i++;
            }
             else if(numbers[i]+numbers[j]>target)
             {
                 j--;
             }
        }
        return result;
    }

}
