package com.mkdlp.algorithm.util;

/**
 * 二分查找的模板
 */
public class BinarySearchTemplate {


    public int template1(int[] nums,int target){
        //设置左边界
        int left=0;

        //设置有边界
        int right=nums.length;

        if(right==0){
            return 0;
        }


        while(left<right){
            /**
             * 获取中位数的方式
             * 1.int mid=(left+right)/2;
             *  当left和right过大时很有可能超过 int 类型能表示的最大值，即整型溢出，
             * 2.int mid = left + (right - left) / 2 ;
             *  在right很大、left是负数且很小的时候，right-left也有可能超过int类型能表示的最大值，
             *  只不过一般情况下 left 和 right 表示的是数组索引值，left 是非负数，因此 right - left 溢出的可能性很小。
             * 3.最好的方式 int mid=(left+right) >>> 1;
             *  在left和right还是很大时，还是会发生整型溢出，会变成负数，如果此时除以2结果还是不对，
             *  但是经过无符号位右移，可以得到不溢出情况下的正确的结果。
             */
            int mid=(left+right) >>> 1;

            if(nums[mid]<target){
                left=mid+1;
            }else{
                right=mid;
            }
        }
        return left;
    }

    public int template2(int[] nums,int target){
        int len=nums.length;

        if(len==0){
            return -1;
        }

        if(nums[len-1]<target){
            return len;
        }

        int left=0;

        int right=len-1;

        while(left<right){
            int mid=(left+right) >>> 1;

            if(nums[mid]<target){
                left=mid+1;
            }else{
                right=mid;
            }
        }
        return right;
    }
}
