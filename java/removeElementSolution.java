/** Remove Element
 * Problem link: https://leetcode.com/problems/remove-element/
 * 
 * Idea:
 *  The idea is to iterate through the array until I find val. When I find it, I iterate through the rest of the array starting from that index and replace it with another different value. If I do not find another different value, I simply return the result.
 * 
 * Complexity: O(n^2)
 */

public class removeElementSolution {
    public static int removeElement(int[] nums, int val) {
        int k = 0;

        for (int i = 0 ; i < nums.length ; i++) {
            if (nums[i] == val) {
                for (int j = (i + 1) ; j < nums.length ; j++) {
                    if (nums[j] != val) {
                        int aux = nums[i];
                        nums[i] = nums[j];
                        nums[j] = aux;
                        break;
                    }

                    if (j == (nums.length - 1)) {
                        return k;
                    }
                }
            }

            if (nums[i] != val) {
                k++;
            }
        }

        return k;
    }

    public static void main(String[] args) {
        int[] test1 = {3, 2, 2, 3};
        int[] test2 = {0, 1, 2, 2, 3, 0, 4, 2};

        System.out.println("Result 1: " + removeElement(test1, 3));
        System.out.println("Result 1: " + removeElement(test2, 2));
    }
}
