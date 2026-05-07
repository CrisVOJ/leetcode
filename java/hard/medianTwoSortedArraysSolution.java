/** Median of Two Sorted Arrays
 * Problem link: https://leetcode.com/problems/median-of-two-sorted-arrays/
 * 
 * Idea:
 *  The algorithm finds the median of two sorted arrays by performing a binary search on the smaller array.
 *  It partitions both arrays such that the left half contains the same number of elements as the right half,
 *  and all elements in the left half are less than or equal to all elements in the right half.
 * 
 * Complexity: O(log(min(n, m)))
 * 
 */

package hard;

public class medianTwoSortedArraysSolution {
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int totalLength = nums1.length + nums2.length;
        int medianIndex = totalLength / 2;

        int i = 0, j = 0, count = 0;
        int current = 0, previous = 0;

        while (count <= medianIndex) {
            previous = current;

            if (i < nums1.length && (j >= nums2.length || nums1[i] < nums2[j])) {
                current = nums1[i];
                i++;
            } else {
                current = nums2[j];
                j++;
            }

            count++;
        }

        if (totalLength % 2 == 0) {
            return (previous + current) / 2.0;
        } else {
            return current;
        }
    }

    public static void main(String[] args) {
        int[] array1test1 = {1, 3};
        int[] array2test1 = {2};
        System.out.println("Result 1: " + findMedianSortedArrays(array1test1, array2test1));
    }
}
