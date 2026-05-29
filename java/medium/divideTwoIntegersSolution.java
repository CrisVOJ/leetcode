/** Divide Two Integers
 * Problem link: https://leetcode.com/problems/divide-two-integers/
 * 
 * Idea:
 *  The approach handles division without arithmetic operators by leveraging 
 *  bitwise manipulation for exponential acceleration. After processing signs 
 *  with a bitwise XOR and converting inputs to 64-bit long integers to prevent 
 *  overflow, it iteratively subtracts the largest possible shifted multiple of 
 *  the divisor from the dividend. Left-shift operations (<<) are used to dynamically 
 *  double the divisor and step counter at each sub-iteration, significantly reducing 
 *  the number of operations.
 * 
 * Complexity: 
 *  Time: O(log n)
 *  Space: O(1)
 */

package medium;

public class divideTwoIntegersSolution {
    public static int divide(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }

        int xor = dividend ^ divisor;
        boolean negative = false;
        if (xor < 0) negative = true;

        long longDividend = Math.abs((long) dividend);
        long longDivisor = Math.abs((long) divisor);

        int count = 0;

        while (longDividend >= longDivisor) {
            long tempDivisor = longDivisor;
            long numTimes = 1;

            while ((tempDivisor << 1) <= longDividend) {
                numTimes = numTimes << 1;
                tempDivisor = tempDivisor << 1;
            } 

            longDividend -= tempDivisor;
            count += numTimes;
        }

        return (int) (negative ? -count : count);
    }

    public static void main(String[] args) {
        System.out.println("Result 1: " + divide(10, 3));
        System.out.println("Result 2: " + divide(60, 5));
    }
}
