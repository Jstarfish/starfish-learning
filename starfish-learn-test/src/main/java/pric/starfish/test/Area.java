package pric.starfish.test;

/**
 * @author Henry
 * @date 2021/12/15
 */
public class Area {

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        listNode1.next = listNode2;

        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        listNode3.next = listNode4;

        ListNode result = mergeList(listNode1, listNode3);

        while(result.val != null){
            System.out.println(result.next);
            result.val = result.next.val;
        }


    }


    public static ListNode mergeList(ListNode l1,ListNode l2){
        if(l1 == null){
            return l2;
        }else if(l2 == null){
            return l1;
        }else if(l1.val < l2.val){
            mergeList(l1.next,l2);
            return l1;
        }else{
            mergeList(l1,l2.next);
            return l2;
        }
    }
}

class ListNode{
    int val;
    ListNode next;

    ListNode(val){
        this.val = val;
    }
}

class MyListNode{
    ListNode head;

    void addNode(){

    }
}
