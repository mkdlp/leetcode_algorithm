package com.mkdlp.algorithm.leetcode.Q39;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Solution {

    private List<List<Integer>> res=new ArrayList<>();
    int[] candidates;
    int len;

    public List<List<Integer>> combinationSum(int[] candidates,int target){
        int len=candidates.length;
        if(len==0){
            return res;
        }
        this.len=len;
        Arrays.sort(candidates);
        this.candidates=candidates;
        findCombinationSum(target,0,new Stack<Integer>());
        return res;
    }

    public void findCombinationSum(int residue,int start,Stack<Integer> pre){
        if(residue==0){
            res.add(new ArrayList<>(pre));
            return;
        }
        for(int i=start;i<len && residue>=candidates[i];i++){
            pre.add(candidates[i]);
            findCombinationSum(residue-candidates[i],i,pre);
            pre.pop();
        }
    }

    public static void main(String[] args) {
        int[] data={2,3,6,7};
        Solution solution=new Solution();
        System.out.println(solution.combinationSum(data,7));
    }

}
