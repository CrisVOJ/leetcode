/** Linked List Cycle
 * Problem link: https://leetcode.com/problems/linked-list-cycle/
 * 
 * Idea:
 *  Create two pointers: one that iterates through the nodes one by one (the slow pointer) and another that iterates through the nodes two by two (the fast pointer). If the fast pointer finds the slow pointer, return true. If the fast pointer is null, return false.
 * 
 * Complexity: O(n)
 * 
 */

package easy;

import shared.ListNode;

public class linkedListCycleSolution {
    public static boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) return false;

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) return true;
        }

        return false;
    }

    public static void main (String[] args) {
        ListNode t1n1 = new ListNode(3);
        ListNode t1n2 = new ListNode(2);
        ListNode t1n3 = new ListNode(0);
        ListNode t1n4 = new ListNode(-4);

        t1n1.next = t1n2;
        t1n2.next = t1n3;
        t1n3.next = t1n4;
        t1n4.next = t1n2;

        System.out.println("Result 1: " + hasCycle(t1n1));

        ListNode t2n1 = new ListNode(1);
        ListNode t2n2 = new ListNode(2);

        t2n1.next = t2n2;
        t2n2.next = t2n1;

        System.out.println("Result 2: " + hasCycle(t2n1));
    }
}
