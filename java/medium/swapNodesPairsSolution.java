/** Swap Nodes in Pairs
 * Problem link: https://leetcode.com/problems/swap-nodes-in-pairs/
 * 
 * Idea:
 *  The approach utilizes an iterative traversal to physically swap adjacent 
 *  nodes by reassigning their pointers. It processes the list in pairs, ensuring 
 *  no data values are overwritten, while maintaining a constant space complexity.
 * 
 * Complexity: O(n)
 * 
 */

package medium;

import shared.ListNode;

public class swapNodesPairsSolution {
    public static ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(-1, head);

        ListNode prev = dummy;

        while (prev.next != null && prev.next.next != null) {
            ListNode first = prev.next;
            ListNode second = prev.next.next;

            prev.next = second;
            first.next = second.next;
            second.next = first;

            prev = first;
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode test1 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4))));
        System.out.print("Result 1: "); shared.NodeUtils.printListNode(swapPairs(test1));

        ListNode test2 = new ListNode();
        System.out.print("Result 1: "); shared.NodeUtils.printListNode(swapPairs(test2));

        ListNode test3 = new ListNode(1);
        System.out.print("Result 1: "); shared.NodeUtils.printListNode(swapPairs(test3));

        ListNode test4 = new ListNode(1, new ListNode(2, new ListNode(3)));
        System.out.print("Result 1: "); shared.NodeUtils.printListNode(swapPairs(test4));
    }
}
