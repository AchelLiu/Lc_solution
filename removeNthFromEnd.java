import java.util.ArrayList;
import java.util.List;


/**
 * 19. Remove Nth Node From End of List
 * Given the head of a linked list, remove the nth node from the end of the list and return its head.
 * solution nums:4448_5
 */


class removeNthFromEnd {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }


    public static ListNode removeNthFromEnd(ListNode head, int n) {
        //how to get the index = length-n?
        //how to remove the nth node?
        //一个不太聪明的思路：将初始listnode转化成list，获得index，去掉index对应的node，重新add
        //add()
        ListNode tail = null;
        for(int i =0;i<5;i++){
            ListNode l = new ListNode(i);
            if(tail == null){
                head = tail = l;
            }else{
                tail.next = l;
                tail = tail.next;
                System.out.println("tail val:"+tail.val);
            }
        }
        //removeLast()
        for(int i=0;i<n;i++){
            if(tail==null) return tail;
            else{
                continue;
            }

        }
        return head;
    }


    public ListNode removeNthFromEnd_official(ListNode head, int n) {
            return head ;
    }

    public static void main(String args[]){
        ListNode head = new ListNode();
        int n = 3;
        ListNode res = removeNthFromEnd(head,n);
        System.out.println(head.val);
    }
}
