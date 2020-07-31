package linkedlist;

/**
 * 反转一个单链表。
 * <p>
 * 示例:
 * <p>
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 */
public class ReverseList_206 {

    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode prev = null;
        ListNode next = null;
        while (head.next != null) {
            next = head.next;   //保存下一个节点
            head.next = prev;   //重置next
            prev = head;    //保存当前节点
            head = next;
        }
        head.next = prev;
        return head;

//        ListNode prev = null;
//        ListNode curr = head;
//        while (curr != null) {
//            ListNode nextTemp = curr.next;  //保存下一个节点
//            curr.next = prev;  //重置next
//            prev = curr; //保存当前节点
//            curr = nextTemp;
//        }
//        return prev;
    }

    public static void main(String[] args) {
        ReverseList_206 obj = new ReverseList_206();
        ListNode head = obj.initLinkedList(9);
        obj.printLinkedList(head);

        ListNode result = obj.reverseList(head);
        System.out.println("");

        obj.printLinkedList(result);


    }


    /**
     * 初始化链表
     **/
    private ListNode initLinkedList(int num) {
        ListNode head = new ListNode(0);
        ListNode cur = head;
        for (int i = 1; i < num; i++) {
            cur.next = new ListNode(i);
            cur = cur.next;
        }
        return head;
    }

    /**
     * 打印链表
     **/
    private void printLinkedList(ListNode head) {
        ListNode node = head;
        while (node != null) {
            System.out.print(node.val);
            node = node.next;
        }
    }

}


