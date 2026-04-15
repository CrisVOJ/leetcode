/** Best Time to Buy and Sell Stock
 * Problem link: https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
 * 
 * Idea:
 *  The main idea was iterate array and set lowest price so far, and compute max profit as (current - minPrice);
 * 
 * Complexity: O(n)
 */

package easy;

public class bestTimeBuySellSolution {
    public static int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;

        for (int price : prices) {
            minPrice = Math.min(minPrice, price);
            maxProfit = Math.max(maxProfit, price - minPrice);
        }

        return maxProfit;
    }
    
    public static void main(String[] args) {
        int[] test1 = {7, 1, 5, 3, 6, 4};
        System.out.println("Result 1: " + maxProfit(test1));
        int[] test2 = {7, 6, 4, 3, 1};
        System.out.println("Result 2: " + maxProfit(test2));
        int[] test3 = {1, 2};
        System.out.println("Result 3: " + maxProfit(test3));
        int[] test4 = {2, 4, 1};
        System.out.println("Result 4: " + maxProfit(test4));
    }
}
