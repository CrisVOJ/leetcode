/** Zigzag Conversion
 * Problem link: https://leetcode.com/problems/zigzag-conversion/
 * 
 * Idea:
 *  The main idea is to use an array of strings to organize the characters of the input string into a zigzag pattern, as required by the problem.
 * 
 * Complexity: O(n)
 */

package medium;

public class zigzagConversionSolution {
    public static String convert(String s, int numRows) {
        if (numRows == 1 || numRows >= s.length()) {
            return s;
        }

        StringBuilder[] stringRows = new StringBuilder[numRows];
        for (int i = 0 ; i < stringRows.length ; i++) {
            stringRows[i] = new StringBuilder();
        }

        int position = 0;
        int direction = -1;

        for (int i = 0 ; i < s.length() ; i++) {
            if (position == 0 || position == stringRows.length - 1) {
                direction *= -1;
            }

            stringRows[position].append(s.charAt(i));

            position += direction;
        }

        StringBuilder result = new StringBuilder(s.length());

        for (int i = 0 ; i < stringRows.length ; i++) {
            result.append(stringRows[i]);
        }

        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println("Result 1: " + convert("PAYPALISHIRING", 3));
    }
}
