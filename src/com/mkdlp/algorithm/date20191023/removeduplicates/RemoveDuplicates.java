package com.mkdlp.algorithm.date20191023.removeduplicates;

import java.util.ArrayList;
import java.util.List;

public class RemoveDuplicates {
    public static void main(String[] args) {
        int[] nums={1,1,2};
        System.out.println(solution1(nums));
    }
    public static int removeDuplicates(int[] nums) {
        if(nums==null){
            return 0;
        }
        List<Integer> list=new ArrayList<>();
        for(int i:nums){
            if(list.contains(i)){

            }else{
                list.add(i);
                System.out.println(i);
            }
        }
        return list.size();
    }
    public static int solution1(int[] nums) {
        if(nums.length==0){
            return 0;
        }
        int idx=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=nums[idx]){
                idx++;
                nums[idx]=nums[i];
            }
        }
        return idx+1;
    }

}
