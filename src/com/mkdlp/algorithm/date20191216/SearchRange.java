package com.mkdlp.algorithm.date20191216;
/**
 * 功能描述:
 * 〈〉
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 *
 * 你的算法时间复杂度必须是 O(log n) 级别。
 *
 * 如果数组中不存在目标值，返回 [-1, -1]。
 *
 * 示例 1:
 *
 * 输入: nums = [5,7,7,8,8,10], target = 8
 * 输出: [3,4]
 * 示例 2:
 *
 * 输入: nums = [5,7,7,8,8,10], target = 6
 * 输出: [-1,-1]
 * @author : mkdlp
 * @date : since 2019/12/16 13:11
 */
public class SearchRange {

    public static void main(String[] args) {
//        int[] nums = {5,7,7,8,8,10};
        int[] nums = {1};
        int[] res=searchRange(nums,1);
        System.out.print("start:"+res[0]+" to end:"+res[1]);
    }

    public static int[] searchRange(int[] nums, int target) {
        int[] res={-1,-1};
        int len=nums.length;
        if(len<=0){
            return res;
        }
        if(nums[0]>target){
            return res;
        }
        if(nums[len-1]<target){
            return res;
        }

        int left=0;
        int right=len-1;

        while(left<=right){
            int mid=(left+right) >>> 1;

            if(nums[mid]==target){
                int lr=mid;
                int rr=mid;
                while(lr > 0 && nums[lr-1]==target){
                    lr--;
                }
                while(rr < len-1 && nums[rr+1]==target){
                    rr++;
                }
                res= new int[]{lr,rr};
                break;
            }else if(nums[mid]>target){
                right=mid-1;
            }else{
                left=mid+1;
            }
        }
        return res;
    }
}
