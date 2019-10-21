package com.mkdlp.algorithm.date20191016.longestcommonprefix;

import java.util.HashMap;
import java.util.Map;

/**
* @description
* 编写一个函数来查找字符串数组中的最长公共前缀。
* 如果不存在公共前缀，返回空字符串 ""。
*
* 示例 1:
*
* 输入: ["flower","flow","flight"]
* 输出: "fl"
* 示例 2:
*
* 输入: ["dog","racecar","car"]
* 输出: ""
* 解释: 输入不存在公共前缀。
* 说明:
*
* 所有输入只包含小写字母 a-z 。
*/
public class LongestCommonPrefix {

    public static void main(String[] args) {
        String[] strs={"flower","flow","flight","flows"};
//        String[] strs={"","b"};
        System.out.println(solution3(strs));
    }

    /**
    * @description 自我暴力解法
    * @param strs
    * @author  mkdlp
    * @date  2019/10/17 11:09
    * @return
    */
    public static String solution(String[] strs){
        String final_str="";
        Map<Integer,String> stor=new HashMap<>(16);
        String currentString="";
        int compareLength=-1;
        for(String str:strs){
            if(compareLength==-1){
                compareLength=str.length();
                currentString=str;
                final_str=str;
                continue;
            }else{
                compareLength= compareLength<str.length() ? compareLength:str.length();
                char[] old_arr=currentString.toCharArray();
                char[] new_arr=str.toCharArray();
                StringBuilder sb=new StringBuilder();
                for(int i=0;i<compareLength;i++){
                    if(old_arr[i]==new_arr[i]){
                        sb.append(old_arr[i]);
                    }else{
                        compareLength=i;
                        break;
                    }
                }
                final_str=sb.toString();
            }
        }
        return final_str;
    }
    /**
    * @description 水平扫描法
    * @param strs
    * @author  mkdlp
    * @date  2019/10/17 11:09
    * @return
    */
    public static String solution1(String[] strs){
        if(strs.length==0){
            return "";
        }
        String final_str=strs[0];
        for(int i=1;i<strs.length;i++){
            while(!strs[i].startsWith(final_str)){
                if(!"".equals(final_str) && !"".equals(strs[i])){
                    final_str = final_str.substring(0, final_str.length() - 1);
                    if (final_str.isEmpty()) {
                        return "";
                    }
                }else{
                    return "";
                }
            }
        }
        return final_str;
    }

    /**
    * @description 水平扫描优化版
    * @param strs
    * @author  mkdlp
    * @date  2019/10/17 11:09
    * @return
    */
    public static String solution2(String[] strs){
        if(null == strs || strs.length==0){
            return "";
        }

        for(int i=0;i<strs[0].length();i++){
            char c=strs[0].charAt(i);
            for(int j=1;j<strs.length;j++){
                if(i ==strs[j].length() || c!=strs[j].charAt(i)){
                    return strs[0].substring(0,i);
                }
            }
        }
        return strs[0];
    }

    public static String solution3(String[] strs){
        if(null == strs || strs.length==0){
            return "";
        }
        return longestCommonPrefix(strs,0,strs.length-1);
    }

    private static String longestCommonPrefix(String[] strs,int l,int r){
        if( l==r ){
            return strs[l];
        }else{
            int mid=(l + r ) / 2;
            String lcpLeft=longestCommonPrefix(strs,l,mid);
            String lcpRight=longestCommonPrefix(strs,mid+1,r);
            return commonPrefix(lcpLeft,lcpRight);
        }
    }

    private static String commonPrefix(String left,String right){
        int min= left.length() > right.length() ? right.length() : left.length();
        for(int i=0;i< min;i++){
            if(left.charAt(i) != right.charAt(i)){
                return left.substring(0, i);
            }
        }
        return left.substring(0, min);
    }

}
