import java.util.*;

public class Solution {

    private static boolean isOperator(char ch) {
        return ch == '+' || ch == '-' || ch == '*' || ch == '/';
    }

    public static boolean checkRedundantBrackets(String expression) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < expression.length(); i++) {
            char a = expression.charAt(i);
            boolean foundOperator = false;
            if (a == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    char top = stack.pop();
                    if (isOperator(top)) {
                        foundOperator = true;
                    }
                }
                if (!foundOperator) {
                    return true;
                }
                stack.pop();
            } else {
                stack.push(a);
            }
        }
        return false;
    }
}
