/** Integer to Roman
 * Problem link: https://leetcode.com/problems/integer-to-roman/
 * 
 * Idea:
 *  The idea was to create two parallel arrays, one for the integer values and another for their corresponding Roman numeral representations. 
 *  And reduce the number by the largest possible value while appending the corresponding Roman numeral to the result string until the number is reduced to zero.
 * 
 * Complexity: O(n)
 * 
 */

package medium;

public class integerRomanSolution {
    public static String intToRoman(int num) {
        StringBuilder result = new StringBuilder();

        int[] numsList = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] stringsList = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        for (int i = 0 ; i < numsList.length ; i++) {
            while (numsList[i] <= num) {
                result.append(stringsList[i]);
                num -= numsList[i];
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println("Result 1: " + intToRoman(1));
        System.out.println("Result 2: " + intToRoman(90));
        System.out.println("Result 3: " + intToRoman(1994));
    }
}
