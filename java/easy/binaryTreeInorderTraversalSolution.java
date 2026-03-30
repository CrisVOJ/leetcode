/** Binary Tree Inorder Traversal
 * Problem link: https://leetcode.com/problems/binary-tree-inorder-traversal/
 * 
 * Idea:
 *  The main idea is to use a stack to simulate the inorder traversal iteratively. First, move as far left as possible while pushing nodes onto the stack. When reaching null, pop the top node, add its value to the result, and then move to its right child.
 * 
 * Complexity: O(n)
 */

package easy;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import shared.TreeNode;

public class binaryTreeInorderTraversalSolution {
    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;
        
        while (current != null || !stack.isEmpty()) {
            while (current != null) {
                stack.push(current);
                current = current.left;
            }

            current = stack.pop();
            result.add(current.val);

            current = current.right;
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println("Result 1: " + inorderTraversal(new TreeNode(1, null, new TreeNode(2, new TreeNode(3), null))));
    }
}
