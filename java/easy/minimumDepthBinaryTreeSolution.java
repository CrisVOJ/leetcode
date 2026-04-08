/** Minimum Depth of Binary Tree
 * Problem link: https://leetcode.com/problems/minimum-depth-of-binary-tree/
 * 
 * Idea:
 *  The main idea is to recursively explore both subtrees until reaching leaf nodes, and then use those depths to determine the minimum valid depth of the tree.
 * 
 * Complexity: O(n)
 */

package easy;

import java.util.LinkedList;
import java.util.Queue;

import shared.TreeNode;

public class minimumDepthBinaryTreeSolution {
    public static int minDepth1(TreeNode root) {
        if (root == null) return 0;

        int rightHeight = minDepth1(root.right);
        int leftHeight = minDepth1(root.left);

        if (rightHeight == 0 || leftHeight == 0) {
            return 1 + Math.max(rightHeight, leftHeight);
        }

        return 1 + Math.min(rightHeight, leftHeight);
    }

    public static int minDepth2(TreeNode root) {
        if (root == null) return 0;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int depth = 1;

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0 ; i < size ; i++) {
                TreeNode node = queue.poll();

                if (node.left == null && node.right == null) {
                    return depth;
                }

                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }

            depth++;
        }

        return depth;
    }

    public static void main(String[] args) {
        System.out.println("Result 1 v1: " + minDepth1(new TreeNode(3, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7)))));
        System.out.println("Restul 2 v1: " + minDepth1(new TreeNode(2, null, new TreeNode(3, null, new TreeNode(4, null, new TreeNode(5, null, new TreeNode(6)))))));
        System.out.println("Result 1 v2: " + minDepth2(new TreeNode(3, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7)))));
        System.out.println("Restul 2 v2: " + minDepth2(new TreeNode(2, null, new TreeNode(3, null, new TreeNode(4, null, new TreeNode(5, null, new TreeNode(6)))))));
    }
}
