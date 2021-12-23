package linkedlist;

/**
 * @description:
 * @author: starfish
 * @create: 2020-07-29 20:12
 */
public class IntersectionList_160 {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode pA = headA, pB = headB;
        while (pA != pB) {
            pA = pA == null ? headB : pA.next;
            pB = pB == null ? headA : pB.next;
        }
        return pA;
    }



    public ListNode getIntersectionNode1(ListNode headA,ListNode headB){
        if(headA == null || headB == null){
            return null;
        }
        ListNode a = headA;
        ListNode b = headB;
        while (a != b){
            a = a==null?headB:a.next;
            b = b==null?headA:b.next;
        }
        return a;

    }

}
