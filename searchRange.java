
import java.util.ArrayList;
import java.util.List;

/**
 * 34. Find First and Last Position of Element in Sorted Array
 * Given an array of integers nums sorted in non-decreasing order, find the starting and ending position of a given target value.
 * If target is not found in the array, return [-1, -1].
 * You must write an algorithm with O(log n) runtime complexity.
 * solution nums:3747_6
 * label:
 */



class searchRange {
    public static int[] searchRange(int[] nums, int target) {
        int[] ans = new int[]{-1,-1};
        int len = nums.length;
        int cnt = 0;
        if(len==0){
            return ans;
        }
        for(int i=0;i<len;i++){
            if(nums[i] == target){
                ans[1]=i;
                cnt++;
            }
            if(nums[i] > target){
                break;
            }
        }
        if(ans[1]!=-1){
            ans[0] = ans[1]-cnt+1;
        }
        return ans;
    }

    public static void main(String args[]){
        int[] nums = new int[]{1,2,3,4};
        int target = 2;
        int[] res = searchRange(nums,target);
        System.out.println(res);
    }
}
