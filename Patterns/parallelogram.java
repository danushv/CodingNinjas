Write a program to print parallelogram pattern for the given N number of rows.
For N = 4



The dots represent spaces.



import java.util.*;
public class Main {
	
	public static void main(String[] args) {
		// Write your code here

		Scanner input=new Scanner(System.in);
		int n=input.nextInt();

		for(int i=0;i<n;i++)
		{
			for (int space=0;space<i;space++)
			{
				System.out.print(" ");
			}
			for(int j=1;j<=n;j++)
			{
				System.out.print("*");
			}
			System.out.println();
		}

	}
}
