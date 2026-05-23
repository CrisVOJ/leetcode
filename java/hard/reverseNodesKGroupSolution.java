/** Reverse Nodes in k-Group
 * Problem link: https://leetcode.com/problems/reverse-nodes-in-k-group/
 * 
 * Idea:
 *  The approach utilizes an iterative traversal to physically reverse sublists 
 *  by reassigning their pointers. It processes the linked list in strict groups 
 *  of 'k' nodes, using a dummy node to anchor the reconnected segments. This 
 *  ensures no data values are overwritten.
 * 
 * Complexity: O(n)
 * 
 */

package hard;

import shared.ListNode;

public class reverseNodesKGroupSolution {
    public static ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0, head);
        ListNode prev = dummy;
        ListNode end = prev.next;

        ListNode start, current, next, temp;

        int count;

        while (end != null) {
            start = prev;
            current = prev.next;

            count = 0;
            while (count < k && end != null) {
                end = end.next;
                count ++;
            }

            if (count < k && end == null) break;

            while (current != end) {
                next = current.next;

                current.next = prev;

                prev = current;
                current = next;
            }

            temp = start.next;
            
            temp.next = end;
            start.next = prev;

            prev = temp;
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode test1 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5, new ListNode(6))))));
        System.out.print("Result 1: "); shared.NodeUtils.printListNode(reverseKGroup(test1, 4));
        
        ListNode test2 = new ListNode(1);
        System.out.print("Result 2: "); shared.NodeUtils.printListNode(reverseKGroup(test2, 1));
    }
}
