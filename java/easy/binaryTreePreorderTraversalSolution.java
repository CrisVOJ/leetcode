/** Binary Tree Preorder Traversal
 * Problem link: https://leetcode.com/problems/binary-tree-preorder-traversal/
 * 
 * Idea:
 *  The algorithm uses an iterative approach with a stack to simulate recursion. We traverse the tree by moving to the left child, adding each node's value to the result list and pushing the node onto the stack. 
 *  Once we reach a null child, we pop the last visited node from the stack and move to its right child to continue the process.
 * 
 * Complexity: O(n)
 * 
 */

package easy;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import shared.TreeNode;

public class binaryTreePreorderTraversalSolution {
    public static List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> preorder = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;

        while (current != null || !stack.isEmpty()) {
            while (current != null) {
                preorder.add(current.val);
                stack.push(current);
                current = current.left;
            }

            current = stack.pop();

            current = current.right;
        }

        return preorder;
    }

    public static void main(String[] args) {
        System.out.println("Restul 1: " + preorderTraversal(new TreeNode(1, null, new TreeNode(2, new TreeNode(3), null))));
        System.out.println("Restul 2: " + preorderTraversal(new TreeNode(1, new TreeNode(2, new TreeNode(4), new TreeNode(5, new TreeNode(6), new TreeNode(7))), new TreeNode(3, null, new TreeNode(8, new TreeNode(9), null)))));
    }
}
