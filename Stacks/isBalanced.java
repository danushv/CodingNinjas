import java.util.*;
public class Solution {

    public static boolean isBalanced(String expression) {
        //Your code goes heres

         Stack<Character> stack=new Stack<Character>();
        for (int j=0;j<expression.length();j++)
        {
            char i=expression.charAt(j);
            if (i=='[' || i=='{' || i=='(')
            {
                stack.push(i);
            }
            else if(i==']' || i=='}' || i==')')
            {
                if (stack.isEmpty())
                    return false;
                
                else
                {
                    if (i==']')
                    {
                        if (stack.peek()!='[')
                            return false;
                        else
                            stack.pop();
                    }
                    
                    else if (i=='}')
                    {
                        if (stack.peek()!='{')
                            return false;
                        else
                            stack.pop();
                    }
                    
                    else if (i==')')
                    {
                        if (stack.peek()!='(')
                            return false;
                        else
                            stack.pop();
                    }
                }
            }
            
        }
        return stack.isEmpty();
    }
}
