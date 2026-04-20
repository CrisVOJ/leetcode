/** Single Number
 * Problem link: https://leetcode.com/problems/single-number/
 * 
 * Idea:
 *  We leverage the XOR operation because x ^ x = 0 and x ^ 0 = x. We initialize single = 0 and XOR every element in the array. Duplicates cancel out, and the single number remains.
 * 
 * Complexity: O(n)
 * 
 */

package easy;

public class singleNumberSolution {
    public static int singleNumber(int[] nums) {
        int single = 0;

        for (int i = 0 ; i < nums.length ; i++) {
            single = single ^ nums[i];
        }

        return single;
    }

    public static void main(String[] args) {
        int[] test1 = {2, 2, 1};
        System.out.println("Result 1: " + singleNumber(test1));

        int[] test2 = {4, 1, 2, 1, 2};
        System.out.println("Result 2: " + singleNumber(test2));

        int[] test3 = {1};
        System.out.println("Result 2: " + singleNumber(test3));
    }
}
