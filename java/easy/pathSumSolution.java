/** Path Sum
 * Problem link: https://leetcode.com/problems/path-sum/
 * 
 * Idea:
 *  The main idea is to explore both subtrees iteratively (using BFS) and accumulate the node values. If a leaf node is reached and the accumulated sum equals the target sum, the function will return true.
 * 
 * Complexity: O(n)
 */

package easy;

import java.util.LinkedList;
import java.util.Queue;

import shared.TreeNode;

public class pathSumSolution {
    public static boolean hasPathSum1(TreeNode root, int targetSum) {
        if (root == null) return false;

        if (root.left == null && root.right == null) return root.val == targetSum;

        int newTarget = targetSum - root.val;

        return hasPathSum1(root.left, newTarget) || hasPathSum1(root.right, newTarget);
    }

    public static boolean hasPathSum2(TreeNode root, int targetSum) {
        if (root == null) return false;

        class Pair {
            TreeNode node;
            int sum;

            Pair(TreeNode node, int sum) {
                this.node = node;
                this.sum = sum;
            }
        }

        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(root, root.val));
        
        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0 ; i < size ; i++) {
                Pair current = queue.poll();
                TreeNode node = current.node;
                int currentSum = current.sum;

                if (node.left == null && node.right == null && currentSum == targetSum) {
                    return true;
                }

                if (node.left != null) queue.add(new Pair(node.left, currentSum + node.left.val));
                if (node.right != null) queue.add(new Pair(node.right, currentSum + node.right.val));
            }
        }

        return false;
    }
    
    
    public static void main(String[] args) {
        System.out.println("Result 1 v1: " + hasPathSum1(new TreeNode(5, new TreeNode(4, new TreeNode(11, new TreeNode(7), new TreeNode(2)), null), new TreeNode(8, new TreeNode(13), new TreeNode(4, null, new TreeNode(1)))), 22));
        System.out.println("Result 2 v1: " + hasPathSum1(new TreeNode(1, new TreeNode(2), new TreeNode(3)), 5));
        
        System.out.println("Result 1 v2: " + hasPathSum2(new TreeNode(5, new TreeNode(4, new TreeNode(11, new TreeNode(7), new TreeNode(2)), null), new TreeNode(8, new TreeNode(13), new TreeNode(4, null, new TreeNode(1)))), 22));
        System.out.println("Result 2 v2: " + hasPathSum2(new TreeNode(1, new TreeNode(2), new TreeNode(3)), 5));
    }
}
