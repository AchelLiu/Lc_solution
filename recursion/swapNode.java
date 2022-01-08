package recursion;

import java.util.Objects;

/**
 * 2. Add Two Numbers
 * You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order, and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 * solution nums:7855_2
 * label: LinkedList
 */



class swapNode {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    /* 哨兵节点 */
//    ListNode dummy = new ListNode(0,head);

//    public static ListNode swapNode(ListNode head) {
//        if(head == null || head.next==null){
//            return head;
//        }
//        ListNode cur = head;
//        ListNode res = swapNode(head.next.next);
//        head = head.next;
//        head.next = cur;
//        cur.next=cur.next.next;
//        return  res;
//    }


    public static ListNode swapNode(ListNode head) {
//        ListNode dummy = new ListNode(0,head);
        ListNode res = swapNodes(head);
        return res;
    }
    public static ListNode swapNodes(ListNode head){
        if(head == null || head.next==null){
            return head;
        }
        swapNodes(head.next);
        ListNode dummy=head.next;

        head.next=head.next.next;
        dummy.next=head;
        return dummy;
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
            String line1="[1,2,3,4]";
            ListNode head = stringToListNode(line1);

            ListNode ret =swapNode(head);

            String out = listNodeToString(ret);

            System.out.print(out);
        }
    }
}

