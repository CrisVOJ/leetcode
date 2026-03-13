package easy;
/** Search Insert Position
 * Problem link: https://leetcode.com/problems/search-insert-position/
 * 
 * Idea:
 *  The first idea that came to my mind was to use binary search to find the position of the target in the array, or determine the index where it should be inserted if it is not present.
 * 
 * Complexity: O(log n)
 */
public class searchInsertPositionSolution {
    public static int searchInsert(int[] nums, int target) {
        if (target < nums[0]) return 0;
        if (target > nums[nums.length - 1]) return nums.length;

        int start = 0;
        int end = nums.length - 1;
        
        while (true) {
            int middle = Math.divideExact((start + end), 2);

            if (nums[middle] == target) return middle;

            if (nums[middle] < target) {
                if (nums[middle + 1] > target) return middle + 1;
                start = middle + 1;
            } else {
                if (nums[middle - 1] < target) return middle;
                end = middle - 1;
            }
        }
    }
    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 6};
        System.out.println("Result 1: " + searchInsert(nums, 5));
        System.out.println("Result 2: " + searchInsert(nums, 2));
        System.out.println("Result 3: " + searchInsert(nums, 7));
    }
}
