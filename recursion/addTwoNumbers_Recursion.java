import java.util.Objects;

/**
 * 2. Add Two Numbers
 * You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order, and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 * solution nums:7855_2
 * label: LinkedList
 */



class addTwoNumbers_Recursion {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    /* 哨兵节点 */
    ListNode nullNode = new ListNode();

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        addTwoNumbers(l1, l2, nullNode, false);
        /* 返回next节点即可 */
        return nullNode.next;
    }

    public void addTwoNumbers(ListNode a, ListNode b, ListNode curr, boolean flag) {
        /* a b 皆为null， 终止递归 */
        if (Objects.isNull(a) && Objects.isNull(b)) {
            /* 即使 a b 皆为null，但是如果上两个节点需要进一位，那么最后依然产生一个val=1的节点 */
            if (flag) curr.next = new ListNode(1);
            return;
        }

        int val = flag ? 1 : 0;
        if (Objects.nonNull(a)) val += a.val;
        if (Objects.nonNull(b)) val += b.val;

        ListNode next = new ListNode(val % 10);
        curr.next = next;
        addTwoNumbers(
                Objects.isNull(a) ? null : a.next,
                Objects.isNull(b) ? null : b.next,
                next,
                val / 10 != 0
        );
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

            ListNode ret = new addTwoNumbers_Recursion().addTwoNumbers(l1, l2);

            String out = listNodeToString(ret);

            System.out.print(out);
        }
    }
}

