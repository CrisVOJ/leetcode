/** Add Binary
 * Problem link: https://leetcode.com/problems/add-binary/
 * 
 * Idea:
 *  The main idea was to iterate through both strings simultaneously from right to left, adding their digits until both strings were exhausted and no carry remained.
 * 
 * Complexity: O(n + m)
 */

package easy;

public class addBinarySolution {
    public static String addBinary(String a, String b) {
        StringBuilder result = new StringBuilder();
        int carry = 0;
        int i = a.length() - 1;
        int j = b.length() - 1;

        while (i >= 0 || j >= 0 || carry != 0) {
            int sum = carry;

            if (i >= 0) {
                sum += a.charAt(i) - '0';
                i --;
            }

            if (j >= 0) {
                sum += b.charAt(j) - '0';
                j --;
            }

            carry = sum / 2;
            result.append(sum % 2);
        }

        return result.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println("Result 1: " + addBinary("11", "1"));
        System.out.println("Result 2: " + addBinary("1010", "1011"));
    }
}
