package P4;

import java.util.Stack;

public class Problem4 {
    public static boolean balanceOrNot(String input){
        Stack<Character> stack = new Stack<>();

        for (char ch : input.toCharArray()){
            /*
            Iterates through the list
            Convert the input String into array
             */
            if (ch == '(' || ch == '{' ||ch == '['){
                stack.push(ch);
                /*
                Create the condition, where doesn't matter which brackets it is.
                As long it's a open bracket it will push it into the stack. (1st data)
                 */
            }
            else if (ch == ')' || ch == '}' ||ch == ']') {
                /*
                If this else if statement is true, then it needs to check if stack.isEmpty.
                If it is empty, program stop.
                 */
                if (stack.isEmpty())
                    return false;
            }

            char top = stack.pop();
            if (!isMatchingPair(top, ch)) {
                return false;
            }
        }
        return false;
    }
    private static boolean isMatchingPair(char open, char close) {
        /*
        Utility to help identify if the brackets is a matching pair
         */
        return (open == '(' && close == ')') ||
                (open == '[' && close == ']') ||
                (open == '{' && close == '}');
    }

    public static void main(String[] args) {

    }
}
