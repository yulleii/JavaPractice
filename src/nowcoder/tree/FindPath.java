package nowcoder.tree;

import java.util.ArrayList;

/*
    输入一颗二叉树的根节点和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。
    路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
    (注意: 在返回值的list中，数组长度大的数组靠前)

 */
public class FindPath {
    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;
        public TreeNode(int val) {
            this.val = val;
        }

    }
    private static ArrayList<ArrayList<Integer>>a=new ArrayList<>();
    public static  void  FindPath(TreeNode root, int target){
        if(root ==null )return;
        ArrayList<Integer>sub=new ArrayList<>();
        process(root,target,0,sub);
        //return a;
    }

    private static void process(TreeNode root,int target,int curSum,ArrayList<Integer>sub){
        if(root ==null )return;
        sub.add(root.val);
        curSum+=root.val;
        if(curSum==target && root.left==null && root.right==null) {
            a.add(new ArrayList<Integer>(sub));
        }
        process(root.left,target,curSum,sub);
        process(root.right,target,curSum,sub);
        sub.remove(sub.size()-1);
    }

    public static void main(String[] args) {
        TreeNode head=new TreeNode(1);
        head.left=new TreeNode(2);
        head.left.left=new TreeNode(4);
        head.left.left.left=new TreeNode(1);
        head.left.right=new TreeNode(5);
        head.right=new TreeNode(3);
        head.right.left=new TreeNode(6);
        head.right.right=new TreeNode(7);
        FindPath(head,8);
        for(ArrayList<Integer> s:a){
            for(Integer b:s) System.out.print(b+" ");
            System.out.println();
        }
    }
}
