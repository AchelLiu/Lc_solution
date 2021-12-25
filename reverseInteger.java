
import java.util.ArrayList;
import java.util.List;

/**
 * 7. Reverse Integer
 * Given a signed 32-bit integer x, return x with its digits reversed. If reversing x causes the value to go outside the signed 32-bit integer range [-231, 231 - 1], then return 0.
 * Assume the environment does not allow you to store 64-bit integers (signed or unsigned).
 * solution nums:5707_3
 *
 */



class reverseInteger {
        public static int reverseInteger(int x) {
            //出现很多超界返回错误的情况，一点点打上了补丁
            int x_abs = Math.abs(x);
            int length = String.valueOf(x_abs).length();
            int y=0;
            if(x<=-2147483648 || x>=2147483647){
                return y;
            }
            List<Long> ls = new ArrayList();
            for(int i=1;i<=length;i++){
                long divisor = ((long) Math.pow(10, i));
                long mod = x_abs%divisor;
                long num = mod/(divisor/10);
//                System.out.println("mod:" +mod);
//                System.out.println("divisor:" +divisor);
//                System.out.println("num:" +num);
                ls.add(num);
                // System.out.println("ls:" +ls);
            }
            for(int i=0;i<ls.size();i++){
                long divisor = ((long) Math.pow(10, i));
                long plusor = ((long) Math.pow(10, ls.size()-1))/divisor;
                if(ls.get(i) * plusor>2147483647 || y + ls.get(i) * plusor>2147483647){
                    return y=0;
                }else{
                    y += ls.get(i) * plusor;
                }
                // System.out.println("divisor:" +divisor);
                // System.out.println("plusor:" +plusor);
                // System.out.println("y:" +y);
            }
            if(x<0){
                y=-y;
            }
            return y;
        }

    //充分讨论了return 0 的情况
    public int reverse_official(int x) {
        int rev = 0;
        while (x != 0) {
            if (rev < Integer.MIN_VALUE / 10 || rev > Integer.MAX_VALUE / 10) {
                return 0;
            }
            int digit = x % 10;
            x /= 10;
            rev = rev * 10 + digit;
        }
        return rev;
    }

    public static void main(String args[]){
        int x = 1563847412;
        int res = reverseInteger(x);
        System.out.println(res);
    }
}
