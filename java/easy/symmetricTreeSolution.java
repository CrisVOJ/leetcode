/** Symmetric Tree
 * Problem link: https://leetcode.com/problems/symmetric-tree/
 * 
 * Idea:
 *  Main idea was to replicate the Same Tree solution, but in this case compare the left node with the right node in mirror order, and the right node with the left node.
 * 
 * Complexity: O(n)
 */

package easy;

import shared.TreeNode;

public class symmetricTreeSolution {
    public static boolean isSymmetric(TreeNode root) {
        return isMirror(root.left, root.right);
    }

    public static boolean isMirror(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        
        if (p == null || q == null) return false;
        
        return p.val == q.val && isMirror(p.left, q.right) && isMirror(p.right, q.left);
    }

    public static void main(String[] args) {
        System.out.println("Result 1: " + isSymmetric(new TreeNode(1, new TreeNode(2), new TreeNode(2))));
        System.out.println("Result 1: " + isSymmetric(new TreeNode(1, new TreeNode(2, new TreeNode(3), new TreeNode(4)), new TreeNode(2, new TreeNode(4), new TreeNode(3)))));
        System.out.println("Result 1: " + isSymmetric(new TreeNode(1, new TreeNode(2, null, new TreeNode(3)), new TreeNode(2, null, new TreeNode(3)))));
    }
}