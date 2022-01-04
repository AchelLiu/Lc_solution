package recursion;

import java.util.List;
import java.util.Stack;

public class precticeFunc {
    //排列组合permutation
    public static class permutation{
        public static Stack<Integer> stack = new Stack<Integer>();
        public static void main(String[] args) {
        int shu[] = {1,2,3};
        f(shu,4,0);
        }

        /**
         * @param shu   待选择的数组
         * @param targ  要选择多少次
         * @param cur   当前选择的是第几次
         */
        private static void f(int[] shu, int targ, int cur) {
            // TODO Auto-generated method stub
            if(cur == targ) {
                System.out.println(stack);
                return;
            }

            for(int i=0;i<shu.length;i++) {
                stack.add(shu[i]);
                f(shu, targ, cur+1);
                stack.pop();

            }
        }

    }

    //n阶乘 factorial
    public static class factorial{
        static int f1(int n){
            if(n<=1){
                return n;
            }
            int res = f1(n-1)+f1(n-2);
            System.out.println(res);
            return res;
        }
        public static void main(String[] args) {
            f1(4);
        }
    }

    //斐波那契
    public static class Fibonacci{
        static int f(int n){
            if(n<=2){
                return 1;
            }
            return f(n-1)+f(n-2);
        }
        public static void main(String args[]){
            System.out.println(f(3));
        }

    }

    //小青蛙跳台阶
    public static class frogJump{
        //第一次跳1阶，还剩n-1，对应就剩下f(n-1)种跳法
        //第一次跳2阶，还剩n-2，对应就剩下f(n-2)种跳法
        //数量应该是两种方式之和
        static int f(int n){
            if(n<=2){
                return n;
            }
            return f(n-1)+f(n-2);
        }
        public static void main(String args[]){
            System.out.println(f(3));
        }
    }

    //反转链表
    public static class reverseList{
        public static class ListNode {
            int val;
            ListNode next;
            ListNode() {}
            ListNode(int val) { this.val = val; }
            ListNode(int val, ListNode next) { this.val = val; this.next = next; }
        }
        public static ListNode f(ListNode head){
            if(head==null||head.next==null){
                return head;
            }
            ListNode ans = f(head.next);
            head.next.next = head;
            head.next = null;
            return ans;
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
                String line1="[1,2,3,4,5]";
                ListNode l1 = stringToListNode(line1);

                ListNode ret = new reverseList().f(l1);

                String out = listNodeToString(ret);

                System.out.print(out);
            }
        }
    }

    //赶鸭子 f(n)/2-1=f(n+1) ==> f(n) =2*(f(n+1)+1)
    public static class Duck{
        /**
         *
         * @param n 经过的第n个村庄 0<=n<=7
         * @return 鸭子在第n个村庄的数量，n=0表示出发时的总数
         */
        public static int f(int n){
            if(n==7){
                return 2;
            }
            return 2*(f(n+1)+1);
        }
        public static void main(String[] args){
            for(int i=0;i<=7;i++){
                System.out.println(i+"村庄的鸭子数为："+f(i));
            }
        }
    }


}
