Write a program to print the pattern for the given N number of rows.
For N = 4
1357
3571
5713
7135


import java.util.*;
public class Main {
	
	public static void main(String[] args) {
		// Write your code here
		Scanner input=new Scanner(System.in);
		//int printval=1;
				int n=input.nextInt();
		int maxval=(n*2)-1;


		for(int i=1;i<=n;i++)
		{
			int valuetoprint=(2*i)-1;
			for(int j=1;j<=n;j++)
			{
				if(valuetoprint<=maxval)
				{
					System.out.print(valuetoprint);
					valuetoprint=valuetoprint+2;
				}
				else if(valuetoprint>maxval)
				{
					valuetoprint=1;
					System.out.print(valuetoprint);
					valuetoprint=valuetoprint+2;

				}

			
		}
		System.out.println();
		}

		
	}
}
