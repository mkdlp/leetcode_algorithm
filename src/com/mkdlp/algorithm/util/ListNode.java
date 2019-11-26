package com.mkdlp.algorithm.util;

public class ListNode {
    public int val;
    public ListNode next;
    public ListNode(int x) { val = x; }

    public void print(){
        System.out.print(val+"--->");
        while (next!=null){
            System.out.print(next.val+"--->");
            next=next.next;
        }
    }
}
