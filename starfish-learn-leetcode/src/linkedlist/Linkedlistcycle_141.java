package linkedlist;

/**
 * 给定一个链表，判断链表中是否有环。
 * <p>
 * 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。
 */
public class Linkedlistcycle_141 {

    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        // 龟兔起跑
        ListNode fast = head;
        ListNode slow = head;

        while (fast != null && fast.next != null) {
            // 龟走一步
            slow = slow.next;
            // 兔走两步
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }





}
