/** Pascal's Triangle
 * Problem link: https://leetcode.com/problems/pascals-triangle/
 * 
 * Idea:
 *  Main idea was iteratively construct each row based on the previous one.
 * 
 * Complexity: O(n^2)
 */

package easy;

import java.util.ArrayList;
import java.util.List;

public class pascalsTriangleSolution {
    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        
        List<Integer> firstRow = new ArrayList<>();
        firstRow.add(1);

        result.add(firstRow);

        for (int i = 1 ; i < numRows ; i++) {
            List<Integer> prevRow = result.get(i - 1);
            List<Integer> currentRow = new ArrayList<>();
            currentRow.add(1);
            
            for (int j = 1 ; j < i ; j++) {
                currentRow.add(prevRow.get(j - 1) + prevRow.get(j));
            }

            currentRow.add(1);

            result.add(currentRow);
        }

        return result;
    }

    public static void main(String[] args) {
        for (List<Integer> row : generate(5)) {
            System.out.println(row);
        }
    }
}
