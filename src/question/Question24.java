package question;

public class Question24 {
    /*
    反转链表
     */
    //递归
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode next = head.next;
        ListNode newHead = reverseList(next);
        next.next = head;
        head.next = null;
        return newHead;
    }
    //头插法
    public ListNode ReverseList(ListNode head) {
        ListNode newList = new ListNode(-1);
        while (head != null) {
            ListNode next = head.next;
            head.next = newList.next;
            newList.next = head;
            head = next;
        }
        return newList.next;
    }
}

class ListNode{
    int data;
    ListNode next=null;
    public ListNode(int data){this.data=data;}
}
