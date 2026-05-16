/** Remove Nth Node From End of List
 * Problem link: https://leetcode.com/problems/remove-nth-node-from-end-of-list/
 * 
 * Idea:
 *  The approach utilizes the Two-Pointer technique (Fast and Slow) alongside a dummy node to 
 *  eliminate the target element in a single pass. By advancing the fast pointer to create a 
 *  gap of 'n' nodes, both pointers traverse simultaneously until the end, positioning the slow 
 *  pointer exactly before the node to be removed.
 * 
 * Complexity: O(n)
 * 
 */

package medium;

import shared.ListNode;

public class removeNthNodeFromEndOfListSolution {
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0, head);
        ListNode fast = dummy;
        ListNode slow = dummy;

        int count = 0;

        while (fast.next != null) {
            count ++;
            fast = fast.next;
            if (count > n) {
                slow = slow.next;
            }
        }
        
        if (slow.next != null) {
            slow.next = slow.next.next;
        } else {
            slow.next = null;
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        System.out.print("Result 1: "); shared.NodeUtils.printListNode(removeNthFromEnd(new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5))))), 2));
        System.out.print("Result 2: "); shared.NodeUtils.printListNode(removeNthFromEnd(new ListNode(1), 1));
        System.out.print("Result 3: "); shared.NodeUtils.printListNode(removeNthFromEnd(new ListNode(1, new ListNode(2)), 1));
    }
}
