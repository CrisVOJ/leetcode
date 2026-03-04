import java.util.HashMap;
import java.util.Stack;

/** Valid Parenthesis
 * Problem link: https://leetcode.com/problems/valid-parentheses/
 * 
 * Idea:
 *  I use a HashMap to map each opening bracket to its corresponding closing bracket. Then I scan the string from left to right using a stack. Every time I see an opening bracket, I push it onto the stack. When I see a closing bracket, I pop the last opening bracket from the stack and check whether its mapped closing bracket matches the current character. If it doesn’t match, the string is invalid.
 * 
 * Complexity: O(n)
 */

public class validParenthesisSolution {
    public static boolean validParenthesis(String s) {
        if (s.length() <= 1) {
            return false;
        }

        HashMap<String, String> parenthesis = new HashMap<>();
        parenthesis.put("(", ")");
        parenthesis.put("[", "]");
        parenthesis.put("{", "}");

        Stack<String> openingParenthesis = new Stack<>();
        for (int i = 0 ; i < s.length() ; i++) {
            if ("([{".contains(String.valueOf(s.charAt(i)))) {
                openingParenthesis.push(String.valueOf(s.charAt(i)));
            } else {
                if (openingParenthesis.isEmpty()) {
                    return false;
                }
                String lastCouple = parenthesis.get(openingParenthesis.pop());
                if (!lastCouple.equals(String.valueOf(s.charAt(i)))) {
                    return false;
                }
            }
        }

        if (!openingParenthesis.isEmpty()) {
            return false;
        }

        return true;
    }
    public static void main(String[] args) {
        System.out.println("Result: " + validParenthesis("("));
        System.out.println("Result: " + validParenthesis("(("));
        System.out.println("Result: " + validParenthesis("()"));
        System.out.println("Result: " + validParenthesis("()[]{}"));
        System.out.println("Result: " + validParenthesis("(]"));
        System.out.println("Result: " + validParenthesis("([])"));
        System.out.println("Result: " + validParenthesis("([)]"));
    }
}
