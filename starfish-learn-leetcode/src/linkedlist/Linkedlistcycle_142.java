package linkedlist;

/**
 * 给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
 *
 * 如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。
 * 为了表示给定链表中的环，评测系统内部使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。
 * 如果 pos 是 -1，则在该链表中没有环。注意：pos 不作为参数进行传递，仅仅是为了标识链表的实际情况。
 *
 * 不允许修改 链表。
 */
public class Linkedlistcycle_142 {

    public static ListNode hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        // 龟兔起跑
        ListNode fast = head;
        ListNode slow = head;

        //相当于判断有没有环
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            //相交的话，退出循环
            if (slow == fast) {
                break;
            }
        }
        // 快指针走到头的话，说明没环，这个不能遗漏
        if(fast == null || fast.next == null){
            return null;
        }

        slow = head;
        while(slow != fast){
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }

    public static ListNode detectCycle(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode slow = head, fast = head;
        while (fast != null) {
            slow = slow.next;
            if (fast.next != null) {
                fast = fast.next.next;
            } else {
                return null;
            }
            if (fast == slow) {
                ListNode ptr = head;
                while (ptr != slow) {
                    ptr = ptr.next;
                    slow = slow.next;
                }
                return ptr;
            }
        }
        return null;
    }


    public static void main(String[] args) {
        ListNode head = new ListNode(3);
        head.next = new ListNode(2);
        head.next.next = new ListNode(0);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = head.next;
        ListNode.printLinkedList(detectCycle(head));
    }

}
