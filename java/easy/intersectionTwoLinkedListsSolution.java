/** Intersection of Two Linked Lists
 * Problem link: https://leetcode.com/problems/intersection-of-two-linked-lists/
 * 
 * Idea:
 *  The algorithm uses two pointers to traverse both lists simultaneously. 
 *  When a pointer reaches the end of its list (becomes null), it is redirected to the head of the other list. 
 *  If the two pointers meet at the same node, that node is the intersection point and is returned. 
 *  If there is no intersection, both pointers will eventually reach null at the same time.
 * 
 * Complexity: O(n + m)
 * 
 */

package easy;

import shared.ListNode;

public class intersectionTwoLinkedListsSolution {
    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode tailA = headA;
        ListNode tailB = headB;

        while (tailA != tailB) {
            if (tailA != null) tailA = tailA.next;
            else tailA = headB;

            if (tailB != null) tailB = tailB.next;
            else tailB = headA;
        }

        return tailA;
    }

    public static void main(String[] args) {
        ListNode t1intersection = new ListNode(1, new ListNode(2, new ListNode(3)));
        ListNode t1l1 = new ListNode(1, new ListNode(2, t1intersection));
        ListNode t1l2 = new ListNode(1, new ListNode(2, new ListNode(3, t1intersection)));

        System.out.println("Result 1: " + getIntersectionNode(t1l1, t1l2));

        ListNode t2l1 = new ListNode(2, new ListNode(6, new ListNode(4)));
        ListNode t2l2 = new ListNode(1, new ListNode(5));

        System.out.println("Result 2: " + getIntersectionNode(t2l1, t2l2));
    }
}
