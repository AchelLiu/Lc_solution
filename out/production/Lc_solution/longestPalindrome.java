import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;


/**
 * 5. Longest Palindromic Substring
 * Given a string s, return the longest palindromic substring in s.
 * solution nums:4470_4
 * label: dynamic programming
 */



class longestPalindrome {
    public static String longestPalindrome(String s) {
        //利用分类讨论硬解
        String sub = new String();
        if(s == null || s.length()<=1){
            sub = s; //one letter belongs to palindrome
            return sub;
        }
        Character c = s.charAt(0);
        sub = c.toString();
        ArrayList list = new ArrayList();
        for(int i=0;i<s.length();i++){
            c = s.charAt(i);
            int index = list.indexOf(c);
            if(index < 0){
                list.add(c);

            }else if(index == 0 && index==i-1){
                list.add(c);
                for(int j=i+1;j<s.length();j++){
                    Character c1 = s.charAt(j);
                    if(list.contains(c1)){
                        list.add(c1);
                    }else{
                        i=j;
                        break;
                    }
                }
                if(i-index+1>sub.length()){
                    StringBuffer buffer = new StringBuffer();
                    for(int x=index;x<list.size();x++){
                        buffer.append(list.get(x));
                    }
                    sub=buffer.toString();
                }
                list = new ArrayList();
                continue;

            }else if(index == 0 && index==i-2){
                // System.out.println("flag2");
                list.add(c);
                if(i-index+1>sub.length()){
                    StringBuffer buffer = new StringBuffer();
                    for(int x=index;x<list.size();x++){
                        buffer.append(list.get(x));
                    }
                    sub=buffer.toString();
                }
                list = new ArrayList();
                continue;

            }else if(index > 0 && i-index<=2){
                list.add(c);
                for(int j=i+1;j<s.length();j++){
                    Character c1 = s.charAt(j);
                    index -= 1;
                    List list1 = list.subList(index,index);
                    if(list1.contains(c1)){
                        list.add(c1);
                    }else{
                        i=j;
                        break;
                    }
                }
                if(i-index+1>sub.length()){
                    StringBuffer buffer = new StringBuffer();
                    for(int x=index;x<list.size();x++){
                        buffer.append(list.get(x));
                    }
                    sub=buffer.toString();
                }
                list = new ArrayList();
                continue;

            }else{
                list = new ArrayList();
                continue;
            }
        }
        return sub;
    }

     //copy from official ans：动态规划
     public static String longestPalindrome_official(String s) {
         int len = s.length();
         if(len<2){
             return s;
         }
         //s to list
         char[] charlist = s.toCharArray();
         boolean[][] dp = new boolean[len][len];
         int maxlen = 1;
         int begin = 0;
         //边界1：所有一个字母都为true
         for(int i=0;i<len;i++){
             dp[i][i] = true;
         }

         //先遍历L再遍历i，获得所有的dp[][]
         for(int L=2;L<=len;L++){
             for(int i=0;i<len;i++){
                 int j =i+L-1;
                 if(j>=len){
                     break;
                 }
                 if(charlist[i] != charlist[j]){
                     dp[i][j] = false;
                 }else{
                     if(L<=3){
                         dp[i][j] = true;
                     }else{
                         dp[i][j]=dp[i+1][j-1];
                     }
                 }
                 //记录初始位置和长度
                 if(dp[i][j] && L>maxlen){
                     maxlen = L;
                     begin = i;
                 }
             }
         }
         return s.substring(begin,begin+maxlen);
     }


    public static void main(String args[]){
        String s = "ccc";
        String sub = longestPalindrome(s);
        System.out.println(sub);
    }
}
