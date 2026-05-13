/** 4Sum
 * Problem link: https://leetcode.com/problems/4sum/
 * 
 * Idea:
 *  The approach extends the 3Sum logic by nesting an additional loop to fix a second pointer, 
 *  reducing the problem to a Two-Sum variation resolved with the Two-Pointer technique on a sorted array.
 * 
 * Complexity: O(n^3)
 * 
 */

package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class fourSumSolution {
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        int n = nums.length;

        for (int i = 0 ; i < n - 3 ; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            if ((long) nums[i] + nums[i + 1] + nums[i + 2] + nums[i + 3] > target) break;
            if ((long) nums[i] + nums[n - 3] + nums[n - 2] + nums[n - 1] < target) continue;

            for (int j = i + 1 ; j < n - 2 ; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) continue;

                if ((long) nums[i] + nums[j] + nums[j + 1] + nums[j + 2] > target) break;
                if ((long) nums[i] + nums[j] + nums[n - 2] + nums[n - 1] < target) continue;

                int k = j + 1, l = n - 1;

                while(k < l) {
                    int sum = nums[i] + nums[j] + nums[k] + nums[l];
                    if (sum > target) {
                        l --;
                    } else if (sum < target) {
                        k ++;
                    } else {
                        result.add(Arrays.asList(nums[i], nums[j], nums[k], nums[l]));
                        
                        while (k < l && nums[k] == nums[k + 1]) k++;
                        while (k < l && nums[l] == nums[l - 1]) l--;
                        k++;
                        l--;
                    }
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] test1 = {1, 0, -1, 0, -2, 2};
        System.out.println("Result 1: " + fourSum(test1, 0));
    }
}
