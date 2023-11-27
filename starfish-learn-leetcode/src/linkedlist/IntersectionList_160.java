package linkedlist;

/**
 * @description:
 * @author: starfish
 * @create: 2020-07-29 20:12
 */
public class IntersectionList_160 {
    public ListNode getIntersectionNode1(ListNode headA, ListNode headB){
        if(headA == null) return headB;
        if(headB == null) return headA;
        ListNode p1 = headA, p2 = headB;
        while(p1 != p2) {
            p1 = p1 == null ? headB : p1.next;
            p2 = p2 == null ? headA : p2.next;
        }
        return p1;
    }












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



    public ListNode getIntersectionNode_me(ListNode headA,ListNode headB){
        if(headA == null || headB == null){
            return null;
        }
        ListNode pA = headA;
        ListNode pB = headB;
        while(pA != pB){
            //这里注意如果
            pA = pA == null ? headB : pA.next;
            pB = pB == null ? headA : pB.next;
        }
        return pA;
    }

}
