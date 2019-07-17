import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Stack;

public class Nowcoder {
    public static void main(String[] args) {
        //System.out.println(replaceString(new StringBuffer("goodjob")));
        //System.out.println(unionString(new StringBuffer("helo"),new StringBuffer("ok")));


        //反向输出链表
        ListNode listHead = new ListNode(0);
        ListNode p = null;
        int length = 20;
        for (int i = 1; i < length; i++) {
            ListNode listNode1 = new ListNode(i);
            if (listHead.next == null) {
                listHead.next = listNode1;
            }
            if (p != null) {
                p.next = listNode1;
            }
            p = listNode1;
        }
        ListNode l=new ListNode(1);
        l.next=new ListNode(2);
        l.next.next=new ListNode(2);
        l.next.next.next=new ListNode(3);
        ListNode newHead=deleteDuplication1(l);
        while(newHead!=null){
            System.out.println(newHead.val);
            newHead=newHead.next;
        }

        //删除链表节点

    }

    public static String replaceString(StringBuffer str) {
        if (str == null || str.length() <= 0)
            return null;
        int P1 = str.length() - 1;
        for (int i = 0; i <= P1; i++) {
            if (str.charAt(i) == ' ')
                str.append("  ");
        }
        int P2 = str.length() - 1;
        while (P1 >= 0 && P2 > P1) {
            char temp = str.charAt(P1--);
            if (temp == ' ') {
                str.setCharAt(P2--, '0');
                str.setCharAt(P2--, '2');
                str.setCharAt(P2--, '%');
            } else {
                str.setCharAt(P2--, temp);
            }
        }
        return str.toString();
    }

    public static String unionString(StringBuffer str1, StringBuffer str2) {
        str1.append(str2);
        return str1.toString();
    }

    //printListFromTailToHead1:错误的思路
    public static ArrayList<Integer> printListFromTailToHead1(ListNode listNode) {
        if (listNode == null)
            return null;
        int length = 0;
        ArrayList<Integer> arrayList = new ArrayList<>();
        while (listNode != null) {
            arrayList.add(listNode.val);
            length++;
            listNode = listNode.next;
        }
        ArrayList<Integer> arrayList1 = new ArrayList<>();
        for (int i = length - 1; i >= 0; i--) {
            arrayList1.add(arrayList.get(i));
        }
        return arrayList1;
    }

    //printListFromTailToHead2:使用递归
    public static ArrayList<Integer> printListFromTailToHead2(ListNode listNode) {
        ArrayList<Integer> ret = new ArrayList<>();
        if (listNode != null) {
            ret.addAll(printListFromTailToHead2(listNode.next));
            ret.add(listNode.val);
        }
        return ret;
    }

    //printListFromTailToHead3:使用头插法
    public static ArrayList<Integer> printListFromTailToHead3(ListNode listNode) {
        ListNode head = new ListNode(-1);
        while (listNode != null) {
            ListNode memo = listNode.next;
            listNode.next = head.next;
            head.next = listNode;
            listNode = memo;
        }
        ArrayList<Integer> array = new ArrayList<>();
        head=head.next;
        while(head!=null)
        {
            array.add(head.val);
            head = head.next;
        }
        return array;
    }

    //printListFromTailToHead4:使用栈
    public static ArrayList<Integer>printListFromTailToHead4(ListNode listNode){
        Stack<Integer>stack=new Stack<>();
        while(listNode!=null){
            stack.add(listNode.val);
            listNode=listNode.next;
        }
        ArrayList<Integer>arrayList=new ArrayList<>();
        while(!stack.isEmpty()){
            arrayList.add(stack.pop());
        }
        return arrayList;
    }

    public static boolean deleteNode(ListNode listNode,int val){
        while (listNode !=null){
            if(listNode.val==val){

                return true;
            }
            listNode=listNode.next;
        }

        return false;
    }

    //添加节点到尾部
    public static void addToTail(ListNode listNode,int val){
        ListNode newNode=new ListNode(val);
        if(listNode==null)
            listNode=newNode;
        else{
            while(listNode.next!=null){
                listNode=listNode.next;
            }
            listNode.next=newNode;
        }
    }

    //删除链表中重复的结点：解法一递归思想
    public static ListNode deleteDuplication(ListNode pHead) {
        if (pHead == null || pHead.next == null)
            return pHead;
        ListNode next = pHead.next;
        if (pHead.val == next.val) {
            while (next != null && pHead.val == next.val)
                next = next.next;
            return deleteDuplication(next);
        } else {
            pHead.next = deleteDuplication(pHead.next);
            return pHead;
        }
    }
    //删除链表中重复的结点：解法二
        public static ListNode deleteDuplication1(ListNode pHead)
        {
            if(pHead==null)
                return null;
            ListNode preNode=null;
            ListNode pNode=pHead;
            while(pNode!=null){
                ListNode nextNode=pNode.next;
                boolean needDelete=false;
                if(nextNode!=null && nextNode.val==pNode.val)
                    needDelete=true;
                if(!needDelete){
                    preNode=pNode;
                    pNode=pNode.next;
                }else{
                    int value=pNode.val;
                    ListNode toBeDel=pNode;
                    while(toBeDel!=null && toBeDel.val==value){
                        toBeDel=toBeDel.next;
                    }
                    if(preNode==null){
                        pHead=toBeDel;
                    }else{
                        preNode.next=toBeDel;
                    }
                    pNode=toBeDel;
                }
            }
            return pHead;

        }
}

class ListNode{
     int val;
     ListNode next=null;
     ListNode(int val) { this.val = val; }
}
