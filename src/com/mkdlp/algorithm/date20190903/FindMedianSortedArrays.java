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
        int[] nums1={1,2};
        int[] nums2={3,4};
        System.out.println(solution1(nums1,nums2));
        System.out.println(solution2(nums1,nums2));
        System.out.println(solution3(nums1,nums2));
    }

    public static double solution1(int[] nums1,int[] nums2){
        int[] nums;
        int m=nums1.length;
        int n=nums2.length;

        nums=new int[m+n];

        if(m==0){
            if(n%2==0){
                return(nums2[n/2-1]+nums2[n/2]) / 2.0;
            }else{
                return nums2[n/2];
            }
        }

        if(n==0){
            if(m%2==0){
                return(nums1[m/2-1]+nums1[m/2]) / 2.0;
            }else{
                return nums1[m/2];
            }
        }

        int count=0;
        int i=0,j=0;
        while(count !=(m+n)){
            if(i==m){
                while(j != n){
                    nums[count++] = nums2[j++];
                }
                break;
            }
            if(j==n){
                while(i != m){
                    nums[count++] = nums1[i++];
                }
                break;
            }
            if (nums1[i] < nums2[j]) {
                nums[count++] = nums1[i++];
            } else {
                nums[count++] = nums2[j++];
            }
        }

        if (count % 2 == 0) {
            return (nums[count / 2 - 1] + nums[count / 2]) / 2.0;
        } else {
            return nums[count / 2];
        }
    }

    public static double solution2(int[] nums1,int[] nums2){
        int m=nums1.length;
        int n=nums2.length;

        int len=m+n;

        int last=-1;
        int current=-1;

        int aStart=0;
        int bStart=0;

        for(int i=0;i<=len/2;i++){
            last=current;

            if(aStart<m && (bStart>=n || nums1[aStart]<nums2[bStart])){
                current=nums1[aStart++];
            }else{
                current=nums2[bStart++];
            }
        }

        if(len%2==0){
            return (current+last)/2.0;
        }else{
            return current;
        }
    }


    public static double solution3(int[] nums1,int[] nums2){
        int n = nums1.length;
        int m = nums2.length;
        int left = (n + m + 1) / 2;
        int right = (n + m + 2) / 2;
        //将偶数和奇数的情况合并，如果是奇数，会求两次同样的 k 。
        return (getKth(nums1, 0, n - 1, nums2, 0, m - 1, left) + getKth(nums1, 0, n - 1, nums2, 0, m - 1, right)) * 0.5;
    }

    private static int getKth(int[] nums1,int start1,int end1,int nums2[],int start2,int end2,int k){
        int len1=end1-start1+1;
        int len2=end2-start2+1;

        //让 len1 的长度小于 len2，这样就能保证如果有数组空了，一定是 len1
        if(len1>len2){
            return getKth(nums2,start2,end2,nums1,start1,end1,k);
        }
        if(len1==0){
            return nums2[start2+k-1];
        }
        if(k==1){
            return Math.min(nums1[start1], nums2[start2]);
        }

        int i=start1+Math.min(len1,k/2)-1;
        int j=start2+Math.min(len2,k/2)-1;

        if(nums1[i]>nums2[j]){
            return getKth(nums1,start1,end1,nums2,j+1,end2,k-(j-start2+1));
        }else{
            return getKth(nums1,i+1,end1,nums2,start2,end2,k-(i-start1+1));
        }
    }
}
