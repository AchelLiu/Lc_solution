import java.util.Set;
import java.util.HashSet;

/**
 * 3. Longest Substring Without Repeating Characters
 * Given a string s, find the length of the longest substring without repeating characters.
 * solution nums:8311_1
 * label: 双指针+hashset
 */



class lengthOfLongestSubstring {
    public static int lengthOfLongestSubstring(String s) {
        //双指针+HashSet
        int size = 1;
        if(s.length()==0||s == null){
            size = 0;
        }
        for(int i=0;i<s.length();i++){
            Set set = new HashSet();
            set.add(s.charAt(i));

            for(int j=i+1;j<s.length();j++){
                if(set.contains(s.charAt(j))){
                    break;
                }
                set.add(s.charAt(j));
            }
            if(set.size()>size){
                size = set.size();
            }
        }
        return size;
    }

     //copy from official ans: 滑动窗口
     public int lengthOfLongestSubstring_official(String s) {
         // 哈希集合，记录每个字符是否出现过
         Set<Character> occ = new HashSet<Character>();
         int n = s.length();
         // 右指针，初始值为 -1，相当于我们在字符串的左边界的左侧，还没有开始移动
         int rk = -1, ans = 0;
         for (int i = 0; i < n; ++i) {
             if (i != 0) {
                 // 左指针向右移动一格，移除一个字符
                 occ.remove(s.charAt(i - 1));
             }
             while (rk + 1 < n && !occ.contains(s.charAt(rk + 1))) {
                 // 不断地移动右指针
                 occ.add(s.charAt(rk + 1));
                 ++rk;
             }
             // 第 i 到 rk 个字符是一个极长的无重复字符子串
             ans = Math.max(ans, rk - i + 1);
         }
         return ans;
     }


    public static void main(String args[]){
        String s = "ccc";
        int sub = lengthOfLongestSubstring(s);
        System.out.println(sub);
    }
}
