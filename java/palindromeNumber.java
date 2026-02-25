/** Palindrome Number
 * Problem link: https://leetcode.com/problems/palindrome-number/
 * 
 * Idea:
 *  I considered two approaches to solve this problem. The first one uses arithmetic operations to reverse the number digit by digit. The second one converts the number to a string, and reverses it.
 * 
 * Complexity: O(n)
 */

public class palindromeNumber {
    public static boolean palindrome1(int x) {
        if (x >= 0) {
            int reversed = 0;
            int aux = x;

            while (aux >= 10) {
                reversed = (reversed + (aux % 10)) * 10;
                aux = aux / 10;
            }

            if ((reversed + aux) == x) {
                return true;
            }
        }
        return false;
    }

    public static boolean palindrome2(int x) {
        String sNum = String.valueOf(x);
        String invertNum = new StringBuilder(sNum).reverse().toString();

        if (sNum.equals(invertNum)) {
            return true;
        }

        return false;
    }

    public static void main(String[] args) {
        System.out.println("Palindrome 1 Result 1: " + palindrome1(121));
        System.out.println("Palindrome 1 Result 2: " + palindrome1(-121));
        System.out.println("Palindrome 1 Result 3: " + palindrome1(10));

        System.out.println("Palindrome 2 Result 1: " + palindrome2(121));
        System.out.println("Palindrome 2 Result 2: " + palindrome2(-121));
        System.out.println("Palindrome 2 Result 3: " + palindrome2(10));
    }
}
