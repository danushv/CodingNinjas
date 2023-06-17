import java.util.Scanner;

public class Solution {
    public static int[] printRowWise(int [][]a) {
        // Write your code here.
        int rows=a.length;
        int col=a[0].length;
        int size=rows*col;
 
         int [] arr =new int [size];

    //      Scanner input=new Scanner(System.in);
    //  int t=input.nextInt();
    //  while(t-->0)
    //  {
    //   int N=input.nextInt();
     //int M=input.nextInt();
int counter=0;
        for(int i=0;i<rows;i++)
        {
            for(int j=0;j<col;j++)
            {
                    int val =a[i][j];
                    arr[counter]=val;
                    counter++;
            }
        }

    // }
        return arr;
     
    }
}
