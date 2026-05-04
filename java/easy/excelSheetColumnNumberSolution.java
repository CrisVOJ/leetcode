/** Excel Sheet Column Number
 * Problem link: https://leetcode.com/problems/excel-sheet-column-number/
 * 
 * Idea:
 *  The approach consists of performing a base-26 conversion by iteratively calculating the result of the number relative to 26, mapping each ASCII character to its corresponding value.
 * 
 * Complexity: O(n)
 * 
 */

package easy;

public class excelSheetColumnNumberSolution {
    public static int titleToNumber(String columnTitle) {
        int result = 0;

        for (int i = 0 ; i < columnTitle.length() ; i++) {
            result = result * 26 + (columnTitle.charAt(i) - 'A' + 1);
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println("Result 1: " + titleToNumber("A"));
        System.out.println("Result 2: " + titleToNumber("AB"));
    }
}
