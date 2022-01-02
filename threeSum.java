import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * 15. 3Sum
 * Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
 * Notice that the solution set must not contain duplicate triplets.
 * solution nums:3484_7
 * label: two pointers, sorting
 *
 */


//*双指针：当我们需要枚举数组中的两个元素时，如果我们发现随着第一个元素的递增，第二个元素是递减的，那么就可以使用双指针的方法，将枚举的时间复杂度从 O(N^2)减少至O(N)。为什么是 O(N) 呢？这是因为在枚举的过程每一步中，「左指针」会向右移动一个位置（也就是题目中的 bb），而「右指针」会向左移动若干个位置，这个与数组的元素有关，但我们知道它一共会移动的位置数为 O(N)，均摊下来，每次也向左移动一个位置，因此时间复杂度为 O(N)。

//排序的时间复杂度为O(NlogN)

class threeSum {
    public static ArrayList threeSum(int[] nums) {
        ArrayList ans = new ArrayList<int[]>();
        int len = nums.length;
        //直接返回长度不够的数组
        if(len<=2){
            return ans;
        }

        Arrays.sort(nums);
        //直接返回全正数&全负数数组
        if(nums[0]>0 || nums[len-1]<0){
            return ans;
        }
        //直接返回开头三个0&结尾三个0的数组
        if((nums[0]==0 && nums[1]==0 && nums[2]==0)||(nums[len-1]==0 && nums[len-2]==0 && nums[len-3]==0)){
            ans.add(new int[]{0,0,0});
            return ans;
        }

        for(int i=0;i<len;i++){
            if(i>0 &&nums[i]==nums[i-1]){
                continue;
            }
            for(int j=i+1;j<len;j++){
                if(j>i+1 &&nums[j]==nums[j-1]){
                    continue;
                }
                for(int k=j+1;k<len;k++) {
                    if(k>j+1 &&nums[k]==nums[k-1]){
                        continue;
                    }
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        ans.add(new int[]{nums[i], nums[j], nums[k]});
                    }
                }
            }

        }
        //解法2：虽然增加了i，j，k num相同时退出的机制，还是n^3的复杂度，会导致时间超出
        for(int i=0;i<len;i++){
            if(i>0 &&nums[i]==nums[i-1]){
                continue;
            }
            for(int j=i+1;j<len;j++){
                if(j>i+1 &&nums[j]==nums[j-1]){
                    continue;
                }
                for(int k=j+1;k<len;k++) {
                    if(k>j+1 &&nums[k]==nums[k-1]){
                        continue;
                    }
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        ans.add(new int[]{nums[i], nums[j], nums[k]});
                    }
                }
            }

        }
        return ans;

//        解法1：这种粗暴的三次遍历方式会导致输出ans有重复，abandoned
//        ArrayList ans = new ArrayList<int[]>();
//        int len = nums.length;
//        int index = 0;
//        if(len<=2){
//            return ans;
//        }
//        for(int i=0;i<len;i++){
//            for(int j=i+1;j<len;j++){
//                for(int k=j+1;k<len;k++) {
//                    if (nums[i] + nums[j] + nums[k] == 0) {
//                        ans.add(new int[]{nums[i], nums[j], nums[k]});
//                        index++;
//                    }
//                }
//            }
//
//        }
//        return ans;

    }

    public static List<List<Integer>> threeSum_official(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        // 枚举 a
        for (int first = 0; first < n; ++first) {
            // 需要和上一次枚举的数不相同
            if (first > 0 && nums[first] == nums[first - 1]) {
                continue;
            }
            // c 对应的指针初始指向数组的最右端
            int third = n - 1;
            int target = -nums[first];
            // 枚举 b
            for (int second = first + 1; second < n; ++second) {
                // 需要和上一次枚举的数不相同
                if (second > first + 1 && nums[second] == nums[second - 1]) {
                    continue;
                }
                // 需要保证 b 的指针在 c 的指针的左侧
                while (second < third && nums[second] + nums[third] > target) {
                    --third;
                }
                // 如果指针重合，随着 b 后续的增加
                // 就不会有满足 a+b+c=0 并且 b<c 的 c 了，可以退出循环
                if (second == third) {
                    break;
                }
                if (nums[second] + nums[third] == target) {
                    List<Integer> list = new ArrayList<Integer>();
                    list.add(nums[first]);
                    list.add(nums[second]);
                    list.add(nums[third]);
                    ans.add(list);
                }
            }
        }
        return ans;
    }

    public static void main(String args[]){
//        int[] nums = new int[]{1,0,-1,2,-3,4};
        int[] nums = new int[]{0,0,0};
        ArrayList res = threeSum(nums);
        System.out.println(res);
    }
}
