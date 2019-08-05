package question;

import tree.BinaryTree;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
    /*
    题目描述：根据二叉树的前序遍历和中序遍历的结果，重建出该二叉树。
    假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
     */
public class Question7 {
    public static void main(String[] args) {
        Question7 question7=new Question7();
        TreeNode treeNode=question7.reConstructBinaryTree(new int[]{1,2,4,7,3,5,6,8},new int[]{4,7,2,1,5,3,8,6});
        TreeNode.layerTranverse(treeNode);
//        int[]arrayqueuestack=question7.getPosArray(new int[]{1,2,4,7,3,5,6,8},new int[]{4,7,2,1,5,3,8,6});
//        for(int a:arrayqueuestack)
//            System.out.println(a);
    }

    private Map<Integer,Integer> indexForInOrders=new HashMap<>();
    public  TreeNode reConstructBinaryTree(int[] pre,int[] in) {
        for(int i=0;i<in.length;i++){
            indexForInOrders.put(in[i],i);
        }
        return reConstructBinaryTree(pre,0,pre.length-1,0);
    }
    public  TreeNode  reConstructBinaryTree(int[] pre,int preL,int preR,int inL){
        if(preL>preR)
            return null;
        TreeNode root=new TreeNode(pre[preL]);
        int inIndex=indexForInOrders.get(root.val);
        int leftTreeSize=inIndex-inL;
        root.left=reConstructBinaryTree(pre,preL+1,preL+leftTreeSize,inL);
        root.right=reConstructBinaryTree(pre,preL+leftTreeSize+1,preR,inL+leftTreeSize+1);
        return root;
    }

    public int[] getPosArray(int[]pre,int[]in){
        if(pre==null || in==null)
            return null;
        int len=pre.length;
        int[]pos=new int[len];
        for(int i=0;i<len;i++)
            indexForInOrders.put(in[i],i);
        setPos(pre,0,len-1,0,pos,len-1);
        return pos;
    }
    public int setPos(int[]pre,int pi,int pj,int inL,int[]s,int si){
        if(pi>pj)
            return si;
        s[si--]=pre[pi];
        int i=indexForInOrders.get(pre[pi]);
        int leftTreeSize=i-inL;
        si=setPos(pre,pi+leftTreeSize+1,pj,inL+leftTreeSize+1,s,si);
        return setPos(pre,pi+1,pi+leftTreeSize,inL,s,si);
    }
}
class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x){
        val=x;
    }

    public static void layerTranverse(TreeNode head){
        if(head==null)
            return;
        Queue<TreeNode> q=new LinkedList<>();
        q.add(head);
        while(!q.isEmpty()){
            TreeNode n=q.poll();
            System.out.print(n.val);
            System.out.print(" ");
            if(n.left!=null)
                q.add(n.left);
            if(n.right!=null)
                q.add(n.right);
        }
    }
}