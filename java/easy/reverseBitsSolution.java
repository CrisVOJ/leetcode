/** Reverse Bits
 * Problem link: https://leetcode.com/problems/reverse-bits/
 * 
 * Idea:
 *  The algorithm reverses the binary representation of a 32-bit integer using a bit-by-bit approach.
 *  In each of the 32 iterations, it shifts the 'result' to the left to make room for a new bit,
 *  extracts the least significant bit (LSB) from 'n' using a mask (n & 1), and appends it to 'result'.
 *  Finally, it shifts 'n' to the right to process the next bit.
 * 
 * Complexity: O(1)
 * 
 */

package easy;

public class reverseBitsSolution {
    public static int reverseBits(int n) {
        int result = 0;

        for (int i = 0 ; i < 32 ; i++) {
            result <<= 1;
            result |= (n & 1);
            n >>= 1;
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println("Result 1: " + reverseBits(43261596));
        System.out.println("Result 2: " + reverseBits(2147483644));
    }
}
