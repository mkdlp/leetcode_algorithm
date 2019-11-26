package com.mkdlp.algorithm.date20190904;

import java.util.ArrayList;
import java.util.List;

public class Solution1 {

    public static void main(String[] args) {
        System.out.println(solution("ababa"));
    }

    public static String solution(String s){
        String ans="";
        int max=0;
        if(isPalindromic(s)){
            return s;
        }
        for(int i=0;i<s.length();i++){
            for(int j=i+1;j<s.length();j++){
                String sub=s.substring(i,j);
                boolean isP=isPalindromic(sub);
                if(isP){
                    if(sub.length()>max){
                        ans=sub;
                        max=sub.length();
                    }
                }
            }
        }
        return ans;
    }

    public static boolean isPalindromic(String s){
        int len=s.length();

        for(int i=0;i<len/2;i++){
            if(s.charAt(i)!=s.charAt(len-i-1)){
                return false;
            }
        }
        return true;
    }
}
