/** SQRT(X)
 * Problem link: https://leetcode.com/problems/sqrtx/
 * 
 * Idea:
 *  The idea was to use binary search to find the square root of x.
 * 
 * Complexity: O(log n)
 */

package easy;

public class sqrtSolution {
    public static int mySqrt(int x) {
        if (x < 2) return x;

        int left = 1, right = x / 2, res = 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (mid <= x / mid) {
                res = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println("Result 1: " + mySqrt(4));
        System.out.println("Result 2: " + mySqrt(8));
    }
}
