package question;
/*
    从根结点到叶结点依次经过的结点（含根、叶结点）形成树的一条路径，最长路径的长度为树的深度。
 */
public class Question55 {
    public static void main(String[] args) {
        Question7 question7=new Question7();
        TreeNode treeNode=question7.reConstructBinaryTree(new int[]{1,2,4,7,3,5,6,8},new int[]{4,7,2,1,5,3,8,6});
        System.out.println(new Question55().Fibonacci(8));
    }

    public int TreeDepth(TreeNode root) {
        return root == null ? 0 : 1 + Math.max(TreeDepth(root.left), TreeDepth(root.right));
    }

    public int getHeight(TreeNode h,int l){
        if(h==null)
            return l;
        return Math.max(getHeight(h.left,l+1),getHeight(h.right,l+1));
    }


    //关于递归的几个小练习
    public int sum(int i){
        if(i==1)
            return 1;
        return sum(i-1)+i;
    }

    public int factorial(int i){
        if(i==1)
            return 1;
        return factorial(i-1)*i;
    }

    public void hannoi(int n,char A,char B,char C){
        if(n==1)
            System.out.println(A+"-->"+C);
        else{
            hannoi(n-1,A,C,B);
            System.out.println(A+"-->"+C);
            hannoi(n-1,B,A,C);
        }
    }

    public int Fibonacci(int n){
        if(n==1 || n==2)
            return 1;
        return Fibonacci(n-1)+Fibonacci(n-2);
    }
}
