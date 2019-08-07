package nowcoder.tree;

public class SuccessorNode {
    public static class Node {
        public int value;
        public Node left;
        public Node right;
        public Node parent;
        public Node(int data) {
            this.value = data;
        }
    }

    public static Node next(Node head){
        if(head ==null)
            return head;
        if(head.right!=null){
            return leftMost(head.right);
        }else{
            Node parent=head.parent;
            while(parent!=null && parent.left!=head){
                head=parent;
                parent=head.parent;
            }
            return parent;
        }
    }

    public static Node leftMost(Node head){
        if(head==null)
            return head;
        while(head.left!=null){
            head=head.left;
        }
        return head;
    }
}
