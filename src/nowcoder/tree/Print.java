package nowcoder.tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
public class Print {
    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int data) {
            this.value = data;
        }
    }

    public static void printPreOrder(Node root){
        if(root==null)
            return;
        System.out.print(root.value+" ");
        printPreOrder(root.left);
        printPreOrder(root.right);
    }

    public static void printInOrder(Node root){
        if(root == null)
            return;
        printInOrder(root.left);
        System.out.println(root.value);
        printInOrder(root.right);
    }

    public static void printPreOrderNoRecur(Node root){
        if(root!=null){
            Stack<Node>stack=new Stack<>();
            stack.push(root);
            Node head=null;
            while(!stack.isEmpty()){
                head=stack.pop();
                System.out.println(head.value);
                if(head.right!=null){
                    stack.push(head.right);
                }
                if(head.left!=null){
                    stack.push(head.left);
                }
            }
        }
        System.out.println();
    }

    public static void printInOrderNoRecur(Node root){
        if(root!=null){
            Stack<Node>stack=new Stack<>();
            while(!stack.isEmpty() || root!=null){
                if(root!=null){
                    stack.push(root);
                    root=root.left;
                }else{
                    root=stack.pop();
                    System.out.println(root.value+" ");
                    root=root.right;
                }
            }
        }


    }

    public static void printPostOrderNoRecur(Node root){
        if(root!=null){
            Stack<Node>stack=new Stack<>();
            Stack<Node>stack1=new Stack<>();
            stack.push(root);
            while(!stack.isEmpty()){
                root=stack.pop();
                stack1.push(root);
                if(root.left!=null){
                    stack.push(root.left);
                }
                if(root.right!=null){
                    stack.push(root.right);
                }
            }
            while(!stack1.isEmpty()){
                System.out.print(stack1.pop().value+" ");
            }
        }
    }

    public static void posOrderUnRecur2(Node h) {
        System.out.print("pos-order: ");
        if (h != null) {
            Stack<Node> stack = new Stack<>();
            stack.push(h);
            Node c = null;
            while (!stack.isEmpty()) {
                c = stack.peek();
                if (c.left != null && h != c.left && h != c.right) {
                    stack.push(c.left);
                } else if (c.right != null && h != c.right) {
                    stack.push(c.right);
                } else {
                    System.out.print(stack.pop().value + " ");
                    h = c;
                }
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.left = new Node(-222222222);
        head.right = new Node(3);
        head.left.left = new Node(Integer.MIN_VALUE);
        head.right.left = new Node(55555555);
        head.right.right = new Node(66);
        head.left.left.right = new Node(777);
        printPostOrderNoRecur(head);
        Queue<Integer> q=new LinkedList<>();
    }
}
