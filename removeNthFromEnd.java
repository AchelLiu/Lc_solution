import java.util.ArrayList;
import java.util.List;


/**
 * 19. Remove Nth Node From End of List
 * Given the head of a linked list, remove the nth node from the end of the list and return its head.
 * solution nums:4448_5
 * label: LinkedList
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
        //how to get the index = length-n: 用一个遍历
        int length = 0;
        int[] ls = new int[0];
        if(head==null){
            return head;
        }
        ListNode tail = head;
        ListNode first = null;
        while(tail != null){
            ++length;
//            System.out.println("length:" +length);
            if(tail.next==null){
                break;
            }
//            ls[i]=tail.val;
            tail = tail.next;
//            System.out.println("head:" +head.val);
        }
        //怎么保留前index-1个节点：一个不太聪明的思路(abandon)：重新add
        //困难：怎么取到单个节点？
        for(int i=0;i<length-n-1;i++){
            if(first==null){
                first=tail=head;
            }else {
                tail = tail.next = head.next;
            }

        }
        //how to remove the nth-rev node：保留前index-1个节点，让第index-1节点的next指向index+1
        //add()
//        for(int i =0;i<5;i++){
//            ListNode l = new ListNode(i);
//            if(tail == null){
//                head = tail = l;
//            }else{
//                tail.next = l;
//                tail = tail.next;
//                System.out.println("tail val:"+tail.val);
//            }
//        }
//        //removeLast()
//        for(int i=0;i<n;i++){
//            if(tail==null) return tail;
//            else{
//                continue;
//            }
//
//        }
        return first;
    }


    public ListNode removeNthFromEnd_official(ListNode head, int n) {
            return head ;
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
            String line1="[1,2,3]";
            ListNode l1 = stringToListNode(line1);
            int n = 1;

            ListNode ret = new removeNthFromEnd().removeNthFromEnd(l1,n);

            String out = listNodeToString(ret);

            System.out.print(out);
        }
    }
}
