package nowcoder.list;

import java.util.Stack;

public class IsPalindromeList {
    public static class Node {
        public int value;
        public Node next;

        public Node(int data) {
            this.value = data;
        }
    }
    // need n/2 extra space
    public static boolean isPalindrome1(Node head){
        if (head == null || head.next == null) {
            return true;
        }
        Node slow=head.next;
        Node quick=head;
        while(quick.next!=null && quick.next.next!=null){
            slow=slow.next;
            quick=quick.next.next;
        }
        Stack<Node> stack=new Stack<>();
        while(slow!=null){
            stack.push(slow);
            slow=slow.next;
        }

        while(!stack.isEmpty()){
            if(head.value!=stack.pop().value)
                return false;
            head=head.next;
        }
        return true;
    }

    public static boolean isPalindrome2(Node head){
        if (head == null || head.next == null) {
            return true;
        }
        Node n2=head;
        Node n1=head;
        while(n2.next!=null && n2.next.next!=null){
            n1=n1.next;
            n2=n2.next.next;
        }
        n2=n1.next;
        n1.next=null;
        Node n3;
        while(n2!=null){
            n3=n2.next;
            n2.next=n1;
            n1=n2;
            n2=n3;
        }
        n3=n1;//尾部节点
        n2=head;
        boolean res=true;
        while(n2!=null && n1!=null){
            if(n1.value!=n3.value){
                res=false;
                break;
            }
            n1=n1.next;
            n2=n2.next;
        }
        n1=n3.next;
        n3.next=null;
        while(n1!=null){
            n2=n1.next;
            n1.next=n3;
            n3=n1;
            n1=n2;
        }
        return res;

    }
    public static void printLinkedList(Node node) {
        System.out.print("Linked List: ");
        while (node != null) {
            System.out.print(node.value + " ");
            node = node.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Node head = null;
        head = new Node(1);
        head.next = new Node(1);
        head.next.next = new Node(3);
        head.next.next.next = new Node(2);
        head.next.next.next.next = new Node(1);
        printLinkedList(head);
        System.out.print(isPalindrome2(head) + " | ");
        printLinkedList(head);
        System.out.println("=========================");
    }

}
