import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 2. Add Two Numbers
 * You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order, and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 * solution nums:7855_2
 * label: LinkedList
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
//        ListNode res = null; //为啥不能只初始化 一个 node：res后面会被覆盖，而我们需要返回的是头节点，所以需要初始化两个
        ListNode head = null,res = null;

//        if (l1.val == 0 || l1==null) return res=l2;
//        if(l2.val == 0 || l2==null) return res=l1;

        while(l1 !=null || l2 !=null){
            //需要先对head判空，如果head为null需要赋值，如果head不为null就不动，最终需要返回的是head
            //机智的做法就是直接new int，放两个node的val，下面这种办法还没有计算进位carry
            if(head == null) head = res = new ListNode(l1.val+l2.val);
            else res = res.next = new ListNode(l1.val+l2.val);
            l1 = l1.next;
            l2 = l2.next;
        }

        return head;

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

    public static class MainClass {
        public static int[] stringToIntegerArray(String input) {
            input = input.trim();
            input = input.substring(1, input.length() - 1);
            if (input.length() == 0) {
                return new int[0];
            }

            String[] parts = input.split(",");
            int[] output = new int[parts.length];
            for(int index = 0; index < parts.length; index++) {
                String part = parts[index].trim();
                output[index] = Integer.parseInt(part);
            }
            return output;
        }

        public static ListNode stringToListNode(String input) {
            // Generate array from the input
            int[] nodeValues = stringToIntegerArray(input);

            // Now convert that list into linked list
            ListNode dummyRoot = new ListNode(0);
            ListNode ptr = dummyRoot;
            for(int item : nodeValues) {
                ptr.next = new ListNode(item);
                ptr = ptr.next;
            }
            return dummyRoot.next;
        }

        public static String listNodeToString(ListNode node) {
            if (node == null) {
                return "[]";
            }

            String result = "";
            while (node != null) {
                result += Integer.toString(node.val) + ", ";
                node = node.next;
            }
            return "[" + result.substring(0, result.length() - 2) + "]";
        }

        public static void main(String[] args) {
            String line1="[]";
            String line2="[4,5,6]";
            ListNode l1 = stringToListNode(line1);
            ListNode l2 = stringToListNode(line2);

            ListNode ret = new addTwoNumbers().addTwoNumbers(l1, l2);

            String out = listNodeToString(ret);

            System.out.print(out);
        }
    }
}
