package com.mkdlp.algorithm.date20190828;

import java.util.HashMap;
import java.util.Map;

/**
* @description 两数之和
* @author  mkdlp
* @date  2019/8/28 14:12
* 描述：
* 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
*
* 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
*
* 示例:
*
* 给定 nums = [2, 7, 11, 15], target = 9
*
* 因为 nums[0] + nums[1] = 2 + 7 = 9
* 所以返回 [0, 1]
*/
public class SumOfTwoNumbers {

    public static void main(String[] args) {
        int[] nums={2, 7, 11, 15};
        int target=13;
        int[] result=solution.twoSum(nums,target);
        for(int r:result){
            System.out.println(r);
        }
        int[] result2=solution.twoSum2(nums,target);
        for(int r:result2){
            System.out.println(r);
        }
    }
}
class solution{

    /**
    * @description 第一种方式 暴力循坏
    * @param nums
     * @param target
    * @author  mkdlp
    * @date  2019/8/28 14:14
    * @return
    */
    public static int[] twoSum(int[] nums,int target){
        for(int i=0;i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++){
                if(nums[i] == target - nums[j]){
                    return new int[]{i,j};
                }
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }
    /**
    * @description
    * @param nums
     * @param target
    * @author  mkdlp
    * @date  2019/8/28 15:22
    * @return
    * 标签：哈希映射
    * 这道题本身如果通过暴力遍历的话也是很容易解决的，时间复杂度在 O(n2)
    * 由于哈希查找的时间复杂度为 O(1)，所以可以利用哈希容器 map 降低时间复杂度
    * 遍历数组 nums，i 为当前下标，每个值都判断map中是否存在 target-nums[i] 的 key 值
    * 如果存在则找到了两个值，如果不存在则将当前的 (nums[i],i) 存入 map 中，继续遍历直到找到为止
    * 如果最终都没有结果则抛出异常
    * 时间复杂度：O(n)
    */
    public static int[] twoSum2(int[] nums,int target){
        Map<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(map.containsKey(target-nums[i])){
                return new int[]{map.get(target-nums[i]),i};
            }
            map.put(nums[i],i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }
}