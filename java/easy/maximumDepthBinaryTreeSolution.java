/** Maximum Depth of Binary Tree
 * Problem link: https://leetcode.com/problems/maximum-depth-of-binary-tree/
 * 
 * Idea:
 *  The main idea was to traverse the left and right subtrees recursively to determine the depth of the binary tree. For each node, the function calculates the depth of both sides and returns 1 plus the greater of the two.
 * 
 * Complexity: O(n)
 */

package easy;

import shared.TreeNode;

public class maximumDepthBinaryTreeSolution {
    public static int maxDepth(TreeNode root) {
        if (root == null) return 0;

        int leftDepth = maxDepth(root.left);

        int rightDepth = maxDepth(root.right);

        return 1 + Math.max(leftDepth, rightDepth);
    }

    public static void main(String[] args) {
        System.out.println("Result 1: " + maxDepth(new TreeNode(3, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7)))));
        System.out.println("Result 2: " + maxDepth(new TreeNode(1, null, new TreeNode(2))));
    }
}