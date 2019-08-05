package nowcoder.list;

public class SmallEqualBiggerInList {
    public static class Node {
        public int value;
        public Node next;
        public Node(int data) {
            this.value = data;
        }
    }
    //不使用辅助空间完成
    public static Node listPartition1(Node head,int val){
        if(head ==null)
            return head;
        Node small=null;
        Node smallEnd=null;
        Node equal=null;
        Node equalEnd=null;
        Node big=null;
        Node bigEnd=null;
        Node next=null;
        while(head!=null){
           next=head.next;
           head.next=null;
           if(head.value<val){
               if(small==null){
                   small=head;
                   smallEnd=head;
               }else{
                   smallEnd.next=head;
                   smallEnd=smallEnd.next;
               }
           }else if(head.value>val){
               if(big==null){
                   big=head;
                   bigEnd=head;
               }else{
                   bigEnd.next=head;
                   bigEnd=bigEnd.next;
               }
           }else{
               if(equal==null){
                   equal=head;
                   equalEnd=head;
               }else{
                   equal.next=head;
                   equalEnd=equalEnd.next;
               }
           }
           head=next;
        }

        if(smallEnd!=null){
            smallEnd.next=equal;
            equalEnd=equalEnd==null?smallEnd:equalEnd;
        }

        if(equalEnd!=null){
            equalEnd.next=big;
            bigEnd=bigEnd==null?equalEnd:bigEnd;
        }
        return small!=null?small:equal!=null?equal:big;
    }

    public static Node listPartition2(Node head,int val){
       if(head==null)
           return null;
       int count=0;
       Node cur=head;
       while(cur!=null){
           count++;
           cur=cur.next;
       }
       Node[]nodes=new Node[count];
       cur=head;
       for(int i=0;i<count;i++){
           nodes[i]=cur;
           cur=cur.next;
       }
       arrPartition(nodes,val);
       head=cur=nodes[0];
       for(int i=1;i<count;i++){
           cur.next=nodes[i];
           cur=cur.next;
       }
       cur.next=null;
       return head;
    }

    public static void arrPartition(Node[]nodes,int val){
        int small=-1;
        int big=nodes.length;
        int equal=0;
        while(equal<big){
            if(nodes[equal].value==val)equal++;
            else if(nodes[equal].value<val){
                swap(nodes,++small,equal++);
            }else{
                swap(nodes,--big,equal);
            }
        }
    }

    public static void swap(Node[]nodes,int i,int j){
        Node tmp=nodes[i];
        nodes[i]=nodes[j];
        nodes[j]=tmp;
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
        Node head1 = new Node(7);
        head1.next = new Node(9);
        head1.next.next = new Node(1);
        head1.next.next.next = new Node(8);
        head1.next.next.next.next = new Node(5);
        head1.next.next.next.next.next = new Node(2);
        head1.next.next.next.next.next.next = new Node(5);
        printLinkedList(head1);
        head1 = listPartition1(head1, 5);
        printLinkedList(head1);
    }


}
