package com.mkdlp.algorithm.date20191215.foursumcloset;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSumCloset {

    public static void main(String[] args) {
        int[] nums={0,0,0,0};
        System.out.println(solution(nums,0));
    }

    public static List<List<Integer>> solution(int[] nums,int target){
        Arrays.sort(nums);
        List<List<Integer>> res=new ArrayList<>();
        int a,b,c,d;
        int len=nums.length;
        if(len<4){
            return res;
        }

        for(a=0;a<=len-4;a++){
            if(a>0 && nums[a]==nums[a-1]){
                continue;
            }
            for(b=a+1;b<=len-3;b++){
                if(b>a+1 && nums[b]==nums[b-1]){
                    continue;
                }
                c=b+1;
                d=len-1;
                while (c<d){
                    if((nums[a]+nums[b]+nums[c]+nums[d])<target){
                        c++;
                    }else if((nums[a]+nums[b]+nums[c]+nums[d])>target){
                        d--;
                    }else{
                        res.add(Arrays.asList(nums[a],nums[b],nums[c],nums[d]));
                        while(c <d && nums[c+1]==nums[c]){
                            c++;
                        }
                        while(c <d && nums[d-1]==nums[d]){
                            d--;
                        }
                        c++;
                        d--;
                    }
                }
            }
        }
        return res;
    }
}
