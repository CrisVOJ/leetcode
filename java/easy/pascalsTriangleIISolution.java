/** Pascal's Triangle II
 * Problem link: https://leetcode.com/problems/pascals-triangle-ii/
 * 
 * Idea:
 *  Main idea was iteratively construct the row using the multiplicative formula for binomial coefficients.
 *  Starting from the first element (which is always 1), each next value is computed as:
 *     current * (rowIndex - i + 1) / i
 * 
 * Complexity: O(rowIndex)
 */

package easy;

import java.util.ArrayList;
import java.util.List;

public class pascalsTriangleIISolution {
    public static List<Integer> getRow(int rowIndex) {
        List<Integer> row = new ArrayList<>();
        row.add(1);

        for (int i = 1 ; i <= rowIndex ; i++) {
            long nextValue = (long) row.get(i - 1) * (rowIndex - i + 1) / i;
            row.add( (int) nextValue );
        }

        return row;
    }

    public static void main(String[] args) {
        System.out.println("Result 1: " + getRow(3));
        System.out.println("Result 2: " + getRow(0));
        System.out.println("Result 3: " + getRow(1));
    }
}
