package MyList;

import java.util.HashSet;
import java.util.Hashtable;
import java.util.Set;


public class MyLinkedList {
    Node head=null;
    //向链表插入数据
    public void addNode(int d){
        Node newNode=new Node(d);
        if(head==null){
            head=newNode;
            return;
        }
        Node tmp=head;
        while(tmp.next!=null){
            tmp=tmp.next;
        }
        tmp.next=newNode;
    }
    //删除第index个节点，成功返回true否则false
    public boolean deleteNode(int index){
        if(index<1 || index>length())
            return false;
        if(index==1){
            head=head.next;
            return true;
        }
        int i=1;
        Node preNode=head;
        Node curNode=preNode.next;
        while(curNode!=null){
            if(i==index){
                preNode.next=curNode.next;
                return true;
            }
            preNode=curNode;
            curNode=curNode.next;
            i++;
        }
        return true;
    }
    //删除值为value的节点
    /*
    无法解决如果是尾部连续的数字的情况
     */
    public void deleteVal(int value){
        Node preNode=head;
        Node curNode=preNode.next;
        if(preNode.data==value){
            head=head.next;
        }
        while(curNode!=null){
            if(curNode.data==value){
                preNode.next=curNode.next;
            }
            preNode=curNode;
            curNode=curNode.next;
        }
    }

    //删除链表的重复元素
    /*
    1.需要额外的空间hashTable/set
    2.双重循环遍历
     */
    public void deleteDuplicate(){
        Hashtable<Integer,Integer> hashtable=new Hashtable<>();
        Node tmp=head;
        Node pre=null;
        while(tmp!=null){
            if(hashtable.containsKey(tmp.data))
                pre.next=tmp.next;
            else{
                hashtable.put(tmp.data,1);
                pre=tmp;
            }
            tmp=tmp.next;
        }
    }

    public void deleteDuplicate1(){
        Set<Integer>set=new HashSet<>();
        Node tmp=head;
        Node pre=null;
        while(tmp!=null){
            if(set.contains(tmp.data))
                pre.next=tmp.next;
            else{
                set.add(tmp.data);
                pre=tmp;
            }
            tmp=tmp.next;
        }
    }

    public void deleteDuplicate2(){
        Node p=head;
        while(p!=null){
            Node q=p;
            while(q.next!=null){
                if(p.data==q.next.data){
                    q.next=q.next.next;
                }else
                    q=q.next;
            }
            p=p.next;
        }
    }
    //返回节点的长度
    public int length(){
        int length=0;
        Node tmp=head;
        while(tmp!=null){
            length++;
            tmp=tmp.next;
        }
        return length;
    }
    public Node orderList(){
        Node nextNode=null;
        Node curNode=head;
        int tmp=0;
        while(curNode!=null){
            nextNode=curNode.next;
            while(nextNode!=null){
                if(curNode.data>nextNode.data){
                    tmp=curNode.data;
                    curNode.data=nextNode.data;
                    nextNode.data=tmp;
                }
                nextNode=nextNode.next;
            }
            curNode=curNode.next;
        }
        return head;
    }
    public String toString(){
        StringBuilder str=new StringBuilder();
        Node tmp=head;
        str.append('[');
        while(tmp.next!=null){
            str.append(String.valueOf(tmp.data)+',');
            tmp=tmp.next;
        }
        str.append(String.valueOf(tmp.data)+']');
        return str.toString();
    }

}
