package inbox;

public class TestV {
    public static void main(String[] args) {

        String s2=new String("now");
        String s1="now";
        String s3="now";

        Integer b=-129;
        Integer a=-129;
        char c='-';
        char cc='-';
        System.out.println(s1.hashCode());
        System.out.println(s2.hashCode());
        System.out.println(c==cc);

        son f=new son();
        System.out.println(f.x);
        f.father1();


    }
}
class father{
    public int x=1;
    public father(){
        System.out.println("im super father!");
    }
    public void father1(){
        System.out.println("father method1");
    }
}
class son extends father{
    public int x=2;
    public son(){
        super();
        System.out.println("im son!");
    }
    public void father1(){
        System.out.println("son method1");
    }
}
