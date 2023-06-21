3
Sample Output 1 :
1=1
1+2=3
1+2+3=6


import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		// Write your code here

		Scanner input=new Scanner(System.in);
		int n=input.nextInt();
		if(n>0)
		{
		System.out.println("1=1");
		int result=0;
		for(int i=2;i<=n;i++)
		{
			int count=0;
			for(int j=1;j<=i-1;j++)
			{
				 count=count+j;
				System.out.print(j+"+");
				
			}
			result=i+count;
			System.out.print(i+"="+ result );
			System.out.println();
		}
	}
	}
}
