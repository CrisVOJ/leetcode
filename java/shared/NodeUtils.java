package shared;

public class NodeUtils {
    public static void printListNode(ListNode head) {
        ListNode current = head;

        while (current.next != null) {
            System.out.print(current.val + ", ");

            current = current.next;
        }

        System.out.println(current.val);
    }
}
