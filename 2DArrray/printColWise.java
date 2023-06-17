public class Solution {
    public static int[] printColWise(int [][]a) {
        // Write your code here.
        int row=a.length;
        int col=a[0].length;
        int size=row*col;
        int arr[]=new int[size];
        int counter=0;
        for(int i=0;i<col;i++)
        {
            for(int j=0;j<row;j++)
            {
                int val=a[j][i];
                arr[counter]=val;
                counter++;
            }
        }
        return arr;
    }
}
