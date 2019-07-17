package oop;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Test1 {
    public static void main(String[] args) {
        Node head=null;
        Node pre=null;

        int[] numbers=new int[]{3,2,4,8,9,10};
        for(int i=0;i<numbers.length;i++) {
            Node node1 = new Node(numbers[i]);
            if (head == null) {
                head = node1;
            }
            if (pre != null) {
                pre.next = node1;
            }
            pre = node1;
        }
        System.out.println(partialReverse(head,-1,6));
    }

    public static Node partialReverse(Node head,int m,int n){
        int len=0;

        Node node=head;
        while(node.next!=null){
            len++;
            node=node.next;
        }
        if(m>n || m<1 || n>len)
            return head;
        m--;
        n--;
        Node node1=head;
        for(int i=0;i<m;i++){
            node1=node1.next;
        }
        while(m<n){
            Node node2=node1;
            for(int i=0;i<(n-m);i++){
                node2=node2.next;
            }
            int number=node1.val;
            node1.val=node2.val;
            node2.val=number;
            node1=node1.next;
            m++;
            n--;
        }
        return head;
    }

    public Node reversePart(Node head,int from,int to){


        return head;
    }
}
class Node{
    public Node next;
    public int val;
    public Node(int val){
        this.val=val;
    }
    public String  toString(){
        String str="";
        Node node1=this;
        while(node1.next!=null){
            str+=node1.val+" ";
            node1=node1.next;
        }
        str+=node1.val;
        return str;
    }
}

