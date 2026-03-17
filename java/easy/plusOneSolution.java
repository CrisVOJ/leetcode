/** Plus One
 * Problem link: https://leetcode.com/problems/plus-one/
 * 
 * Idea:
 *  Main idea was to create another integer array for the expected output. This array needs one extra space compared to the original array in case it contains a 9. Otherwise, I only need to modify the original array if a digit is less than 9.
 * 
 * Complexity: O(n)
 */
package easy;

import java.util.Arrays;

public class plusOneSolution {
    public static int[] plusOne(int[] digits) {
        for (int i = digits.length - 1 ; i >= 0 ; i--) {
            if (digits[i] < 9) {
                digits[i] ++;
                return digits;
            }

            digits[i] = 0;
        }

        int[] result = new int[digits.length + 1];
        result[0] = 1;

        return result;
    }

    public static void main(String[] args) {
        int[] test1 = {1, 2, 3};
        System.out.println("Result 1: " + Arrays.toString(plusOne(test1)));

        int[] test2 = {9};
        System.out.println("Result 2: " + Arrays.toString(plusOne(test2)));
    }
}
