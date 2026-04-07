/** Balanced Binary Tree
 * Problem link: https://leetcode.com/problems/balanced-binary-tree/
 * 
 * Idea:
 *  The main idea was to compare the heights of the left and right subtrees at each node. If the height difference is greater than one, the tree is not balanced, so the function returns -1.
 * 
 * Complexity: O(n)
 */

package easy;

import shared.TreeNode;

public class balancedBinaryTreeSolution {
    public static boolean isBalanced(TreeNode root) {
        return check(root) != -1;
    }

    public static int check(TreeNode node) {
        if (node == null) return 0;

        int leftHeight = check(node.left);
        int rightHeight = check(node.right);

        if (leftHeight == -1 || rightHeight == -1) return -1;

        if (Math.abs(leftHeight - rightHeight) > 1) return -1;

        return 1 + Math.max(leftHeight, rightHeight);
    }

    public static void main(String[] args) {
        System.out.println("Result 1: " + isBalanced(new TreeNode(3, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7)))));
        System.out.println("Result 2: " + isBalanced(new TreeNode(1, new TreeNode(2, new TreeNode(3, new TreeNode(4), new TreeNode(4)), new TreeNode(3)), new TreeNode(2))));
    }
}
