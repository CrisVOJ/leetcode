/** Remove Duplicates from Sorted List
 * Problem link: https://leetcode.com/problems/remove-duplicates-from-sorted-list/
 * 
 * Idea:
 *  The main idea is to iterate through the linked list and, whenever the next node has the same value as the current one, skip it by updating the current node’s next pointer.
 * 
 * Complexity: O(n)
 */

package easy;

import shared.ListNode;

public class removeDuplicatesSortedListSolution {
    public static ListNode deleteDuplicates(ListNode head) {
        ListNode current = head;

        while (current != null && current.next != null) {
            if (current.next.val == current.val) {
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }

        return head;
    }

    public static void showListNode(ListNode listNode) {
        while (listNode.next != null) {
            System.out.print(listNode.val + ", ");
            listNode = listNode.next;
        }
        System.out.println(listNode.val);
    }

    public static void main(String[] args) {
        System.out.print("Result 1: "); showListNode(deleteDuplicates(new ListNode(1, new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(3)))))));
    }
}
