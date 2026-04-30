/** Majority Element
 * Problem link: https://leetcode.com/problems/majority-element/
 * 
 * Idea:
 *  The idea was use Boyer-Moore algorithm identifies the majority element by maintaining a candidate and a counter. 
 *  The counter increases with matches and decreases with mismatches, ultimately highlighting the element that survives this process. 
 * 
 * Complexity: O(n)
 * 
 */

package easy;

public class majorityElementSolution {
    public static int majorityElement(int[] nums) {
        int major = nums[0];
        int count = 1;

        for (int i = 1; i < nums.length; i++) {
            if (count == 0) {
                major = nums[i];
                count = 1;
            } else if (nums[i] == major) {
                count++;
            } else {
                count--;
            }
        }

        return major;
    }

    public static void main(String[] args) {
        int[] test1 = {3, 2, 3};
        System.out.println("Result 1: " + majorityElement(test1));

        int[] test2 = {2, 2, 1, 1, 1, 2, 2};
        System.out.println("Result 2: " + majorityElement(test2));
    }
}
