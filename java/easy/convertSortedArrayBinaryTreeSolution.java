/** Convert Sorted Array to Binary Search Tree
 * Problem link: https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/
 * 
 * Idea:
 *  The main idea is to take the middle element as the root to keep the tree balanced, then recursively build the left subtree from the left half of the array and the right subtree from the right half.
 * 
 * Complexity: O(n)
 */

package easy;

import shared.TreeNode;

public class convertSortedArrayBinaryTreeSolution {
    public static TreeNode sortedArrayToBST(int[] nums) {
        return build(nums, 0, nums.length - 1);
    }

    public static TreeNode build(int[] nums, int left, int right) {
        if (left > right) return null;

        int mid = (left + right) / 2;
        TreeNode root = new TreeNode(nums[mid]);

        root.left = build(nums, left, mid - 1);
        root.right = build(nums, mid + 1, right);

        return root;
    }

    public static void main(String[] args) {
        int[] test1 = {-10, -3, 0, 5, 9};
        System.out.print("Result 1: "); shared.NodeUtils.printTreeNodeInOrder(sortedArrayToBST(test1));
    }    
}
