package recursion;

import java.util.List;
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

    public static ListNode swapNode(ListNode head) {
        //寻找递归终结 ： 递归的终止条件是链表中没有节点，或者链表中只有一个节点，此时无法进行交换。
        if(head == null || head.next==null){
            return head;
        }
        //递归块：没想明白是啥传进来，啥传出去，功能是啥。
        //传进来一个head，f=把head和它的next交换位置。输出的是新head。找到新head和老head的关系：新head是被交换后的第二个节点（原head）的next

        //原本的写法：
//        swapNode(head.next.next);
//        ListNode dummy=head.next; //功能实现√：把第二个node给新节点
//        head.next=dummy.next;//这种写法没有把新的头节点放到递归里
//        dummy.next=head; //功能实现√：把原head节点给dummy.next
//        head = dummy;
//        return head;
        
//        如果链表中至少有两个节点，则在两两交换链表中的节点之后，原始链表的头节点变成新的链表的第二个节点，原始链表的第二个节点变成新的链表的头节点。
//        链表中的其余节点的两两交换可以递归地实现。在对链表中的其余节点递归地两两交换之后，更新节点之间的指针关系，即可完成整个链表的两两交换。
//        用 head 表示原始链表的头节点，新的链表的第二个节点，用 newHead 表示新的链表的头节点，原始链表的第二个节点，则原始链表中的其余节点的头节点是 newHead.next。
//        令 head.next = swapPairs(newHead.next)，表示将其余节点进行两两交换，交换后的新的头节点为 head 的下一个节点。
//        然后令 newHead.next = head，即完成了所有节点的交换。最后返回新的链表的头节点 newHead。
        //标准答案的写法：
        ListNode newHead = head.next;
        head.next=swapNode(newHead.next);//原始链表中的其余节点的头节点是 newHead.next， head.next = swapPairs(newHead.next)，表示将其余节点进行两两交换，交换后的新的头节点为 head 的下一个节点。
        newHead.next=head;
        return newHead;
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
            String line1="[1,2,3,4,5,6]";
            ListNode head = stringToListNode(line1);

            ListNode ret =swapNode(head);

            String out = listNodeToString(ret);

            System.out.print(out);
        }
    }
}

