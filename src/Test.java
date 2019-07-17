public class Test {
    public static void main(String[] args) {
        String s=new StringBuilder("计算机").append("软件").toString();
        System.out.println(s.intern()==s);
        String s2=new StringBuilder("ja").append("va").toString();
        System.out.println(s2.intern()==s2);
        String str1 = "abc";
        String str2 = "abc";
        String str4 = new String("abc");
        System.out.println(str1==str2);
        System.out.println(str1==str4);
    }
}
