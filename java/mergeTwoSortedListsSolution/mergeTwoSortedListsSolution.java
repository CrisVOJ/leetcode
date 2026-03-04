package mergeTwoSortedListsSolution;

/** Merge Two Sorted Lists
 * Problem link: https://leetcode.com/problems/two-sum/
 * 
 * Idea:
 *  At the start, I had a small idea that consists of comparing the elements of the two lists and adding the smaller one to the result list.
 * 
 * Complexity: O(n + m)
 */

public class mergeTwoSortedListsSolution {
    public static ListNode mergeTwoList(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        }

        if (list2 == null) {
            return list1;
        }

        ListNode result = new ListNode(0);
        ListNode tailAux = result;

        while (list1 != null && list2 != null) {
            if (list1.val > list2.val) {
                tailAux.next = new ListNode(list2.val);
                list2 = list2.next;
            } else {
                tailAux.next = new ListNode(list1.val);
                list1 = list1.next;
            }

            tailAux = tailAux.next;
        }

        if (list1 != null) tailAux.next = list1;
        else tailAux.next = list2;

        return result.next;
    }

    public static void showListNode(ListNode listNode) {
        while (listNode.next != null) {
            System.out.print(listNode.val + ", ");
            listNode = listNode.next;
        }
        System.out.println(listNode.val);
    }

    public static void main(String[] args) {
        ListNode list1 = new ListNode(1, new ListNode(2, new ListNode(4)));
        ListNode list2 = new ListNode(1, new ListNode(3, new ListNode(4)));
        System.out.print("Result: "); showListNode(mergeTwoList(list1, list2));
    }
}
