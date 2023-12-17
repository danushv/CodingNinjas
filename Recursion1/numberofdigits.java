public class Solution {
    public static int countDigits(int n){
        // Write your code here.
        if(n<=9)
        {
            return 1;
        }

        int smallouput=countDigits( n/10);
        int output = smallouput+1;
        return output;
    }
}
