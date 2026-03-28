/** Climbinh Stairs
 * Problem link: https://leetcode.com/problems/climbing-stairs/
 * 
 * Idea:
 *  The main idea is to sum the two previous results to obtain the current result, following the Fibonacci pattern.
 * 
 * Complexity: O(n)
 */

package easy;

public class climbingStairsSolution {
    public static int climbStairs(int n) {
        if (n <= 2) return n;

        int a = 1;
        int b = 2;

        for (int i = 3 ; i <= n ; i++) {
            int aux = a + b;
            a = b;
            b = aux;
        }
        
        return b;
    }

    public static void main(String[] args) {
        System.out.println("Result 1: " + climbStairs(1));
        System.out.println("Result 2: " + climbStairs(2));
        System.out.println("Result 3: " + climbStairs(3));
        System.out.println("Result 4: " + climbStairs(4));
        System.out.println("Result 5: " + climbStairs(5));
        System.out.println("Result 6: " + climbStairs(45));
    }
}
