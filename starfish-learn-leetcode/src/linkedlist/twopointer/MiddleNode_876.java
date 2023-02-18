package linkedlist.twopointer;

import linkedlist.ListNode;

/**
 * @author Henry
 * @date 2022/1/6
 */
public class MiddleNode_876 {

    public ListNode middle(ListNode head){
        ListNode fast = head;
        ListNode slow = head;

        while(fast !=null && fast.next !=null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }



    public static ListNode middleNode(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.addToEnd(2);
        head.addToEnd(3);
        head.addToEnd(4);
        head.addToEnd(5);
        head.addToEnd(6);
        ListNode.printLinkedList(middleNode(head));
    }

}
