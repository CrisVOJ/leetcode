/** 3Sum Closest
 * Problem link: https://leetcode.com/problems/3sum-closest/
 * 
 * Idea:
 *  Same solution of 3Sum to find triplets is enough to solve this problem, 
 *  but instead of adding the triplet to the result list, 
 *  we will check if the sum of the triplet is closer to the target.
 * 
 * Complexity: O(n^2)
 * 
 */

package medium;

import java.util.Arrays;

public class threeSumClosestSolution {
    public static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int closestSum = nums[0] + nums[1] + nums[2];

        for (int i = 0 ; i < nums.length - 2 ; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            int j = i + 1, k = nums.length - 1;

            while (j < k) {
                int currentSum = nums[i] + nums[j] + nums[k];

                if (Math.abs(target - currentSum) < Math.abs(target - closestSum)) {
                    closestSum = currentSum;
                }

                if (currentSum < target) j ++;
                else if (currentSum > target) k--;
                else return currentSum;
            }
        }

        return closestSum;
    }

    public static void main(String[] args) {
        int[] test1 = {-1, 2, 1, -4};
        System.out.println("Result 1: " + threeSumClosest(test1, 1));
        int[] test2 = {0, 0, 0};
        System.out.println("Result 2: " + threeSumClosest(test2, 1));
        int[] test3 = {7, 8, 9};
        System.out.println("Result 3: " + threeSumClosest(test3, -1));
    }
}
