/** Binary Tree Postorder Traversal
 * Problem link: https://leetcode.com/problems/binary-tree-postorder-traversal/
 * 
 * Idea:
 *  The algorithm uses an iterative approach with a stack to simulate recursion. We traverse the tree by moving to the left child, adding each node's value to the result list and pushing the node onto the stack. 
 *  Once we reach a leaf node we add its value to the result list, and pop the last visited node from the stack and move to its right child to continue the process.
 * 
 * Complexity: O(n)
 * 
 */

package easy;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import shared.TreeNode;

public class binaryTreePostorderTraversalSolution {
    public static List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> postorder = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;
        TreeNode lastVisited = null;

        while (current != null || !stack.isEmpty()) {
            while (current != null) {
                stack.push(current);
                current = current.left;
            }

            current = stack.peek();

            if (current.right == null || current.right == lastVisited) {
                postorder.add(current.val);
                lastVisited = stack.pop();
                current = null;
            } else {
                current = current.right;
            }
        }

        return postorder;
    }

    public static void main(String[] args) {
        System.out.println("Result 1: " + postorderTraversal(new TreeNode(1, null, new TreeNode(2, new TreeNode(3), null))));
        System.out.println("Restul 2: " + postorderTraversal(new TreeNode(1, new TreeNode(2, new TreeNode(4), new TreeNode(5, new TreeNode(6), new TreeNode(7))), new TreeNode(3, null, new TreeNode(8, new TreeNode(9), null)))));
    }
}
