package nowcoder.list;
/*
    反转单向链表
 */
public class ReverseList {
    public static class Node {
        public int value;
        public Node next;
        public Node(int data) {
            this.value = data;
        }
    }
    public static Node reverseList(Node head){
        if(head==null)return head;
        Node pre=null;
        Node next=null;
        while(head!=null){
            next=head.next;
            head.next=pre;
            pre=head;
            head=next;
        }
        return pre;
    }

    public static void main(String[] args) {
        Node head1 = new Node(1);
        head1.next = new Node(2);
        head1.next.next = new Node(3);
        head1.next.next.next = new Node(4);
        head1.next.next.next.next = new Node(5);
        head1.next.next.next.next.next = new Node(6);
        head1.next.next.next.next.next.next = new Node(7);
        Node head2= reverseList(head1);
        while(head2!=null) {System.out.println(head2.value);head2=head2.next;}
    }
}
