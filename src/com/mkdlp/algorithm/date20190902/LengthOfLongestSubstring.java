package com.mkdlp.algorithm.date20190902;

import java.util.HashMap;
import java.util.Map;

public class LengthOfLongestSubstring {

    public static void main(String[] args) {
        String s="pwwkew";
        System.out.println(LengthOfLongestSubstring.solution(s));
    }

    public static int solution(String s){
        int n=s.length();
        int ans=0;

        Map<Character,Integer> map=new HashMap<>();

        for(int end=0,start=0;end<n;end++){
            char alpha=s.charAt(end);
            if(map.containsKey(alpha)){
                start=Math.max(map.get(alpha),start);
            }
            ans=Math.max(ans,end-start+1);
            map.put(s.charAt(end),end+1);
        }
        return ans;
    }
}
