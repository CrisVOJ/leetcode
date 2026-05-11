/** Letter Combinations of a Phone Number
 * Problem link: https://leetcode.com/problems/letter-combinations-of-a-phone-number/
 * 
 * Idea:
 *  Main approach to solve this problem is backtracking, we use a HashMap to store the mapping of digits to letters, 
 *  and recursively generate combinations by appending each letter to the current combination.
 * 
 * Complexity: O(4^n)
 * 
 */

package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class letterCombinationPhoneNumSolution {
    public static List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();

        HashMap<Character, String> phoneMap = new HashMap<>();
        phoneMap.put('2', "abc");
        phoneMap.put('3', "def");
        phoneMap.put('4', "ghi");
        phoneMap.put('5', "jkl");
        phoneMap.put('6', "mno");
        phoneMap.put('7', "pqrs");
        phoneMap.put('8', "tuv");
        phoneMap.put('9', "wxyz");

        backtrack(result, phoneMap, digits, 0, new StringBuilder());

        return result;
    }

    public static void backtrack(List<String> result, HashMap<Character, String> phoneMap, String digits, int index, StringBuilder current) {
        if (index == digits.length()) {
            result.add(current.toString());
            return;
        }

        String letters = phoneMap.get(digits.charAt(index));

        for (char letter : letters.toCharArray()) {
            current.append(letter);
            backtrack(result, phoneMap, digits, index + 1, current);
            current.deleteCharAt(current.length() - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println("Result 1: " + Arrays.toString(letterCombinations("23").toArray()));
    }
}
