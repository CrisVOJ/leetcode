/** Merge k Sorted Lists
 * Problem link: https://leetcode.com/problems/merge-k-sorted-lists/
 * 
 * Idea:
 *  The approach utilizes a "Divide and Conquer" strategy, operating similarly to a tournament bracket. 
 *  It pairs up the initial lists and merges each pair into a single sorted list. 
 *  By repeating this process, it systematically reduces the total number of lists by half in each iterative step. 
 *  This continues until only one fully sorted list remains, effectively avoiding unnecessary comparisons and achieving optimal scalability.
 * 
 * Complexity: O(N log(k))
 * 
 */

package hard;

import shared.ListNode;

public class mergeKSortedListsSolution {
    public static ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) return null;
        return helper(lists, 0, lists.length - 1);
    }


    public static ListNode helper(ListNode[] lists, int start, int end) {
        if (start > end) return null;
        if (start == end) return lists[start];

        int mid = start + ((end - start) / 2);
        ListNode left = helper(lists, start, mid);
        ListNode right = helper(lists, mid + 1, end);
        return merge(left, right);
    }

    public static ListNode merge(ListNode leftHead, ListNode rightHead) {
        ListNode dummy = new ListNode(-1);
        ListNode tail = dummy;

        while (leftHead != null && rightHead != null) {
            if (leftHead.val < rightHead.val) {
                tail.next = leftHead;
                leftHead = leftHead.next;
            } else {
                tail.next = rightHead;
                rightHead = rightHead.next;
            }
            tail = tail.next;
        }

        tail.next = leftHead != null ? leftHead : rightHead;
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode[] test1 = {new ListNode(1, new ListNode(4, new ListNode(5))), new ListNode(1, new ListNode(3, new ListNode(4))), new ListNode(2, new ListNode(6))};
        System.out.print("Result 1: "); shared.NodeUtils.printListNode(mergeKLists(test1));
    }
}
