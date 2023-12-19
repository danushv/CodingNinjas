public class solution {

	public static void printKeypad(int input){
		// Write your code here

		 printKeypadHelper(input,"");

		

	}

	public static String getoption(int n)
	{
		if(n==2)
		return "abc";
	else if(n==3)
		return "def";
	else	if(n==4)
		return "ghi";
	else	if(n==5)
		return "jkl";
	else	if(n==6)
		return "mno";
	else	if(n==7)
		return "pqrs";
	else	if(n==8)
		return "tuv";
	else	if(n==9)
		return "wxyz";
return "";
	}
public static void printKeypadHelper(int input,String presentString)
{
	if(input==0)
		{
		System.out.println(presentString);
			return;
		}

		String a=getoption(input%10);
		int sinput =input/10;

		for(int i=0;i<a.length();i++)
		{
					printKeypadHelper(sinput,a.charAt(i)+presentString);
		}
		// if(a.length()==4)
		// {
		
		// printKeypadHelper(sinput,a.charAt(1)+presentString);
		// printKeypadHelper(sinput,a.charAt(2)+presentString);
		// printKeypadHelper(sinput,a.charAt(3)+presentString);
		// }
		// else
		// {
		// printKeypadHelper(sinput,a.charAt(0)+presentString);
		// printKeypadHelper(sinput,a.charAt(1)+presentString);
		// printKeypadHelper(sinput,a.charAt(2)+presentString);
		// }
}


}
