package linkedlist.twopointer;

import linkedlist.ListNode;

/**
 * 给定一个链表，删除链表的倒数第n个节点，并且返回链表的头结点。
 *
 * 示例：
 *
 * 给定一个链表: 1->2->3->4->5, 和 n = 2.
 *
 * 当删除了倒数第二个节点后，链表变为 1->2->3->5.
 *
 */
public class RemoveNthFromEnd_19 {

    //计算链表长度
    public ListNode removeNthFromEnd_1(ListNode head, int n) {
        ListNode pre = new ListNode(0, head);
        int length = 0;
        while (head != null) {
            ++length;
            head = head.next;
        }
        ListNode cur = pre;
        //遍历到需要删除的位置的前一个，比如1，2，3，4，5 遍历到第 < 4 就可以了,因为有哑结点，所以从下标1开始就可以
        for (int i = 1; i < length - n + 1; i++) {
            cur = cur.next;
        }
        // 删除节点，返回哑结点后的结果即可
        cur.next = cur.next.next;
        return pre.next;
    }


    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.addToEnd(2);
        head.addToEnd(3);
        head.addToEnd(4);
        head.addToEnd(5);
        RemoveNthFromEnd_19 obj = new RemoveNthFromEnd_19();
        ListNode.printLinkedList(obj.removeNthFromEnd_1(head,2));
        //ListNode.printLinkedList(obj.removeNthFromEnd(head,2));


    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0, head);
        ListNode first = head;
        ListNode second = dummy;

        //让 first 指针先移动 n 步
        for (int i = 0; i < n; ++i) {
            first = first.next;
        }
        while (first != null) {
            first = first.next;
            second = second.next;
        }
        second.next = second.next.next;
        return dummy.next;
    }



}
