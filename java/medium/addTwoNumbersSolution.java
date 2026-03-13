/** Add Two Numbers Solution
 * Problem link: https://leetcode.com/problems/add-two-numbers/
 * 
 * Idea:
 *  My idea was to iterate through both linked lists simultaneously, adding the value of each node. If one list is longer than the other, I continue with the remaining nodes of that list. I also keep track of the carry from each sum to make sure it is included in the next operation.
 * 
 * Complexity: O(max(n, m))
 */

package medium;

import mergeTwoSortedListsSolution.ListNode;

public class addTwoNumbersSolution {
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(0);
        ListNode auxTail = result;

        int residualAux = 0;

        while (l1 != null || l2 != null || residualAux != 0) {
            int sum = residualAux;

            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }

            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }

            residualAux = sum / 10;
            auxTail.next = new ListNode(sum % 10);
            auxTail = auxTail.next;
        }

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
        ListNode test1List1 = new ListNode(2, new ListNode(4, new ListNode(3)));
        ListNode test1List2 = new ListNode(5, new ListNode(6, new ListNode(4)));
        System.out.print("Result 1: "); showListNode(addTwoNumbers(test1List1, test1List2));

        ListNode test2List1 = new ListNode(0);
        ListNode test2List2 = new ListNode(0);
        System.out.print("Result 2: "); showListNode(addTwoNumbers(test2List1, test2List2));

        ListNode test3List1 = new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9)))))));
        ListNode test3List2 = new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9))));
        System.out.print("Result 3: "); showListNode(addTwoNumbers(test3List1, test3List2));
    }
}
