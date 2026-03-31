/** Same Tree
 * Problem link: https://leetcode.com/problems/same-tree/
 * 
 * Idea:
 *  Main idea was to traverse both trees at the same time and return false as soon as a difference is found. If no difference is found, then both trees are equal.
 * 
 * Complexity: O(n)
 */

package easy;

import shared.TreeNode;

public class sameTreeSolution {
    public static boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        
        if (p == null || q == null) return false;
        
        return p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

    public static void main(String[] args) {
        System.out.println("Result 1: " + isSameTree(new TreeNode(1, new TreeNode(2), new TreeNode(3)), new TreeNode(1, new TreeNode(2), new TreeNode(3))));
        System.out.println("Result 2: " + isSameTree(new TreeNode(1, new TreeNode(2), null), new TreeNode(1, null, new TreeNode(2))));
        System.out.println("Result 3: " + isSameTree(new TreeNode(1, new TreeNode(2), new TreeNode(1)), new TreeNode(1, new TreeNode(1), new TreeNode(2))));
    }
}
