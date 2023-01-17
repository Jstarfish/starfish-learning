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

    public static ListNode merge(ListNode l1,ListNode l2){
        if(l1 == null) return l2;
        if(l2 == null) return l1;
        ListNode dummy = new ListNode(-1);
        ListNode p = dummy;
        while (l1 !=null && l2!=null){
            if(l1.val < l2.val){
                p.next = l1;
                l1 = l1.next;
            }else{
                p.next = l2;
                l2 = l2.next;
            }
            p = p.next;
        }
        if(l1 !=null) p.next=l1;
        if(l2 !=null) p.next=l2;
        return dummy.next;

    }





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

    // 1,2,3
    //1,3,4
    //1,1,2,3,3,4
    public ListNode mergeList(ListNode n1,ListNode n2){
        if(n1 == null) return n2;
        if(n2 == null) return n1;

        ListNode dummy = new ListNode(-1);
        ListNode p = dummy;

        // 比较 p1 和 p2 两个指针
        // 将值较小的的节点接到 p 指针
        while (n1 != null && n2 != null){
            if(n1.val <= n2.val) {
                p.next = n1;
                n1 = n1.next;
            }else {
                p.next = n2;
                n2 = n2.next;
            }
            // p 指针不断前进
            p = p.next;
        }

        //处理比较后较长的链表剩余部分
        if (n1 != null) {
            p.next = n1;
        }

        if (n2 != null) {
            p.next = n2;
        }
        return dummy.next;

    }









}
