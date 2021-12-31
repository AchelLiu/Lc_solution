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
        int[] ls = new int[0];
        if(head==null){
            return head;
        }
        ListNode tail = head; //复制head
        ListNode first = new ListNode(0,tail);

        //how to get the index = length-n: 用一个遍历。这一块在标准答案里被封装成了一个函数
        int length = 0;
        while(tail != null){
            ++length;
            if(tail.next==null){
                break;
            }
//            ls[i]=tail.val;
            tail = tail.next;  //循环完tail为head的最后一个节点
//            System.out.println("head:" +head.val);
        }

        //怎么保留前index-1个节点：一个不太聪明的思路：重新add
        //困难：怎么add到想要的位置停住。
        for(int i=0;i<length-n;i++){
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
        ListNode dummy = new ListNode(0, head);
        int length = getLength(head);
        //链表的赋值操作是什么含义：并不是单纯的复制，感觉是多了一个引用，当修改引用cur.next的时候，head和dummy会相应变动
        ListNode cur = dummy;
        for (int i = 1; i < length - n; ++i) {
            cur = cur.next;
        }
        cur.next = cur.next.next;
        ListNode ans = dummy.next;
        return ans;
//        这是一个容易空指针的写法，不借助cur直接在dummy=head上操作，当dummy.next.next为空时，返回head会报空指针
//        ListNode dummy = head;
//        for (int i = 1; i < length - n; ++i) {
//            dummy = dummy.next;
//        }
//        dummy.next = dummy.next.next;
//        ListNode ans = head;
//        return ans;

    }

    public int getLength(ListNode head) {
        int length = 0;
        while (head != null) {
            ++length;
            head = head.next;
        }
        return length;
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

            ListNode ret = new removeNthFromEnd().removeNthFromEnd_official(l1,n);

            String out = listNodeToString(ret);

            System.out.print(out);
        }
    }
}
