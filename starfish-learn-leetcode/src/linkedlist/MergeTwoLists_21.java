package linkedlist;

/**
 * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 * <p>
 * 示例：
 * <p>
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 */
public class MergeTwoLists_21 {


    public static ListNode mergeLists(ListNode l1,ListNode l2){
        if(l1 == null) return l2;
        if(l2 == null) return l1;

        if(l1.val < l2.val){
            l1.next = mergeLists(l1.next,l2);
            return l1;
        }else{
            l2.next = mergeLists(l1,l2.next);
            return l2;
        }

    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        node1.addToEnd(2);

        ListNode node2 = new ListNode(1);
        node2.addToEnd(3);
        node2.addToEnd(4);

        mergeLists(node1,node2);

    }








}
