package question;

import java.awt.print.Printable;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/*
从上往下打印出二叉树的每个节点，同层节点从左至右打印。
 */
public class Question32 {
    public static void main(String[] args) {
        Question7 question7=new Question7();
        TreeNode treeNode=question7.reConstructBinaryTree(new int[]{},new int[]{});
        List<Integer>l=new Question32().PrintFromTopToBottom(null);
        for(int i:l)
            System.out.print(i);
    }

    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        if(root==null)
            return null;
        ArrayList<Integer>l=new ArrayList<>();
        Queue<TreeNode> q=new java.util.LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            TreeNode n=q.poll();
            l.add(n.val);
            if(n.left!=null)
                q.add(n.left);
            if(n.right!=null)
                q.add(n.right);
        }
        return l;
    }
}
