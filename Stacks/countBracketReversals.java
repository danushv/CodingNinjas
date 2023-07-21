import java.util.*;
public class Solution {

	public static int countBracketReversals(String input) {
		//Your code goes here
		Stack<Character> stack=new Stack<Character>();
		for(int i=0;i<input.length();i++)
		{
			char c=input.charAt(i);

			if(c=='{')
			{
				stack.push(c);
			}
			else 
			{
					if(stack.isEmpty())
					{
						stack.push(c);
					}
					else if(stack.peek()=='{')
					{
						stack.pop();
					}
					else if(stack.peek()=='}')
					{
							stack.push(c);
					}	
			}

		}
		if (input.length()%2!=0)
		{
			return -1;
		}
// SO here if the input is {{ -> in this case c1 and c2 are same any one if you change it would be balanced
// in case if both are different then we have to  change both that is why c1 and c2 are checked
// also if the input length is odd it is obvious that it is unbalanced
		int count=0;
		while(!stack.isEmpty())
		{
			char c1=stack.pop();
			char c2=stack.pop();
			if(c1==c2)
			{
				count=count+1;

			}
			else
			{
				count=count+2;
			}
		}
			return count;
		// int openbracket=0;
		// int closebracket=0;
		// while(!stack.isEmpty())
		// {
		// 	char check=stack.pop();
		// 	if(check=='{')
		// 	{
		// 		openbracket++;
		// 	}
		// 	else 
		// 	{
		// 		closebracket++;
				
		// 	}
		// }
		//System.out.println(openbracket);
		//System.out.println(closebracket);

		// if(openbracket!=closebracket)
		// {
		// 	return -1;
		// }
		// else{
		// 	return ((openbracket+closebracket)/2);
		// }
			
		// int unbalance=stack.size();
		// if(unbalance%2!=0)
		// {
		// 	return -1;
		// }
		// else{
		// 	return unbalance/2;
		// }
	}

}
