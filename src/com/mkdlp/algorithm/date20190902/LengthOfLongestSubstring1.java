package com.mkdlp.algorithm.date20190902;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LengthOfLongestSubstring1 {

    public static void main(String[] args) {
        System.out.println(LengthOfLongestSubstring1.solution("abcabcbb"));
        System.out.println(LengthOfLongestSubstring1.solution2("abcabcbb"));
    }

    public static  int solution(String s){
        int n=s.length();
        int ans=0;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                if(allUnique(s,i,j)){
                    ans=Math.max(ans, j - i);
                }
            }
        }
        return ans;
    }

    public static boolean  allUnique(String s,int start,int end){
        Set<Character> set=new HashSet<>();

        for(int i=start;i<end;i++){
            Character c=s.charAt(i);
            if(set.contains(c)){
                return false;
            }
            set.add(c);
        }
        return true;
    }

    public static int solution2(String s){
        int n=s.length();
        int ans=0;
        Map<Character,Integer> map=new HashMap<>();
        for(int end=0,start=0;end<n;end++){
            char ch=s.charAt(end);
            if(map.containsKey(ch)){
                start=Math.max(map.get(ch),start);
            }
            ans=Math.max(end-start+1,ans);
            map.put(ch,end+1);
        }
        return ans;
    }
}