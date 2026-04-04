/** Reverse Integer Solution
 * Problem link: https://leetcode.com/problems/reverse-integer/
 * 
 * Idea:
 *  The main idea is to extract the last digit of the number using modulo, build the reversed number digit by digit, and check for overflow before updating the result. If reversing the number exceeds the 32-bit signed integer range, return 0.
 * 
 * Complexity: O(log10(n))
 */

package medium;

public class reverseIntegerSolution {
    public static int reverse(int x) {
        int reversed = 0;

        while (x != 0) {
            int digit = x % 10;

            x = x / 10;

            if ((reversed < Integer.MIN_VALUE / 10) || 
                (reversed > Integer.MAX_VALUE / 10) || 
                (reversed == Integer.MAX_VALUE / 10 && digit > 7) ||
                (reversed == Integer.MIN_VALUE / 10 && digit < -8)) {
                return 0;
            }

            reversed = (reversed * 10) + digit;
        }

        return reversed;
    }

    public static void main(String[] args) {
        System.out.println("Result 1: " + reverse(123));
        System.out.println("Result 2: " + reverse(-123));
        System.out.println("Result 3: " + reverse(2147483647));
    }
}
