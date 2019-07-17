package tree;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree {
    public Node root;
    public class Node{
        public int value;
        public Node left;
        public Node right;
        public Node(int data){
            this.left=null;
            this.right=null;
            this.value=data;
        }
    }
    public BinaryTree(int[]array,int index){
        root=createBiTree(array,index);
    }

    public Node createBiTree(int[]array,int index){
        Node treeNode=null;
        if(index<array.length){
            treeNode=new Node(array[index]);
            treeNode.left=createBiTree(array,2*index+1);
            treeNode.right=createBiTree(array,2*index+2);
        }
        return treeNode;
    }

    public void preOrderRecur(Node head){
        if(head==null){
            return;
        }
        System.out.println(head.value+" ");
        preOrderRecur(head.left);
        preOrderRecur(head.right);
    }

    public void inOrderRecur(Node head){
        if(head==null){
            return;
        }
        inOrderRecur(head.left);
        System.out.print(head.value+" ");
        inOrderRecur(head.right);
    }

    public void postOrderRecur(Node head){
        if(head==null){
            return;
        }
        postOrderRecur(head.left);

        postOrderRecur(head.right);
        System.out.print(head.value+" ");

    }

    public void layerTranverse(Node head){
        if(head ==null)
            return;
        Queue<Node>q=new LinkedList<>();
        q.add(head);
        while(!q.isEmpty()){
            Node n=q.poll();
            System.out.print(n.value);
            System.out.print(" ");
            if(n.left!=null)
                q.add(n.left);
            if(n.right!=null)
                q.add(n.right);
        }
    }

}
