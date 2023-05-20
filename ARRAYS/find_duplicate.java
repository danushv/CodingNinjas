You have been given an integer array/list(ARR) of size N which contains numbers from 0 to (N - 2). Each number is present at least once. That is, if N = 5, the array/list constitutes values ranging from 0 to 3 and among these, there is a single integer value that is present twice.
 You need to find and return that duplicate number present in the array.

Sample Input 1:
1
9
0 7 2 5 4 7 1 3 6
Sample Output 1:
7


public class Solution{  
    
    public static int duplicateNumber(int arr[]) {

        int n=arr.length;
         int d=0;

        for(int i=0;i<n;i++)
        {
            for(int j=i+1;j<n;j++)
            {
                if(arr[i]==arr[j])
                {
                    d=arr[i];
                }
            }
        }
        return d;
    	//Your code goes here
    }
}
