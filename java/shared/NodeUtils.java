package shared;

import java.util.LinkedList;
import java.util.Queue;

public class NodeUtils {
    public static void printListNode(ListNode head) {
        ListNode current = head;

        while (current.next != null) {
            System.out.print(current.val + ", ");

            current = current.next;
        }

        System.out.println(current.val);
    }

    public static void printTreeNodePreOrder(TreeNode root) {
        if (root == null) return;

        System.out.print(root.val + " ");
        printTreeNodePreOrder(root.left);
        printTreeNodePreOrder(root.right);
    }

    public static void printTreeNodeInOrder(TreeNode root) {
        if (root == null) return;

        printTreeNodeInOrder(root.left);
        System.out.print(root.val + " ");
        printTreeNodeInOrder(root.right);
    }

    public static void printTreeNodePostOrder(TreeNode root) {
        if (root == null) return;

        printTreeNodePostOrder(root.left);
        printTreeNodePostOrder(root.right);
        System.out.print(root.val + " ");
    }

    public static void printTreeNodeLevelOrder(TreeNode root) {
        if (root == null) return;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();
            System.out.print(current.val + " ");

            if (current.left != null) queue.offer(current.left);
            if (current.right != null) queue.offer(current.right);
        }
    }
}
