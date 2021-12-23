package linkedlist;

import java.util.ArrayList;
import java.util.List;

/**
 * 请判断一个链表是否为回文链表。
 *
 * 示例 1:
 *
 * 输入: 1->2
 * 输出: false
 * 示例 2:
 *
 * 输入: 1->2->2->1
 * 输出: true
 */
public class PalindromeList_234 {

    public static boolean isPalindrome_1(ListNode head) {
        List<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        int[] arr = new int[list.size()];

        for (int i = 0; i < list.size(); i++) {
            arr[i] = list.get(i);
        }

        int temp = 0;
        for (int i = 0;i < arr.length/2;i++) {
            if (arr[i] == arr[arr.length-i-1]) {
                temp++;
            }
        }
        if(temp == arr.length/2) {
            return true;
        }
        return false;
    }

    /**
     *  解法2  快慢指针
     * @param head
     * @return
     */
    public boolean isPalindrome(ListNode head) {
        if(head == null  || head.next == null) {
            return true;
        }
        ListNode p = new ListNode(-1);
        ListNode low = p;
        ListNode fast = p;
        p.next = head;
        //使用快慢指针来确定中间结点
        while(fast != null && fast.next != null){
            low = low.next;
            fast = fast.next.next;
        }
        ListNode cur = low.next;
        ListNode pre = null;
        low.next = null;
        low = p.next;

        //反转后半部分链表
        while(cur != null){
            ListNode tmp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = tmp;
        }
        //将前半部分链表和后半部分进行比较
        while(pre != null){
            if(low.val != pre.val){
                return false;
            }
            low = low.next;
            pre = pre.next;
        }
        return true;
    }



    public static boolean isPalindrome_me(ListNode head){
        if(head == null || head.next == null){
            return false;
        }
        List<Integer> list = new ArrayList<>();
        while(head != null){
            list.add(head.val);
            head = head.next;
        }
        Integer[] arrs = list.toArray(new Integer[list.size()]);

        int tmp = 0;
        for(int i=0;i<arrs.length/2;i++){ //注意这里只遍历到一半就可以了
            if(arrs[i]== arrs[arrs.length-i-1]){
                tmp++;
            }
        }
        return tmp == arrs.length / 2;
    }

    public static void main(String[] args){
        ListNode head = new ListNode(1);
        head.addToEnd(2);
        head.addToEnd(2);
        head.addToEnd(3);
        System.out.println(isPalindrome_me(head));


    }

}
