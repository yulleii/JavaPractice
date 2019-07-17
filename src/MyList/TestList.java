package MyList;

public class TestList {
    public static void main(String[] args) {
        MyLinkedList list=new MyLinkedList();
        list.addNode(5);
        list.addNode(5);
        list.addNode(5);
        list.addNode(5);
        System.out.println(list.length());
        list.addNode(5);
        list.deleteDuplicate2();
        System.out.println(list);


    }
}
