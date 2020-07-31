package linkedlist;

/**
 * @description:
 * @author: starfish
 * @create: 2020-07-29 20:13
 */
public class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
