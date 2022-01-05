import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 17. Letter Combinations of a Phone Number
 * Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent. Return the answer in any order.
 * A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.
 * solution nums:3435_8
 * label:
 *
 */



class letterCombinations {
    public static List<String> letterCombinations(String s) {
        List<List<String>> ls = null;
        //ls赋值
        List<String> res = ls.get(0);
        for(int i=0;i<ls.toArray().length;i++){
            res = conbine(res,ls.get(i));
        }
        return res;
    }
    public static List<String> conbine(List<String> a, List<String> b){
        List<String> tmp = null;
        if(a == null) return b;
        if(b == null) return a;
        for(int i=0;i<a.size();i++){
            for(int j=0;j<b.size();j++){
                tmp.add(a.get(i)+b.get(j));
            }
        }
        return tmp;
    }

//    public static void main(String args[]){
//
//    }
}
