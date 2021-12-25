import java.util.ArrayList;
import java.util.List;

/**
 * 2. Add Two Numbers
 * You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order, and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 * solution nums:7855_2
 */



class addTwoNumbers {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1.val == 0){
            return l2;
        }
        if(l2.val == 0){
            return l1;
        }
        // System.out.println("wait");
        if(l1.val + l2.val >=10){
            ListNode l3 = new ListNode(l1.val + l2.val-10);
            // l3.next.val = 1;
            return l3;
        }
        else{
            ListNode l3 = new ListNode(l1.val + l2.val);
            return l3;
        }
    }

     //copy from official ans
     public ListNode addTwoNumbers_official(ListNode l1, ListNode l2) {
         ListNode head = null, tail = null;
         int carry = 0;
         while (l1 != null || l2 != null){

             int n1 = l1 !=null ? l1.val : 0;
             int n2 = l2 !=null ? l2.val : 0;
             int sum = n1 + n2 + carry;
             carry = (n1+n2+carry)/10;
             if(head == null){
                 head = tail = new ListNode(sum%10);
             }else{
                 tail.next = new ListNode(sum%10);
                 tail=tail.next;
             }
             if(l1!=null){
                 l1=l1.next;
             }
             if(l2!=null){
                 l2=l2.next;
             }
         }
         if(carry>0){
             tail.next=new ListNode(carry);
             tail=tail.next;
         }
         return head;
     }

    public static void main(String args[]){
        String s = "ccc";
        String sub = addTwoNumbers(s);
        System.out.println(sub);
    }
}
