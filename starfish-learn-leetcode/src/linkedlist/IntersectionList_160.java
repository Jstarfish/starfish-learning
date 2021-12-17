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






//    public ListNode getIntersectionNode(ListNode headA,ListNode headB){
//        if(headA == null || headB == null){
//            return null;
//        }
//        ListNode pa = headA;
//        ListNode pb = headB;
//        while (pa != pb){
//            pa = pa == null? headB:pa.next;
//            pb = pb == null?headA:pb.next;
//        }
//        return pb;
//    }

}
