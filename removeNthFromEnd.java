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

    /**
     * 总结：这个解法基本抄的标准答案，解决了两个困难点：1）怎么获取链表长度；2）怎么在想要的位置停住，并接上后续。
     * 链表的赋值并不是完全的复制，似乎只是new了一个引用的变量名
     *  对变量名本身重写的时候，对原链表没有影响：cur=cur.next, dummy和head都不变
     *  对变量名.next重写的时候，原链表会跟着变：cur.next=cur.next.next, dummy和head同时去掉了cur.next指向的node
     *  但是不可以不借助第三个变量cur，在dummy上直接操作，会有空指针的问题
     */


    public static ListNode removeNthFromEnd(ListNode head, int n) {
        int length = 0;

        ListNode tail = head;

        //how to get the index = length-n: 用一个遍历
        while(tail != null){
            ++length;
            if(tail.next==null){
                break;
            }
            tail = tail.next;
        }

        //怎么保留前index-1个节点：一个不太聪明的思路：重新add
        //困难：怎么停在想要的位置，并且接上后面的next.next？
        ListNode dummy = new ListNode(0,head);
        ListNode cur = dummy;
        for(int i=0;i<length-n;i++){
            cur=cur.next;
        }

        //how to remove the nth-rev node：保留前index-1个节点，让第index-1节点的next指向index+1
        cur.next=cur.next.next;
        ListNode ans = dummy.next;
        return ans;

//        //这种写法就在[2]这种链表的时候操作返回空指针
//        ListNode dummy = new ListNode(0,head);
//        for(int i=0;i<length-n+1;i++){
//            dummy=dummy.next;
//        }
//
//        //how to remove the nth-rev node：保留前index-1个节点，让第index-1节点的next指向index+1
//        dummy.next=dummy.next.next;
//        ListNode ans = dummy.next;
//        return ans;
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
            String line1="[1]";
            ListNode l1 = stringToListNode(line1);
            int n = 1;

            ListNode ret = new removeNthFromEnd().removeNthFromEnd(l1,n);

            String out = listNodeToString(ret);

            System.out.print(out);
        }
    }
}
