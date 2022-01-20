package recursion;

public class myPow {
    public static double myPow(double x, int n) {
        int n_abs = Math.abs(n);
        if(n_abs<=1){
            return x;
        }
        if(n<0 && x != 0){
            x=1/x;
        }
        return myPow(x,n_abs-1)*myPow(x,n_abs-2);

    }
    public static void main(String args[]){
        System.out.println(myPow(2.00000,5));
    }

}
