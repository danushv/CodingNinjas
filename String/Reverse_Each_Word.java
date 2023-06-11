Aadil has been provided with a sentence in the form of a string as a function parameter. 
The task is to implement a function so as to print the sentence such that each word in the sentence is reversed.

Sample Input 2:
Always indent your code
Sample Output 2:
syawlA tnedni ruoy edoc
public class Solution {

	public static String reverseEachWord(String str) {
		//Your code goes here

		 int space=0;
        String temp="";
        String result="";
		int i=0;
        
        
        for( i=0;i<str.length();i++)
        {
            if(str.charAt(i)==' ')
            {
				String back="";
                int spaceend=i-1;
                for(int j=spaceend;j>=space;j--)
                {
                    back=back+str.charAt(j);
                }
                result=result+back+" ";
              
                
                space=i+1;
            }
        }

		 int spaceend=i-1;
		 String back="";
                for(int j=spaceend;j>=space;j--)
                {
                    back=back+str.charAt(j);
                }
                result=result+back+" ";
              

        return result;
	}

}
