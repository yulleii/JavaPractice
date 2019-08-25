package nowcoder.tree;

public class MaxBST {
    public static void main(String[] args) {
        Node head=new Node(10);
        head.left=new Node(11);
        head.left.left=new Node(2);
        head.left.right=new Node(5);
        head.right=new Node(14);
        head.right.left=new Node(11);
        head.right.right=new Node(15);
        System.out.println(new MaxBST().getMaxBST(head).val);
    }
    public static class Node{
        public int val;
        public Node left;
        public Node right;
        public Node(int val){
            this.val=val;
        }
    }
    public class ReturnType{
        public Node maxBSTHead;
        public int maxBSTSize;
        public int min;
        public int max;
        public ReturnType(Node maxBSTHead,int maxBSTSize,int min,int max){
            this.maxBSTHead=maxBSTHead;
            this.maxBSTSize=maxBSTSize;
            this.min=min;
            this.max=max;
        }
    }
    public Node getMaxBST(Node head){
        return process(head).maxBSTHead;
    }
    public ReturnType process(Node X){
        if(X==null)return new ReturnType(
                null,0,
                Integer.MAX_VALUE,Integer.MIN_VALUE);
        ReturnType lData=process(X.left);
        ReturnType rData=process(X.right);
        int min=Math.min(X.val,Math.min(lData.min,rData.min));
        int max=Math.max(X.val,Math.max(lData.max,rData.max));
        int maxBSTSize=Math.max(lData.maxBSTSize,rData.maxBSTSize);
        Node maxBSTHead=lData.maxBSTSize>=rData.maxBSTSize?lData.maxBSTHead:rData.maxBSTHead;
        if(lData.maxBSTHead==X.left && rData.maxBSTHead==X.right
                && X.val<rData.min && X.val>lData.max){
            maxBSTSize+=lData.maxBSTSize+rData.maxBSTSize+1;
            maxBSTHead=X;
        }
        return new ReturnType(maxBSTHead,maxBSTSize,min,max);
    }

}
