/** Excel Sheet Column Title
 * Problem link: https://leetcode.com/problems/excel-sheet-column-title/
 * 
 * Idea:
 *  The approach consists of performing a base-26 conversion by iteratively calculating the remainder of the number relative to 26, mapping each value to its corresponding ASCII character.
 * 
 * Complexity: O(n)
 * 
 */

package easy;

public class excelSheetColumnTitleSolution {
    public static String convertToTitle(int columnNumber) {
        StringBuilder result = new StringBuilder();

        while (columnNumber > 0) {
            columnNumber --;

            int res = columnNumber % 26;
            
            result.insert(0, (char) (res + 'A'));

            columnNumber /= 26;
        }

        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println("Result 1: " + convertToTitle(1));
        System.out.println("Result 2: " + convertToTitle(26));
        System.out.println("Result 3: " + convertToTitle(28));        
    }
}
