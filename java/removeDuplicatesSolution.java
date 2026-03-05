/** Remove Duplicates from Sorted Array
 * Problem link: https://leetcode.com/problems/remove-duplicates-from-sorted-array/
 * 
 * Idea:
 *  The idea was simple: I just need to iterate through the array and compare the current item with the one to its left. If they are different, I write the current number at index k and increment k. Otherwise, I do nothing.
 * 
 * Complexity: O(n)
 */

public class removeDuplicatesSolution {
    public static int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        int k = 1;

        for (int i = 1 ; i < nums.length ; i++) {
            if (nums[i - 1] != nums[i]) {
                nums[k] = nums[i];
                k += 1;
            }
        }

        return k;
    }

    public static void main(String[] args) {
        int[] test1 = {1, 1, 2};
        int[] test2 = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};

        System.out.println("Result 1: " + removeDuplicates(test1));
        System.out.println("Result 2: " + removeDuplicates(test2));
    }
}
