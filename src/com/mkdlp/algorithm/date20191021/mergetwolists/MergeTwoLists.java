package com.mkdlp.algorithm.date20191021.mergetwolists;

import com.mkdlp.algorithm.util.ListNode;

/**
* @description
* @author  mkdlp
* @date  2019/10/23 11:51
 * 将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
 *
 * 示例：
 *
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
*/
public class MergeTwoLists {

    public static void main(String[] args) {
        ListNode l1=new ListNode(1);
        ListNode l2=new ListNode(4);
        ListNode l3=new ListNode(5);
        l1.next=l2;
        l2.next=l3;
        ListNode l4=new ListNode(2);
        ListNode l5=new ListNode(3);
        ListNode l6=new ListNode(6);
        l4.next=l5;
        l5.next=l6;
//        ListNode ln=mergeTwoLists(l1,l4);
//        ListNode ln=solution1(l1,l4);
        ListNode ln=solution2(l1,l4);
        ln.print();
    }

    /**
    * @description 自我暴力解法
    * @param l1
     * @param l2
    * @author  mkdlp
    * @date  2019/10/23 11:52
    * @return
    */
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1==null){
            if(l2!=null){
                return l2;
            }
        }
        if(l2==null){
            if(l1!=null){
                return l1;
            }
        }
        ListNode l3=null;
        ListNode startNode=null;
        while(l1!=null && l2!=null){
            if(l1.val>l2.val){
                if(l3==null){
                    l3=new ListNode(l2.val);
                    startNode=l3;
                }else{
                    l3.next=new ListNode(l2.val);
                    l3=l3.next;
                }

                l2=l2.next;
            }else{
                if(l3==null){
                    l3=new ListNode(l1.val);
                    startNode=l3;
                }else{
                    l3.next=new ListNode(l1.val);
                    l3=l3.next;
                }
                l1=l1.next;
            }

        }
        if(l1!=null){
            l3.next=l1;
        }else if(l2!=null){
            l3.next=l2;
        }
        return startNode;
    }

    /**
    * @description 递归解法
    * @param l1
     * @param l2
    * @author  mkdlp
    * @date  2019/10/23 11:52
    * @return
    */
    public static ListNode  solution1(ListNode l1,ListNode l2){
        if(l1==null){
            return l2;
        }

        if(l2==null){
            return l1;
        }
        if(l1.val<l2.val){
            l1.next=solution1(l1.next,l2);
            return l1;
        }else{
            l2.next=solution1(l1,l2.next);
            return l2;
        }
    }

    /**
    * @description 迭代解法
    * @param l1
     * @param l2
    * @author  mkdlp
    * @date  2019/10/23 11:52
    * @return
    */
    public static ListNode solution2(ListNode l1,ListNode l2){
        ListNode preHead=new ListNode(-1);
        ListNode prev=preHead;
        while(l1!=null && l2!=null){
            if(l1.val>l2.val){
                prev.next=l2;
                l2=l2.next;
            }else{
                prev.next=l1;
                l1=l1.next;
            }
            prev=prev.next;
        }
        prev.next= l1 == null ? l2:l1;
        return preHead.next;
    }
}
