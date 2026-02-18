import java.util.Arrays;

/** Two Sum
 * Problem link: https://leetcode.com/problems/two-sum/
 * 
 * Idea:
 *  I believe I can iterate through the list items from each element to the last until I find the expected result
 * 
 * Complexity: O(n^2)
 */
public class twoSumSolution {
    public static int[] twoSum(int[] nums, int target) {
        for (int i = 0 ; i < nums.length ; i++) {
            if (i + 1 == nums.length) {
                int[] result = {i, i + 1};
                return result;
            }

            for (int j = i + 1 ; j < nums.length ; j++) {
                if (nums[i] + nums[j] == target) {
                    int[] result = {i, j};
                    return result;
                }
            }
        }

        return null;
    }

    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};

        int[] solution = twoSum(nums, 9);

        System.out.println("Solution: " + Arrays.toString(solution));
    }
}
