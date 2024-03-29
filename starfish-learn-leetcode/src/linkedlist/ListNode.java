package linkedlist;

/**
 * @description:
 * @author: starfish
 * @create: 2020-07-29 20:13
 */
public class ListNode {
    public int val;
    public ListNode next;

    ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public void add(int newData){
        ListNode newNode = new ListNode(newData);

    }
    public void addToEnd(int data){
        ListNode temp = this;
        while(temp.next!=null){
            temp=temp.next;
        }
        temp.next=new ListNode(data, null);
    }

    /**
     * 打印链表
     **/
    public static void printLinkedList(ListNode head) {
        ListNode node = head;
        while (node != null) {
            System.out.print(node.val);
            node = node.next;
        }
    }
}
