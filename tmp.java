import java.util.Stack;

public class tmp {
    public static Stack<Integer> stack = new Stack<Integer>();
    public static void main(String[] args) {
//        int shu[] = {1,2,3};
//        f(shu,4,0);
        f1(4);
    }

    /**
     *
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
    static int f1(int n){
        if(n<=1){
            return n;
        }
        int res = f1(n-1)+f1(n-2);
        System.out.println(res);
        return res;
    }
}
