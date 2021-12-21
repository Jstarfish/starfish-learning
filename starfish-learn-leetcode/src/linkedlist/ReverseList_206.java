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

    /**
     * 迭代
     * 在遍历链表时，将当前节点的 next 指针改为指向前一个节点。
     * 由于节点没有引用其前一个节点，因此必须事先存储其前一个节点。在更改引用之前，还需要存储后一个节点。
     * 最后返回新的头引用。
     */
    public ListNode reverseList(ListNode head){
        if(head == null || head.next == null){
            return null;
        }
        ListNode pre = null;
        ListNode cur = head;
        while(cur != null){
            ListNode tmp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = tmp;
        }
        return pre;

    }


    public static void main(String[] args) {
        ReverseList_206 obj = new ReverseList_206();
        ListNode head = obj.initLinkedList(9);
        ListNode head1 = obj.initLinkedList(8);
        System.out.println(head1==head);
        obj.printLinkedList(head);

        ListNode result = obj.reverseList(head);
        System.out.println("");

        obj.printLinkedList(result);


    }


    /**
     * 初始化链表
     **/
    private ListNode initLinkedList(int num) {
        ListNode head = new ListNode(1);
        ListNode cur = head;
        for (int i = 2; i < num; i++) {
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


