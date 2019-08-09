package designmode;

import java.util.*;

public class Solution {
    public static ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>>arrayLists=new ArrayList<>();
        if(pRoot==null)
            return null;
        Deque<TreeNode>dq=new LinkedList<>();
        boolean lr=true;
        TreeNode last=pRoot;
        TreeNode nLast=null;
        dq.offerFirst(pRoot);
        ArrayList<Integer> list=new ArrayList<>();
        while(!dq.isEmpty()){
            if(lr){
                pRoot=dq.pollFirst();
               // System.out.print(pRoot.val);
                list.add(pRoot.val);
                if(pRoot.left!=null){
                    dq.offerLast(pRoot.left);
                    nLast=nLast==null?pRoot.left:nLast;
                }
                if(pRoot.right!=null){
                    dq.offerLast(pRoot.right);
                    nLast=nLast==null?pRoot.right:nLast;
                }
            }else{
                pRoot=dq.pollLast();
                //System.out.print(pRoot.val);
                list.add(pRoot.val);
                if(pRoot.right!=null){
                    dq.offerFirst(pRoot.right);
                    nLast=nLast==null?pRoot.right:nLast;
                }
                if(pRoot.left!=null){
                    dq.offerFirst(pRoot.left);
                    nLast=nLast==null?pRoot.left:nLast;
                }
            }
            if(pRoot == last && !dq.isEmpty()){
                System.out.println();
                lr=!lr;
                last=nLast;
                nLast=null;
                arrayLists.add(list);
                list=new ArrayList<>();
            }
        }
        arrayLists.add(list);
        return arrayLists;
    }

    public static void main(String[] args) {
        Queue<Integer>queue=new LinkedList<>();
        TreeNode head=new TreeNode(1);
        head.left=new TreeNode(2);
        head.right=new TreeNode(3);
//        head.left.left=new TreeNode(4);
//        head.left.right=new TreeNode(5);
        head.right.left=new TreeNode(6);
        head.right.right=new TreeNode(7);
        ArrayList<ArrayList<Integer>> lists=Print(head);
        System.out.println(lists);
    }

}
class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}
class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }

}
