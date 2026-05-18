/** Generate Parentheses
 * Problem link: https://leetcode.com/problems/generate-parentheses/description/
 * 
 * Idea:
 *  The algorithm employs a controlled backtracking approach to generate only valid parenthesis combinations.
 *  By leveraging two counters to track open and close brackets, it recursively appends '(' if open < n, 
 *  and ')' if close < open, avoiding the generation of malformed sequences.
 * 
 * Complexity: O((4^n) / (n * sqrt(n)))
 * 
 */

package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class generateParenthesesSolution {
    public static List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();

        backtrack(result, 0, 0, n, new StringBuilder());

        return result;
    }

    public static void backtrack(List<String> result, int open, int close, int n, StringBuilder current) {
        if (current.length() == 2 * n) {
            result.add(current.toString());
            return;
        }

        if (open < n) {
            current.append('(');
            backtrack(result, open + 1, close, n, current);
            current.deleteCharAt(current.length() - 1);
        }

        if (close < open) {
            current.append(')');
            backtrack(result, open, close + 1, n, current);
            current.deleteCharAt(current.length() - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println("Result 1: " + Arrays.toString(generateParenthesis(3).toArray()));
        System.out.println("Result 2: " + Arrays.toString(generateParenthesis(1).toArray()));
        System.out.println("Result 3: " + Arrays.toString(generateParenthesis(8).toArray()));
    }
}
