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
    public static List<String> letterCombinations(String digits) {
        List<List<String>> ls = new ArrayList<List<String>>(){{
            add(Arrays.asList(""));
            add(Arrays.asList(""));
            add(Arrays.asList("a","b","c"));
            add(Arrays.asList("d","e","f"));
            add(Arrays.asList("g","h","i"));
            add(Arrays.asList("j","k","l"));
            add(Arrays.asList("m","n","o"));
            add(Arrays.asList("p","q","r","s"));
            add(Arrays.asList("t","u","v"));
            add(Arrays.asList("w","x","y","z"));
        }};
        List<String> res = new ArrayList<>();
        //decode digits to list
        for(char i:digits.toCharArray()){
            res = combine(res,ls.get(Integer.parseInt(String.valueOf(i))));
        }
        return res;
    }
    public static List<String> combine(List<String> a, List<String> b){
        List<String> tmp = new ArrayList<>();
        if(a.size()==0) return b;
        if(b.size()==0) return a;
        for(int i=0;i<a.size();i++){
            for(int j=0;j<b.size();j++){
                tmp.add(a.get(i)+b.get(j));
            }
        }
        return tmp;
    }

    public static void main(String args[]){
        String s = "234";
        System.out.println(letterCombinations(s));
    }
}
