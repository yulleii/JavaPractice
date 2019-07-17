package question;

/*
    给定一个二叉树和其中的一个结点，请找出中序遍历顺序的下一个结点并且返回。
    注意，树中的结点不仅包含左右子结点，同时包含指向父结点的指针。
 */
public class Question8 {
    public Node getNextNode(Node node){
        if(node==null)
            return node;
        if(node.right!=null)
            return leftMost(node.right);
        else{
            Node parent=node.parent;
            while(parent!=null && parent.left!=node){
                node=parent;
                parent=node.parent;
            }
            return parent;
        }
    }

    public Node leftMost(Node node){
        if(node==null)
            return node;
        while(node.left!=null)
            node=node.left;
        return node;
    }
}
class Node{
    public int value;
    public Node left;
    public Node right;
    public Node parent;
    public Node(int data){
        value=data;
    }
}