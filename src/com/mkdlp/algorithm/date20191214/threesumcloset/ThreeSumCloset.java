package com.mkdlp.algorithm.date20191214.threesumcloset;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和。假定每组输入只存在唯一答案。
 *
 * 例如，给定数组 nums = [-1，2，1，-4], 和 target = 1.
 *
 * 与 target 最接近的三个数的和为 2. (-1 + 2 + 1 = 2).
 */
public class ThreeSumCloset {

    public static void main(String[] args) {
        int[] nums={0,2,1,-3};
        System.out.println(solution1(nums,1));
    }

    public static int solution1(int[] nums,int target){
        List<List<Integer>> res=new ArrayList<>();
        Arrays.sort(nums);

        int finalResult=0;
        int dis=Integer.MAX_VALUE;

        for(int i=0;i<nums.length-2;i++){
            int left=i+1;
            int right=nums.length-1;
            if(i>0 && nums[i]==nums[i-1]){
                continue;
            }
            while(left<right){
                int sum=nums[i]+nums[left]+nums[right];
                int ture_result=target-sum;
                int abs_result=Math.abs(ture_result);
                if(ture_result==0){
                    return target;
                }else if(ture_result>0){
                    left++;
                }else if(ture_result<0){
                    right--;
                }
                if(abs_result<dis){
                    dis=abs_result;
                    finalResult=sum;
                }
            }
        }
        return finalResult;
    }
}
