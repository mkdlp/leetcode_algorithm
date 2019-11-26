package com.mkdlp.algorithm.date20190903;

/**
* @description
* @author  mkdlp
* @date  2019/9/3 18:25
* 给定两个大小为 m 和 n 的有序数组 nums1 和 nums2。
*
* 请你找出这两个有序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
*
* 你可以假设 nums1 和 nums2 不会同时为空。
*
* 示例 1:
*
* nums1 = [1, 3]
* nums2 = [2]
*
* 则中位数是 2.0
* 示例 2:
*
* nums1 = [1, 2]
* nums2 = [3, 4]
*
* 则中位数是 (2 + 3)/2 = 2.5
*/
public class FindMedianSortedArrays {

    public static void main(String[] args) {
        int[] nums1={1,3};
        int[] nums2={2};
        System.out.println(solution1(nums1,nums2));

        nums1=new int[]{1,2};
        nums2=new int[]{3,4};
        System.out.println(solution2(nums1,nums2));
    }

    public static double solution1(int[] nums1,int[] nums2){
        int m=nums1.length;
        int n= nums2.length;

        int nums[]=new int[m+n];

        if(m==0){
            if(n%2==0){
                return (nums2[n/2-1]+nums2[n/2])/2;
            }else{
                return nums2[n/2];
            }
        }

        if(n==0){
            if(m%2==0){
                return (nums1[m/2-1]+nums2[m/2])/2;
            }else{
                return nums1[m/2];
            }
        }

        int count=0;
        int i=0;
        int j=0;

        while(count != (m+n)){
            if(i==m){
                while(j!=n){
                    nums[count++]=nums2[j++];
                }
                break;
            }

            if(j==n){
                if(i!=m){
                    while(i!=m){
                        nums[count++]=nums1[i++];
                    }
                }
                break;
            }

            if(nums1[i]<nums2[j]){
                nums[count++]=nums1[i++];
            }else{
                nums[count++]=nums2[j++];
            }
        }

        if(count%2==0){
            return (nums[count/2-1]+nums[count/2])/2.0;
        }else{
            return nums[count/2];
        }
    }


    public static double solution2(int[] nums1,int[] nums2){
        int m=nums1.length;
        int n=nums2.length;
        int len=m+n;

        int current=-1;
        int last=-1;

        int idx_a=0;
        int idx_b=0;

        for(int i=0;i<=len/2;i++){
            last=current;
            if(idx_a <m && (idx_b>=n || nums1[idx_a]<nums2[idx_b])){
                current=nums1[idx_a++];
            }else{
                current=nums2[idx_b++];
            }
        }

        if (len%2 == 0){
            return (last + current) / 2.0;
        }else{
            return current;
        }
    }
}
