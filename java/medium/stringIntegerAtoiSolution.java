/** String to Integer (atoi)
 * Problem link: https://leetcode.com/problems/string-to-integer-atoi/
 * 
 * Converts a string to a 32-bit signed integer with proper handling of:
 * - Leading whitespace
 * - Optional '+' or '-' sign
 * - Digit conversion with overflow protection
 * - Early termination on non-digit characters
 * 
 * Returns INT_MAX or INT_MIN when the value is out of 32-bit integer range.
 * 
 * Complexity: O(n)
 */

package medium;

public class stringIntegerAtoiSolution {
    public static int myAtoi(String s) {
        if (s.length() == 0) return 0;

        int i = 0;
        int n = s.length();

        while (i < n && s.charAt(i) == ' ') {
            i++;
        }

        if (i == n) return 0;
        
        int sign = 1;
        if (s.charAt(i) == '-') {
            sign = -1;
            i++;
        } else if (s.charAt(i) == '+') {
            i++;
        }
        
        int result = 0;

        while (i < n && Character.isDigit(s.charAt(i))) {
            int digit = s.charAt(i) - '0';

            if (result > Integer.MAX_VALUE / 10 || 
                (result == Integer.MAX_VALUE / 10 && digit > 7)) {
                return (sign == 1) ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }

            result = 10 * result + digit;
            i++;
        }

        return sign * result;
    }

    public static void main(String[] args) {
        System.out.println("Result 1: " + myAtoi("42"));
        System.out.println("Result 2: " + myAtoi("   -42"));
        System.out.println("Result 3: " + myAtoi("4193 with words"));
        System.out.println("Result 4: " + myAtoi("words and 987"));
        System.out.println("Result 5: " + myAtoi("-91283472332"));
        System.out.println("Result 6: " + myAtoi("2147483648"));
        System.out.println("Result 7: " + myAtoi("+-12"));
        System.out.println("Result 8: " + myAtoi("00000-42a1234"));
    }
}
