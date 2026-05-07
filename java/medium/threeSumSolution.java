/** 3 Sum
 * Problem link:https://leetcode.com/problems/3sum/
 * 
 * Idea:
 *  Sort the array and use a fixed pointer with a two-pointer approach (left/right) to find triplets, 
 *  skipping adjacent duplicate values to ensure unique results.
 * 
 * Complexity: O(n^2)
 * 
 */

package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class threeSumSolution {
    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);

        List<List<Integer>> triplets = new ArrayList<>();

        for (int i = 0 ; i < nums.length - 2 ; i++) {
            if (nums[i] > 0) break;
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            int j = i + 1, k = nums.length - 1;

            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum < 0) {
                    j ++;
                } else if (sum > 0) {
                    k --;
                } else {
                    triplets.add(Arrays.asList(nums[i], nums[j], nums[k]));

                    j ++;
                    k --;

                    while (j < k && nums[j] == nums[j - 1]) j ++;
                    while (j < k && nums[k] == nums[k + 1]) k --;
                }
            }
        }

        return triplets;
    }

    public static void main(String[] args) {
        int[] test1 = {-1, 0, 1, 2, -1, -4};
        System.out.println("Result 1: " + Arrays.toString(threeSum(test1).toArray()));
    }
}
