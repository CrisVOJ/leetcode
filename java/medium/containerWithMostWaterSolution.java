/** Container With Most Water
 * Problem link: https://leetcode.com/problems/container-with-most-water/
 * 
 * Idea:
 *  The core idea is to use two pointers starting at both ends of the array.
 *  At each step, we calculate the current area and update the maximum if needed.
 *  Then, we move the pointer pointing to the shorter line inward,
 *  because only by moving the shorter line do we have a chance to find a taller one
 *  that could produce a larger area (even though the width decreases).
 * 
 * Complexity: O(n)
 * 
 */

package medium;

public class containerWithMostWaterSolution {
    public static int maxArea(int[] height) {
        int maxArea = 0;
        int left = 0;
        int right = height.length - 1;

        while (left < right) {
            int leftHeight = height[left];
            int rightHeight = height[right];

            maxArea = Math.max((Math.min(leftHeight, rightHeight) * (right - left)), maxArea);
            
            if (leftHeight < rightHeight) left ++; 
            else right --;
        }

        return maxArea;
    }

    public static void main(String[] args) {
        int[] test1 = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println("Result 1: " + maxArea(test1));
        int[] test2 = {1,8,100,2,100,4,8,3,7};
        System.out.println("Result 2: " + maxArea(test2));
    }
}
