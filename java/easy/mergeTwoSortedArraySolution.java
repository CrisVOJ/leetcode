/** Longest Palindromic Substring
 * Problem link: https://leetcode.com/problems/merge-sorted-array/
 * 
 * Idea:
 *  Since the arrays are sorted, the idea is to start from the end of each array. This works because nums1 has extra space at the end, allowing us to place the largest elements without overwriting existing values.
 * 
 * Complexity: O(n + m)
 */

package easy;

import java.util.Arrays;

public class mergeTwoSortedArraySolution {
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1;
        int j = n - 1;
        int k = nums1.length - 1;

        while (j >= 0) {
            if (i >= 0 && nums1[i] > nums2[j]) {
                nums1[k] = nums1[i];
                i --;
            } else {
                nums1[k] = nums2[j];
                j --;
            }

            k --;
        }
    }

    public static void main(String[] args) {
        int [] nums1T1 = {1, 2, 3, 0, 0, 0};
        int [] nums2T1 = {2, 5, 6};
        System.out.print("Result 1: " ); 
        merge(nums1T1, 3, nums2T1, 3);
        System.out.println(Arrays.toString(nums1T1));

        int [] nums1T2 = {1};
        int [] nums2T2 = {0};
        System.out.print("Result 2: " ); 
        merge(nums1T2, 1, nums2T2, 0);
        System.out.println(Arrays.toString(nums1T2));

        int [] nums1T3 = {0};
        int [] nums2T3 = {1};
        System.out.print("Result 3: " ); 
        merge(nums1T3, 0, nums2T3, 1);
        System.out.println(Arrays.toString(nums1T3));
    }
}